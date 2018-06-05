
public class TramaHoraria {

    private double HoraInicio;
    private int Dia;
    private Asignatura asg;

    public TramaHoraria(double HoraInicio, int Dia) {
        this.HoraInicio = HoraInicio;
        this.Dia = Dia;
        this.asg = null;
    }

    public TramaHoraria(double HoraInicio, int Dia, Asignatura asg) {
        this.HoraInicio = HoraInicio;
        this.Dia = Dia;
        this.asg = asg;
    }

    public double getHoraInicio() {
        return HoraInicio;
    }

    public Asignatura getAsignatura() {
        return this.asg;
    }

    public void setAsignatura(Asignatura asg) {
        this.asg = asg;
    }

}
