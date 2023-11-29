package hospital;

public class Informe {
	 private String tipo;
	 private String contenido;

	    
	 public Informe(String tipo, String contenido) {
		 this.tipo = tipo;
		 this.contenido = contenido;
	 }

	    
	 public String getTipo() {
		 return tipo;
	 }

	 public void setTipo(String tipo) {
		 this.tipo = tipo;
	 }

	 public String getContenido() {
		 return contenido;
	 }

	 public void setContenido(String contenido) {
		 this.contenido = contenido;
	 }

	    	
	 public void generarInforme() {
		 System.out.println("Informe generado:");
		 System.out.println("Tipo: " + tipo);
		 System.out.println("Contenido: " + contenido);
	 }

}
