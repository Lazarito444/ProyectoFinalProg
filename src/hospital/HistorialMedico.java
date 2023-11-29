package hospital;

import java.time.LocalDate;

public class HistorialMedico {
	private Paciente paciente;
    private String entradas;

    public HistorialMedico(Paciente paciente, String entradas) {
        this.paciente = paciente;
        this.entradas = entradas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public void agregarEntrada(LocalDate fecha, String detalles) {
        System.out.println("Entrada agregada al historial médico de " + paciente.getNombre() + " " + paciente.getApellido());
        System.out.println("Fecha: " + fecha);
        System.out.println("Detalles: " + detalles);
    }

}
