/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.musicstore.shiro;

/**
 *
 * @author if.garcia11
 */

   import java.util.Properties;

   public class ApiKeyEnvVariables extends Properties {

       public ApiKeyEnvVariables() {
           super.put("apiKey.id", System.getenv("STORMPATH_API_KEY_ID"));
           super.put("apiKey.secret", System.getenv("STORMPATH_API_KEY_SECRET"));
       }
   }