package de.staecker.javacoaching.functioanalinterface;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.staecker.javacoaching.functionalinterface.Rechner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class lambdaInnerClassTest {

    @Test
    public void lambdaMitInnererKlasse() {

        Rechner rechner = new Rechner() {

            // innere anonyme Klasse
            @Override
            public double berechne(double laenge, double breite) {
                return laenge + breite;
            }
        };

        System.out.printf("Fläche: %.1f m2", rechner.berechne(2.34, 0.563));
        System.out.println();

    }

}
