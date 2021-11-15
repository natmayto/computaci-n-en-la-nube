import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    public void suma(){
        int resultado = calculadora.suma(6, 2);
        int esperado = 8;
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void sumaincorrecta(){
        int resultado = calculadora.suma(6, 2);
        int esperado = 7;
        Assert.assertNotEquals(esperado, resultado);
    }

    @Test
    public void resta(){
        int resultado = calculadora.resta(6, 2);
        int esperado = 4;
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void restaincorrecta(){
        int resultado = calculadora.resta(20, 30);
        int esperado = 3;
        Assert.assertNotEquals(esperado, resultado);
    }

    @Test
    public void restanegativa(){
        int resultado = calculadora.resta(20, 30);
        int esperado = -10;
        Assert.assertEquals(esperado, resultado);
    }


    @Test
    public void multiplicacion(){
        int resultado = calculadora.multiplicacion(6, 2);
        int esperado = 12;
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void multiplicacionmala(){
        int resultado = calculadora.multiplicacion(6, 2);
        int esperado = 14;
        Assert.assertNotEquals(esperado, resultado);
    }

    @Test
    public void division(){
        int resultado = calculadora.division(6, 2);
        int esperado = 3;
        Assert.assertEquals(esperado, resultado);
    }

    @Test
    public void divisionmala(){
        int resultado = calculadora.division(6, 2);
        int esperado = 4;
        Assert.assertNotEquals(esperado, resultado);
    }
}
