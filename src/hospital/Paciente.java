package hospital;

import java.time.LocalDate;

public class Paciente extends Persona {
	
	 private LocalDate fechaNacimiento;
	    private HistorialMedico historialMedico;
	    private String direccion;
	    private String telefono;

	public Paciente(String nombre, String apellido, LocalDate fechaNacimiento,
            HistorialMedico historialMedico, String direccion, String telefono) {
		super(nombre, apellido);
		// TODO Auto-generated constructor stub
		this.fechaNacimiento = fechaNacimiento;
        this.historialMedico = historialMedico;
        this.direccion = direccion;
        this.telefono = telefono;
	}
	
	public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public HistorialMedico getHistorialMedico() {
        return historialMedico;
    }

    public void setHistorialMedico(HistorialMedico historialMedico) {
        this.historialMedico = historialMedico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

	@Override
	public void realizarAccionEspecifica() {
		// TODO Auto-generated method stub
		System.out.println("1. Programar una cita médica.");
        programarCitaMedica();
        System.out.println("2. Consultar su historial médico.");
        consultarHistorialMedico();
        System.out.println("3. Ver detalles de facturación.");
        verDetallesFacturacion();
		
	}
	
	 private void programarCitaMedica() {
	        System.out.println("Cita médica programada.");
	    }

	 private void consultarHistorialMedico() {
		 System.out.println("Historial médico consultado.");
	 }

	 private void verDetallesFacturacion() {
		 System.out.println("Detalles de facturación visualizados.");
	 }

}
