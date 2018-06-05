import javafx.util.Pair;

import java.util.*;


public class Horario {
    public Date inicio;
    public Date fin;
    public List<TramaHoraria> tramas = new ArrayList<>();
    public List<Asignatura> asignatura;
    public List<Examen> examenes;

    public Horario(Date inicio, List<Asignatura> asignatura) {
        this.inicio = inicio;
        this.fin = inicio;
        asignatura.sort(Comparator.comparing(Asignatura::getDificultad));
        Collections.reverse(asignatura);
        this.asignatura = asignatura;
        this.examenes = new ArrayList<>();
    }

    public Horario(Date inicio, List<Asignatura> asignatura, List<Examen> listaExamenes) {
        this.inicio = inicio;
        this.fin = inicio;
        asignatura.sort(Comparator.comparing(Asignatura::getDificultad));
        Collections.reverse(asignatura);
        this.asignatura = asignatura;
        this.examenes = listaExamenes;
    }

    public void repartirTramas(Map<Integer, List<Pair<Double, Double>>> dia) {
        for (Integer d : dia.keySet()) {
            for (Pair<Double, Double> p : dia.get(d)) {
                Double inic = p.getKey();
                Double fin = p.getValue();
                while (inic < fin) {
                    TramaHoraria tr = new TramaHoraria(inic, d);
                    tramas.add(tr);
                    inic++;
                }
            }
        }

    }

    public void asignarHoras() {
        int hL = horasLibres();
        int dt = totalDificultad();
        double dif;
        for (Asignatura a : asignatura) {
            dif = (a.getDificultad() * hL) / dt;
            a.setHoras((int) dif);
        }
    }

    public void asignacionAsigTrama() {
        int cont = 0;
        int ctramas = 0;
        int casig = 0;
        int tramasA = 0;
        Asignatura asg;

        while (tramasA < horasLibres()) {
            asg = asignatura.get(casig);
            cont = 0;

            while (cont < 2 && asg.getHoras() > 0) {
                tramas.get(ctramas).setAsignatura(asg);
                cont++;
                ctramas++;
                tramasA++;
                asg.setHoras(asg.getHoras() - 1);
            }

            if (todasAsig() && tramasA < horasLibres()) {

                if (asignatura.get(0).compareTo(asg) != 0) cont = 0;
                casig = 0;

                while (tramasA < horasLibres()) {
                    asg = asignatura.get(casig);
                    tramas.get(ctramas).setAsignatura(asg);
                    cont++;

                    if (cont == 2) {
                        casig = (casig + 1) % asignatura.size();

                    }

                    ctramas++;
                    tramasA++;
                }
            }
            casig = (casig + 1) % asignatura.size();
        }
    }

    private int horasLibres() {
        return tramas.size();
    }

    private boolean todasAsig() { //Falso cuando no estan todas asignadas
        int i = 0;
        while (i < asignatura.size() && asignatura.get(i).getHoras() == 0) i++;
        return i == asignatura.size();
    }

    private int totalDificultad() {
        int n = 0;
        for (Asignatura a : asignatura) {
            n = n + a.getDificultad();
        }
        return n;
    }

    public void setAsignatura(List<Asignatura> asignatura) {
        this.asignatura = asignatura;
    }

    public void mostrarTrama() {
        for (TramaHoraria t : tramas) {
            System.out.println(t.getHoraInicio());
            System.out.println(t.getAsignatura().getNombre());
        }
    }

    public void mostrarHoras() {
        for (Asignatura t : asignatura) {
            System.out.println(t.getHoras());

        }
    }

    public List<Examen> getExamenes() {
        return examenes;
    }

    public List<TramaHoraria> getTramas() {
        return tramas;
    }

    public Date getInicio() {
        return inicio;
    }

    public Date getFin() {
        return fin;
    }
}
