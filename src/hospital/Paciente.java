package hospital;

import java.time.LocalDate;

public class Paciente extends Persona {
	
	 private LocalDate fechaNacimiento;
     private String direccion;
     private String telefono;

	public Paciente(String nombre, String apellido, LocalDate fechaNacimiento,
            String direccion, String telefono) {
		super(nombre, apellido);
		// TODO Auto-generated constructor stub
		this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
	}
	
	public Paciente(String nombre, String apellido, LocalDate fechaNacimiento, String direccion) {
		super(nombre, apellido);
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.telefono = "No proporcionado.";
	}
	
	public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
}
