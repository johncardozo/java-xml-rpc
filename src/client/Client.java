package client;
/*
 * Librería xmlrpc:
 * http://archive.apache.org/dist/ws/xmlrpc/binaries/apache-xmlrpc-3.1.3-bin.zip
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
    
public class Client {

	public static void main(String[] args) {
		
		// Crea la configuración del cliente
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		try {
			config.setServerURL(new URL("http://127.0.0.1:8080/xmlrpc"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// Crea el cliente y asigna la configuración
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);

		/*
		 * ---------------- EJEMPLO 1 ---------------- 
		 */		
		
		// Crea los parámetros del servicio remoto (clase Calculator)
		Object[] params = new Object[] { Integer.valueOf(33), Integer.valueOf(7) };
		try {
			// Ejecuta el método add en la clase Calculator con sus respectivos parámetros
			Integer result = (Integer) client.execute("Calculator.add", params);
			// Imprime el resultado
			System.out.println("El resultado fue " + result.toString());
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}

		/*
		 * ---------------- EJEMPLO 2 ---------------- 
		 */
		
		// Crea los parámetros del servicio remoto (clase Servicios)
		Object[] params1 = new Object[] { Integer.valueOf(3), "esta es una cadena" };
		Object[] params2 = new Object[] { Boolean.valueOf(true) };
		Object[] params3 = new Object[] { Double.valueOf(2.34) };
		
		try {
			// ejecuta los métodos en la clase Servicios con sus respectivos parámetros
			Boolean r1 = (Boolean) client.execute("Servicios.metodo1", params1);
			String r2 = (String) client.execute("Servicios.metodo2", params2);
			Double r3 = (Double) client.execute("Servicios.metodo3", params3);
			
			// Imprime el resultado
			System.out.println(r1);
			System.out.println(r2);
			System.out.println(r3);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
