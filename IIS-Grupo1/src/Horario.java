import javafx.util.Pair;

import java.util.*;


public class Horario {
    public Date inicio;
    public Date fin;
    public List<TramaHoraria> tramas = new ArrayList<>();
    public List<Asignatura> asignatura;

    public Horario(Date inicio, Date fin, List<Asignatura> asignatura) {
        if (inicio.getMonth() >= fin.getMonth() && inicio.getYear() >= fin.getYear() && fin.getDay() - inicio.getDay() < 7) {
            throw new HorarioException("No se puede crear horario de menos de una semana");
        } else {
            this.inicio = inicio;
            this.fin = inicio;
            asignatura.sort(new Comparator<>() {
                public int compare(Asignatura a1, Asignatura a2) {
                    return Integer.compare(a1.getDificultad(), a2.getDificultad());
                }
            });
            Collections.reverse(asignatura);
            this.asignatura = asignatura;
        }
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
            System.out.println(t.getAsignatura().getNombre());
            System.out.println("Dia:  " + t.getDia() + " " + t.getHoraInicio());
        }
    }

    public void mostrarHoras() {
        for (Asignatura t : asignatura) {
            System.out.println(t.getNombre() + ": " + t.getHoras());
        }
    }

    public List<TramaHoraria> getTramas() {
        return tramas;
    }

    public List<Asignatura> getAsignatura() {
        return asignatura;
    }
}
