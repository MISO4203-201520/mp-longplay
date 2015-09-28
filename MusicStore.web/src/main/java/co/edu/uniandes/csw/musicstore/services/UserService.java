/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.services;

import co.edu.uniandes.csw.musicstore.api.IClientLogic;
import co.edu.uniandes.csw.musicstore.api.IProviderLogic;
import co.edu.uniandes.csw.musicstore.dtos.ClientDTO;
import co.edu.uniandes.csw.musicstore.dtos.ProviderDTO;
import co.edu.uniandes.csw.musicstore.dtos.UserDTO;
import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.account.AccountStatus;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.client.ApiKey;
import com.stormpath.sdk.client.ApiKeys;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import com.stormpath.sdk.group.Group;
import com.stormpath.sdk.group.GroupList;
import com.stormpath.sdk.resource.ResourceException;
import com.stormpath.shiro.realm.ApplicationRealm;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Jhonatan
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

    @Inject
    private IClientLogic clientLogic;

    @Inject
    private IProviderLogic artistLogic;

    @Path("/login")
    @POST
    public Response login(UserDTO user) {
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword(), user.isRememberMe());
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            ClientDTO client = clientLogic.getClientByUserId(currentUser.getPrincipal().toString());
            if (client != null) {
                currentUser.getSession().setAttribute("Client", client);
                return Response.ok(client).build();
            } else {
                ProviderDTO provider = artistLogic.getArtistByUserId(currentUser.getPrincipal().toString());
                if (provider != null) {
                    currentUser.getSession().setAttribute("Provider", provider);
                    return Response.ok(provider).build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(" User is not registered")
                            .type(MediaType.TEXT_PLAIN)
                            .build();
                }
            }
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @Path("/logout")
    @GET
    public Response logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/currentUser")
    @GET
    public Response getCurrentUser() {
        UserDTO user = new UserDTO();
        try {
            
            
            Subject currentUser = SecurityUtils.getSubject();
            Map<String, String> userAttributes = (Map<String, String>) currentUser.getPrincipals().oneByType(java.util.Map.class);
            user.setName(userAttributes.get("givenName") + " " + userAttributes.get("surname"));
            user.setEmail(userAttributes.get("email"));
            user.setUserName(userAttributes.get("username"));
            
            String path = "C:\\.stormpath/apiKey.properties";
            ApiKey apiKey = ApiKeys.builder().setFileLocation(path).build();
            Client client = Clients.builder().setApiKey(apiKey).build();
            Account account = client.getResource(currentUser.getPrincipal().toString(), Account.class);
            GroupList groups = account.getGroups();
            String nomgreGrupo="";
            for(Group grp : groups) {
                nomgreGrupo=grp.getName();
            }        
            user.setRole(nomgreGrupo);
            return Response.ok(user).build();
        } catch (AuthenticationException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @Path("/register")
    @POST
    public Response setUser(UserDTO user) {
        try {
            Account account = createUser(user);
            switch (user.getRole()) {
                case "user":
                    ClientDTO client = new ClientDTO();
                    client.setName(user.getUserName());
                    client.setUserId(account.getHref());
                    clientLogic.createClient(client);
                    break;

                case "provider":
                    ProviderDTO artist = new ProviderDTO();
                    artist.setName(user.getUserName());
                    artist.setUserId(account.getHref());
                    artistLogic.createProvider(artist);
                    break;
            }
            return Response.ok().build();
        } catch (ResourceException e) {
            return Response.status(e.getStatus())
                    .entity(e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
    
    @Path("/findAll")
    @GET
    public Response findAll() {
        try {
            StringBuilder response = new StringBuilder();
            response.append("CLIENTS: \n\n");
            for(ClientDTO cdto : clientLogic.getAllClients()) {
                response.append(cdto.getId());
                response.append(" : ");
                response.append(cdto.getName());
                response.append("\n");
            }
            
            response.append("\n\nPROVIDERS: \n\n");
            for(ProviderDTO pdto : artistLogic.getAllProviders()) {
                response.append(pdto.getId());
                response.append(" : ");
                response.append(pdto.getName());
                response.append("\n");
            }   
            
            //return clientLogic.getClients(1, 1);
            return Response.ok()
                    //.entity(clientLogic.getClients(0, 2))
                    .entity(response.toString())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        } catch (Exception e) {
            return null;//Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    private Account createUser(UserDTO user) {
        ApplicationRealm realm = ((ApplicationRealm) ((RealmSecurityManager) SecurityUtils.getSecurityManager()).getRealms().iterator().next());
        Client client = realm.getClient();
        Application application = client.getResource(realm.getApplicationRestUrl(), Application.class);
        Account acct = client.instantiate(Account.class);
        acct.setUsername(user.getUserName());
        acct.setPassword(user.getPassword());
        acct.setEmail(user.getEmail());
        acct.setGivenName(user.getName());
        acct.setSurname(user.getLastName());
        acct.setStatus(AccountStatus.ENABLED);
        GroupList groups = application.getGroups();
        for (Group grp : groups) {
            if (grp.getName().equals(user.getRole())) {
                acct = application.createAccount(acct);
                acct.addGroup(grp);
                break;
            }
        }
        return acct;
    }
}
