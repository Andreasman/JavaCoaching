package de.staecker.javacoaching.service.faker;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Faker zum Erzeugen von Testdaten
 * 
 * @author andre
 *
 */
@Service
public class FakerService {

    private Faker faker = new Faker();

    /**
     * Generiert eine Liste mit Vornamen
     * 
     * @param count
     *            Anzahl der zu generierenden Namen
     * @return Liste mit Namen
     */
    public final List<String> getFakeNames(final int count) {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < count; i++) {
            names.add(faker.firstName());
        }
        return names;
    }

}
