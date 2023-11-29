package hospital;

public class Facturacion {
	private String tipoFactura;
    private double monto;
    private String estadoPago;

    
    public Facturacion(String tipoFactura, double monto, String estadoPago) {
        this.tipoFactura = tipoFactura;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }

    
    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
    
    public void registrarPago() {
        System.out.println("Pago registrado exitosamente.");
    }

}
