package hospital;

public class Medicamento {
	
    private String nombre;
    private double precio;
    private int stock;

    
    public Medicamento(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    
    public String getNombre() {
    	return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    public void actualizarStock(int cantidad) {
         if (cantidad >= 0) {
            stock += cantidad;
            System.out.println("Stock actualizado. Nuevo stock: " + stock);
        } else {
            System.out.println("La cantidad debe ser mayor o igual a cero.");
        }

    }
}
