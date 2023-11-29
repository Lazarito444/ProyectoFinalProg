package hospital;

public class Personal extends Persona {
	
	private String usuario;
    private String contrasena;
    private String rol;

	public Personal(String nombre, String apellido, String usuario, String contrasena, String rol) {
		super(nombre, apellido);
		// TODO Auto-generated constructor stub
		this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
	}
	
	public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

	@Override
	public void realizarAccionEspecifica() {
		// TODO Auto-generated method stub
		System.out.println("1. Asignar turnos a pacientes.");
        asignarTurnos();
        System.out.println("2. Generar informes médicos.");
        generarInformesMedicos();
	}
	private void asignarTurnos() {
        System.out.println("Turnos asignados a pacientes.");
    }

    private void generarInformesMedicos() {
        System.out.println("Informes médicos generados.");
    }

}
