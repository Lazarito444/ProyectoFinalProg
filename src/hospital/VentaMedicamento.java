package hospital;

public class VentaMedicamento {
	private Medicamento medicamento; 
    private double precio;
    private int cantidad;
    private Paciente cliente;

    
    public VentaMedicamento(Medicamento medicamento, double precio, int cantidad, Paciente cliente) {
        this.medicamento = medicamento;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cliente = cliente;
    }

    
    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Paciente getCliente() {
        return cliente;
    }

    public void setCliente(Paciente cliente) {
        this.cliente = cliente;
    }

    
    public void realizarVenta() {
    	if (medicamento.getStock() >= cantidad) {
            medicamento.actualizarStock(-cantidad);

            System.out.println("Venta realizada con éxito");
        } else {
            System.out.println("No hay suficiente stock para realizar la venta");
        }
    }

}
