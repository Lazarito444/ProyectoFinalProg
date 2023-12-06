package hospital;

public class Personal extends Persona implements IPersonal {
	
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
	
	public Personal(String nombre, String apellido, String usuario, String contrasena) {
		super(nombre, apellido);
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.rol = "No establecido";
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

	public void generarInformesMedicos() {
        System.out.println("Informes médicos generados.");
    }

	public void atenderPaciente() {
		System.out.println("Atendiendo al paciente");
	}
}