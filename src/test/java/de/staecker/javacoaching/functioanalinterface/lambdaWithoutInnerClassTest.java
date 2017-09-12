package de.staecker.javacoaching.functioanalinterface;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.staecker.javacoaching.functionalinterface.Rechner;
import de.staecker.javacoaching.functionalinterface.RechnerWihtOneArgument;

/**
 * Ein Lambda Ausdruck ist im Prinzip eine anonyme innerer Klasse...
 * 
 * @author andre
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class lambdaWithoutInnerClassTest {

    private double laengeAlsObjectMember;

    @Test
    public void lambdaMitInnererKlasse() {
        Rechner rechner = (double laenge, double breite) -> {
            return laenge * breite;
        };
        double flaeche = rechner.berechne(2.345, 3.45);
        System.out.printf("Fläche: %.1f m2", flaeche);
        System.out.println();
    }

    /**
     * Datentyp kann weggelsassen werden, holt sich der Lambda aus dem IF
     */
    @Test
    public void lambdaMitInnererKlasseKuerzer() {
        Rechner rechner = (laenge, breite) -> (laenge * breite);
        double flaeche = rechner.berechne(2.345, 3.45);
        System.out.printf("Fläche: %.1f m2", flaeche);
        System.out.println();
    }

    /**
     * Lambda mit einem Argument und lokaler oder Objekt-Variable
     */
    @Test
    public void lambdaWihtOneArgument() {
        laengeAlsObjectMember = 4.32;
        RechnerWihtOneArgument rechner = (breite) -> (laengeAlsObjectMember * laengeAlsObjectMember);
        double flaeche = rechner.berechne(3.45);
        System.out.printf("Fläche: %.1f m2", flaeche);
        System.out.println();
    }

}
