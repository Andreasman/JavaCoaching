package de.staecker.javacoaching.streamapi;

import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.staecker.javacoaching.service.faker.FakerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StreamTest {

    @Autowired
    FakerService fakerService;

    private List<String> names;

    @Before
    public void init() {
        System.out.println("Namensliste neu generieren...");
        names = fakerService.getFakeNames(20);
    }

    /**
     * Lambda mit Methoden-Parameter als Compare-Statement, ich werde hier eine
     * Liste mit Namen nach länge der Namen sortieren
     */
    @Test
    public void streams01() {
        names.sort(compareByLength);
        // über die Liste iterieren.... wie Früher
        for (String name : names) {
            System.out.println(name);
        }
    }

    /**
     * hier mit externen Comparator und Stream-Funktionalität, zwischendurch
     * noch mal eben in Großbuchstaben umgewandelt
     */
    @Test
    public void streams02() {
        // Jetzt in einer Zeile mit StreamApi, cool oder...
        names.stream().map(name -> name.toUpperCase()).sorted(compareByLength).forEach(System.out::println);
    }

    /**
     * ohne externen Comparator und Stream-Funktionalität
     */
    @Test
    public void streams03() {
        // Jetzt in einer Zeile mit StreamApi, cool oder...
        // @formatter:off
        
        names.stream() // Stream erzeugen
            .map(name -> name.toUpperCase()) // in Großbuchstaben wandeln
            .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length())) // nach länge sortieren, Comparator als Lambda Ausdruck!
            .forEach(System.out::println); // alle Namen ausgeben
        
        //@formatter:on
    }

    // Comparator per innerer anonyme Klasse... Wie es Großmutter noch machte...
    private Comparator<String> compareByLength = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(o1.length(), o2.length());
        }

    };

}
