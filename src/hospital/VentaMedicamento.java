package hospital;

public class VentaMedicamento { 
	private int ID_medicamento;
	private int ID_cliente;
    private int cantidad;

    
    public VentaMedicamento(int id_medicamento, int cantidad, int id_cliente) {
        this.ID_medicamento = id_medicamento;
        this.cantidad = cantidad;
        this.ID_cliente = id_cliente;
    }
    
    public int getID_medicamento() {
		return ID_medicamento;
	}
    
	public void setID_medicamento(int iD_medicamento) {
		ID_medicamento = iD_medicamento;
	}

	public int getID_cliente() {
		return ID_cliente;
	}

	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void realizarVenta() {
    	System.out.println("Venta realizada con éxito!");
    }
}