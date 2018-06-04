import java.util.Date;
import java.util.List;

public class Asignatura {
	
	private String nombre;
	private int id;
	private int Dificultad;
	private int nHoras;
	private int Valoracion;
	private List<Examen> examenes;
	
	public Asignatura(String nombre, int id, int Dificultad, int nHoras, int Valoracion, List<Examen> examenes) {
		this.nombre = nombre;
		this.id = id;
		this.Dificultad = Dificultad;
		this.nHoras = nHoras;
		this.Valoracion = Valoracion;
		this.examenes = examenes;
	}
	
	public void calcularDificultad(int dificultadesbase[]) {
		int aux = 1;
		for(int i = 0; i < dificultadesbase.length; i++) {
			aux *= dificultadesbase[i];
		}
		Dificultad = (int) Math.pow(aux, 1/dificultadesbase.length);
		
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getDificultad() {
		return this.Dificultad;
	}
	
	public int CalcularDifBase(int Nota, int notas[]) {
		double factor = 1;
		for(int i = 0; i < notas.length; i++) {
			factor *= notas[i];
		}
		factor = (1-Math.abs(Nota-Math.pow(factor, 1/notas.length))/10);
		return (int) ((10 - Nota)*0.5 + Valoracion*0.5*factor);
	}
	
	public boolean hayExamen(Date hoy) {
		boolean hay = false;
		for(Examen e : examenes) {
			if(e.getFecha().getTime()-hoy.getTime() <= 28) hay = true;
		}
		return hay;
	}
}
