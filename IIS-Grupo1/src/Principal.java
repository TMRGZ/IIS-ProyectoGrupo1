import javafx.util.Pair;

import java.util.*;

public class Principal {

    public static void main(String[] args) {

        List<Asignatura> asig = new ArrayList<>();
        Date a = new Date(4, 4, 4);
        Date b = new Date(5, 5, 5);


        Asignatura a1 = new Asignatura("Pedro", 1, 6, 0, 0);
        Asignatura a2 = new Asignatura("Rajoy", 2, 7, 0, 0);
        Asignatura a3 = new Asignatura("Albert", 3, 9, 0, 0);


        asig.add(a1);
        asig.add(a2);
        asig.add(a3);

        Horario h = new Horario(a, asig);

        Map<Integer, List<Pair<Double, Double>>> dia = new HashMap<>();
        List<Pair<Double, Double>> l = new ArrayList<>();

        Pair<Double, Double> p1 = new Pair<>(12d, 21d);
        l.add(p1);
        dia.put(0, l);
        h.repartirTramas(dia);
        h.asignarHoras();
        h.mostrarHoras();

        h.asignacionAsigTrama();
        h.mostrarTrama();


    }

}
