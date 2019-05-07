package server;

public class Servicios {
	
    public boolean metodo1(int numero, String cadena) {
    	System.out.println(numero);
    	System.out.println(cadena);
    	
    	return cadena.length() > 2;
    }
    
    public String metodo2(boolean valor) {
    	System.out.println(valor);
    	return "nice";
    }
    
    public double metodo3(double valor) {
    	System.out.println(valor);
    	return 3.1416;
    }	

}
