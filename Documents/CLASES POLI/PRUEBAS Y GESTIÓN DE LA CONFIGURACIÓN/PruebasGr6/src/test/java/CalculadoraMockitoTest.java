import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.when;
import org.mockito.Mock;

public class CalculadoraMockitoTest {

    @Mock
    Calculadora calculadora = new Calculadora();

    @Before
    public void iniciar_mock(){
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void suma(){
        int esperado = 3;
        when(calculadora.suma(6,2)).thenReturn(esperado);
        Assert.assertEquals(esperado,calculadora.suma(6,2));
    }

    @Test
    public void sumaincorrecta(){
        int esperado = -2;
        when(calculadora.suma(6,2)).thenReturn(esperado);
        Assert.assertNotEquals(esperado,calculadora.suma(6,2));
    }

    @Test
    public void resta(){
        int esperado = 4;
        when(calculadora.resta(6,2)).thenReturn(esperado);
        Assert.assertEquals(esperado,calculadora.resta(6,2));
    }

    @Test
    public void restaincorrecta(){
        int esperado = 3;
        when(calculadora.resta(6,2)).thenReturn(esperado);
        Assert.assertNotEquals(esperado,calculadora.resta(6,2));
    }

    @Test
    public void restanegativa(){
        int esperado = -10;
        when(calculadora.resta(6,2)).thenReturn(esperado);
        Assert.assertEquals(esperado,calculadora.resta(6,2));
    }


    @Test
    public void multiplicacion(){
        int esperado = 12;
        when(calculadora.multiplicacion(6,2)).thenReturn(esperado);
        Assert.assertEquals(esperado,calculadora.multiplicacion(6,2));
    }

    @Test
    public void multiplicacionmala(){
        int esperado = -2;
        when(calculadora.multiplicacion(6,2)).thenReturn(esperado);
        Assert.assertNotEquals(esperado,calculadora.multiplicacion(6,2));
    }

    @Test
    public void division(){
        int esperado = 0;
        when(calculadora.division(6,2)).thenReturn(esperado);
        Assert.assertEquals(esperado,calculadora.division(6,2));
    }

    @Test
    public void divisionmala(){
        int esperado = 4;
        when(calculadora.division(6,2)).thenReturn(esperado);
        Assert.assertNotEquals(esperado,calculadora.division(6,2));

    }
}
