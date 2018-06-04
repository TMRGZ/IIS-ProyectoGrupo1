import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class Principal {

	public static void main(String[] args) {
		
		List<TramaHoraria> tramas = new ArrayList<>();
		List<Asignatura> asig = new ArrayList<>();
		Date a = new Date(4, 4, 4);
		Date b = new Date(5, 5, 5);
		
		
		Asignatura a1 = new Asignatura("Pedro", 1, 6, 0, 0);
		Asignatura a2 = new Asignatura("Rajoy", 2, 7, 0, 0);
		Asignatura a3 = new Asignatura("Albert", 3, 9, 0, 0);
		
		
		asig.add(a1);
		asig.add(a2);
		asig.add(a3);

		Horario h = new Horario(a, b, asig);
		
		Map<Integer, List<Pair<Double, Double>>> dia = new HashMap<>();
		List<Pair<Double, Double>> l = new ArrayList<>();
		
		Pair<Double, Double> p1 = new Pair(new Double(12), new Double(21));
		l.add(p1);
		dia.put(0, l);
		h.repartirTramas(dia);
		h.asignarHoras();
		h.mostrarHoras();
	
		h.asignacionAsigTrama();
		h.mostrarTrama();
		
		
	}

}
