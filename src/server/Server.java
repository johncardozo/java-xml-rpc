package server;
/*
 * Librería xmlrpc:
 * http://archive.apache.org/dist/ws/xmlrpc/binaries/apache-xmlrpc-3.1.3-bin.zip
 */

import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

  public class Server {
      private static final int port = 8080;

      public static void main(String[] args) throws Exception {

    	  // Crea el servidor web
          WebServer webServer = new WebServer(port);
        
          // Crea el servidor xmlRpc sobre el servidor web
          XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();
        
          // Crea el administrador de clases y agrega las clases que exponen servicios (métodos)
          PropertyHandlerMapping phm = new PropertyHandlerMapping();
          phm.addHandler("Calculator", server.Calculator.class);
          phm.addHandler("Servicios", server.Servicios.class);
          
          // Agrega el administrador de clases al servidor xmlRpc 
          xmlRpcServer.setHandlerMapping(phm);
        
          // Configura el servidor xmlRpc
          XmlRpcServerConfigImpl serverConfig = (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
          serverConfig.setEnabledForExtensions(true);
          serverConfig.setContentLengthOptional(false);

          // Inicia el servidor web
          webServer.start();          
      }
  }