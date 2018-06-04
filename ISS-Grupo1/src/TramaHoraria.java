
public class TramaHoraria {

	private double HoraInicio;
	private int Dia;
	private Asignatura asg;
	
	public TramaHoraria(double HoraInicio, int Dia) {
		this.HoraInicio = HoraInicio;
		this.Dia = Dia;
		this.asg = null;
	}
	public double getHoraInicio() {
		return HoraInicio;
	}
	
	public Asignatura getAsignatura() {
		return this.asg;
	}
	
	public int getDia() {
		return this.Dia;
	}
	
	public void setAsignatura(Asignatura asg) {
		this.asg = asg;
	}

}
