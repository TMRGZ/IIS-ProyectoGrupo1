import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class HorarioTest {
    private Horario h;
    private TramaHoraria th;
    private Asignatura a1 = new Asignatura("A1", 1, 1, 5, 0);
    private Asignatura a2 = new Asignatura("A2", 2, 2, 6, 0);
    private Asignatura a3 = new Asignatura("A3", 3, 3, 7, 0);
    private List<Asignatura> listaAsignaturas = new ArrayList<>();
    private Date fechaInicio = new Date(4, 4, 4);


    @Before
    public void inicializacion() {
        listaAsignaturas.add(a1);
        listaAsignaturas.add(a2);
        listaAsignaturas.add(a3);

        h = new Horario(fechaInicio, listaAsignaturas);
        th = mock(TramaHoraria.class);
    }


    @Test
    public void constructorCreaVacio() { // Incicializa sin tramas ni examenes
        assertEquals(0, h.getTramas().size());
        assertEquals(0, h.getExamenes().size());
    }

    @Test
    public void insertaTramaBien() {
        int nTramasAnterior = h.getTramas().size();


    }

    @Test
    public void tramaAsociaAsignaturas() {
        verify(th).setAsignatura(a1);
    }


}
