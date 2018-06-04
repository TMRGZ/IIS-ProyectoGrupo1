import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;


public class Horario {

	public Date inicio;
	public Date fin;
	
	
	
	public List<TramaHoraria> tramas = new ArrayList<>();
	public List<Asignatura> asignatura = new ArrayList<>();
	public Horario(Date inicio, Date fin, List<Asignatura> asignatura) {
		this.inicio = inicio;
		this.fin = inicio;
		Collections.sort(asignatura, new Comparator<Asignatura>() {
			public int compare(Asignatura a1, Asignatura a2) {
				return new Integer(a1.getDificultad()).compareTo(new Integer(a2.getDificultad()));
			}
		});
		Collections.reverse(asignatura);
		this.asignatura = asignatura;
	}
	
	public void repartirTramas(Map<Integer, List<Pair<Double, Double>>> dia) {
		
		for(Integer d : dia.keySet()) {
			for(Pair<Double, Double> p : dia.get(d)) {
				double inic = p.getKey();
				double fin = p.getValue();
				while(inic < fin) {
					TramaHoraria tr = new TramaHoraria(inic, d);
					tramas.add(tr);
					inic++;
				}
			}
		}
		
	}
	
	public void asignarHoras(){
		int hL = horasLibres();
		int dt = totalDificultad();
		double dif;
		for(Asignatura a : asignatura) {
			dif = (a.getDificultad() * hL) / dt;
			a.setHoras((int) dif);
		}
	}
	
	public void asignacionAsigTrama() {
		int cont = 0;
		int ctramas = 0;
		int casig = 0;
		int tramasA = 0;
		while(tramasA < horasLibres()) {
			while(cont < 2 && asignatura.get(casig).getHoras() > 0) {
				tramas.get(ctramas).as
				
			}
			
		}
	}
	
	private int horasLibres() {
		return tramas.size();
	}
	
	private int totalDificultad() {
		int n = 0;
		for(Asignatura a: asignatura) {
			n = n + a.getDificultad();
		}
		return n;
	}
}
