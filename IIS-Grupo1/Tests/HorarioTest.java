import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


public class HorarioTest {
    private Alumno a;
    private List<Examen> examenes = new ArrayList<>();
    private Asignatura a1 = new Asignatura("Calculo", 1, 6, 0, 0, examenes);
    private Asignatura a2 = new Asignatura("Discretas", 2, 7, 0, 0, examenes);
    private Asignatura a3 = new Asignatura("Redes", 3, 9, 0, 0, examenes);
    private List<Asignatura> listaAsignaturas = new ArrayList<>();
    private Date fechaInicio = new Date(4, 4, 4);
    private Date fechaFin = new Date(5, 5, 5);
    private Map<Integer, List<Pair<Double, Double>>> dia = new HashMap<>();
    private List<Pair<Double, Double>> l = new ArrayList<>();
    private List<Pair<Double, Double>> l2 = new ArrayList<>();
    private Pair<Double, Double> p1;
    private Pair<Double, Double> p2;


    @Before
    public void inicializacion() {
        listaAsignaturas.add(a1);
        listaAsignaturas.add(a2);
        listaAsignaturas.add(a3);

        a = mock(Alumno.class);
        p1 = new Pair<>(12d, 14d);
        p2 = new Pair<>(16d, 20d);
    }

    @Before
    public void resetSingleton() throws NoSuchFieldException, IllegalAccessException {
        Field HorarioUnico = Horario.class.getDeclaredField("HorarioUnico");
        HorarioUnico.setAccessible(true);
        HorarioUnico.set(null, null);
    }


    @Test
    public void constructorCreaBien() { // Incicializa sin tramas pero con asig
        Horario h = Horario.Instancia(fechaInicio, fechaFin, listaAsignaturas);

        assertEquals(0, h.getTramas().size());
        assertEquals(listaAsignaturas.size(), h.getAsignatura().size());
    }

    @Test
    public void horarioTieneAsignaturasDeAlumno() {
        Horario h = Horario.Instancia(fechaInicio, fechaFin, listaAsignaturas);

        when(a.getAsignaturas()).thenReturn(listaAsignaturas);
        assertEquals(a.getAsignaturas(), h.asignatura);
        verify(a).getAsignaturas();
    }

    @Test
    public void tramasRepartidasVacias() {
        Horario h = Horario.Instancia(fechaInicio, fechaFin, listaAsignaturas);

        l.add(p1);
        l2.add(p2);
        dia.put(0, l);
        dia.put(1, l2);

        h.repartirTramas(dia);

        for (TramaHoraria th : h.getTramas()) {
            assertNull(th.getAsignatura());
        }
    }

    @Test
    public void asignturaBienAñadidaEnHorario() {
        Horario h = Horario.Instancia(fechaInicio, fechaFin, listaAsignaturas);

        l.add(p1);
        l2.add(p2);
        dia.put(0, l);
        dia.put(1, l2);

        h.repartirTramas(dia);
        h.asignacionAsigTrama();

        assertEquals(h.getTramas().get(0).getAsignatura(), a3);
        assertEquals(h.getTramas().get(2).getAsignatura(), a2);
    }

    @Test(expected = HorarioException.class)
    public void errorSiDuracionInvalida() {
        Horario h = Horario.Instancia(fechaInicio, fechaInicio, listaAsignaturas);
    }

}
