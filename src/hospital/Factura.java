package hospital;

public class Factura {
	private String tipoFactura;
    private double monto;
    private String razon;

    
    public Factura(String tipoFactura, double monto, String razon) {
        this.tipoFactura = tipoFactura;
        this.monto = monto;
        this.razon = razon;
    }
    
    public Factura(String tipoFactura, double monto) {
        this.tipoFactura = tipoFactura;
        this.monto = monto;
        this.razon = "No especificada";
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

    public String getRazon() {
        return razon;
    }

    public void setEstadoPago(String razon) {
        this.razon = razon;
    }
    
    public void registrarPago() {
        System.out.println("Pago registrado exitosamente.");
    }

}
