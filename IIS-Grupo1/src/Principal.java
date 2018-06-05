import javafx.util.Pair;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		List<TramaHoraria> tramas = new ArrayList<>();
		List<Asignatura> asig = new ArrayList<>();
		Date a = new Date(4, 4, 4);
		Date b = new Date(5, 5, 5);
		List<Examen> examenes = new ArrayList<>();

		Asignatura a1 = new Asignatura("Calculo", 1, 6, 0, 0, examenes);
		Asignatura a2 = new Asignatura("Discretas", 2, 7, 0, 0, examenes);
		Asignatura a3 = new Asignatura("Redes", 3, 9, 0, 0, examenes);


		asig.add(a1);
		asig.add(a2);
		asig.add(a3);

		Horario h = new Horario(a, b, asig);

		Map<Integer, List<Pair<Double, Double>>> dia = new HashMap<>();
		List<Pair<Double, Double>> l = new ArrayList<>();
		List<Pair<Double, Double>> l2 = new ArrayList<>();

		Pair<Double, Double> p1 = new Pair(new Double(12), new Double(14));
		Pair<Double, Double> p2 = new Pair(new Double(16), new Double(20));
		l.add(p1);
		l2.add(p2);
		dia.put(0, l);
		dia.put(1, l2);

		h.repartirTramas(dia);
		h.asignarHoras();
		h.mostrarHoras();

		h.asignacionAsigTrama();
		h.mostrarTrama();


	}

}
