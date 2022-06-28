import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ValidadorRut;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorRutTest {
    private String[] rut;
    private String[] digitosVerificador;
    private String[] rutInvertidos;
    private String[] rutValidados;
    private boolean[] validaciones;

    @BeforeEach
    public void setUp() {
        rut = new String[]{"12345678", "20104038", "11111111"};
        digitosVerificador = new String[]{"5", "8", "1"};
        rutInvertidos = new String[]{"87654321", "83040102", "11111111"};
        rutValidados = new String[]{"12.345.6785","20.104.038-8","11111.111-1","18.456.985-K","18.456.985-k","0-0","2.043.048-3","1"};
        validaciones = new boolean[]{true,true,true,true,true,true,false,false};
    }

    @Test
    void invertirOrdenTest(){
        boolean condicion = true;
        for (int i = 0; i < rutInvertidos.length; i++) {
            String rutInvertido = ValidadorRut.invertirOrden(rut[i]);
            if(!rutInvertido.equals(rutInvertidos[i])){
                condicion = false;
            }
        }
        assertTrue(condicion);

    }

    @Test
    void calculoDigitoVerificadorTest(){
        boolean condicion = true;
        for (int i = 0; i < rut.length; i++) {
            String digitoVerificador = ValidadorRut.calculoDigitoVerificador(rut[i]);
            if(!digitoVerificador.equals(digitosVerificador[i])){
                condicion = false;
            }
        }
        assertTrue(condicion);
    }

    @Test
    void validarRutTest(){
        boolean condicion = true;
        for (int i = 0; i < rutValidados.length; i++) {
            String rutSinDigitos = ValidadorRut.tomarNumeros(rutValidados[i]);
            boolean validador = ValidadorRut.validarNumeros(rutSinDigitos);
            if(validador != validaciones[i]){
                condicion = false;
            }
        }
        assertTrue(condicion);
    }


    @AfterEach
    void tearDown() {
        rut = null;
        digitosVerificador = null;
        rutInvertidos = null;
        validaciones = null;
    }
}