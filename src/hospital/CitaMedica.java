package hospital;

import java.time.LocalDate;
import java.time.LocalTime;

public class CitaMedica {
	private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;
    private Personal medico;

    
    public CitaMedica(LocalDate fecha, LocalTime hora, Paciente paciente, Personal medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.medico = medico;
    }

    
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Personal getMedico() {
        return medico;
    }

    public void setMedico(Personal medico) {
        this.medico = medico;
    }
 
    public void programarCita(LocalDate nuevaFecha, LocalTime nuevahora, Paciente nuevoPaciente, Personal nuevoMedico) {
        this.fecha = nuevaFecha;
        this.hora = nuevahora;
        this.paciente = nuevoPaciente;
        this.medico = nuevoMedico;
    }
}
