var cliente='<li ><a href="#/shoppingCart"><span class="glyphicon glyphicon-shopping-cart" ></span> My Shopping Cart </a></li>'
var proveedor='<li ><a href="#/album">Album </a></li>'+
              '<li ><a href="#/longPlay">Long Play </a></li>';
var administrador='<li ><a href="#/provider">Provider </a></li>'+
                  '<li ><a href="#/client">Client </a></li>';
var sinUsuario='<li ><a href="#/shoppingCart"><span class="glyphicon glyphicon-shopping-cart" ></span> My Shopping Cart </a></li>';

function authorization(){
var ul=$("#menu");
ul.contents().filter(function () {
    return this.id != "login";
}).remove();
ul.prepend(sinUsuario);
    var archivoValidacion = "http://localhost:8080/MusicStore.web/webresources/users/currentUser";    
        $.getJSON( archivoValidacion, { })
            .done(function(respuestaServer) {
                ul.contents().filter(function () {
                    return this.id != "login";
                }).remove();
                switch(respuestaServer.role) {
                    case 'user':
                        ul.prepend(cliente);
                        break;
                    case 'provider':
                        ul.prepend(proveedor);
                        break;
                    case 'admin':
                        ul.prepend(administrador);
                        break;
                }
               
                if (respuestaServer=="error"){
                    $("#errorLogin").show();
                }else{
                    
                }
            });
    

}

