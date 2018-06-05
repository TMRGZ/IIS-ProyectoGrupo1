import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class HorarioTest {
    private Horario h;
    private Alumno a;
    List<Examen> examenes = new ArrayList<>();
    Asignatura a1 = new Asignatura("Calculo", 1, 6, 0, 0, examenes);
    Asignatura a2 = new Asignatura("Discretas", 2, 7, 0, 0, examenes);
    Asignatura a3 = new Asignatura("Redes", 3, 9, 0, 0, examenes);
    private List<Asignatura> listaAsignaturas = new ArrayList<>();
    private Date fechaInicio = new Date(4, 4, 4);


    @Before
    public void inicializacion() {
        listaAsignaturas.add(a1);
        listaAsignaturas.add(a2);
        listaAsignaturas.add(a3);

        h = new Horario(fechaInicio, fechaInicio, listaAsignaturas);
        a = mock(Alumno.class);
    }


    @Test
    public void constructorCreaBien() { // Incicializa sin tramas pero con asig
        assertEquals(0, h.getTramas().size());
        assertEquals(listaAsignaturas.size(), h.getAsignatura().size());
    }

    @Test
    public void horarioTieneAsignaturasDeAlumno() {
        when(a.getAsignaturas()).thenReturn(listaAsignaturas);


    }

    @Test
    public void tramaAsociaAsignaturas() {

    }


}
