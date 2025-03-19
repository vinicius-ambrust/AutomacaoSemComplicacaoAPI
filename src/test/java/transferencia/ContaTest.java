package transferencia;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvio;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa ", "52228017809", "583020045");
        silvio = new Cliente("Silvio Santos ", "5225839399", "389012345");

        contaXuxa = new Conta("0025", "1842", 2500.00, xuxa);
        contaSilvio = new Conta("2325", "4032", 3500.00, silvio);
    }

    @Test

    public void realizarTransacao(){
        contaXuxa.realizarTransferencia(1000.00, contaSilvio);

        assertEquals(2500.00, contaXuxa.getSaldo());
        assertEquals(3500.00, contaSilvio.getSaldo());
    }


    @Test
    public void validarTransferenciaInvalida(){
        boolean resultado = contaXuxa.realizarTransferencia(1500.00, contaSilvio);
        assertFalse(resultado);

    }

}