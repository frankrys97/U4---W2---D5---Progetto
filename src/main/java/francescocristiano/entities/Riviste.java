package francescocristiano.entities;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.function.Supplier;

public class Riviste extends ElementoCatalogo {
    public static Supplier<Riviste> randomicMagazine = () -> {
        Faker faker = new Faker();

        String ISBN = faker.code().isbn13();
        String titolo = faker.book().title();
        int annoPubblicazione = faker.number().numberBetween(1700, 2024);
        int numeroPagine = faker.number().numberBetween(1, 1000);
        Periodicità periodicità = Periodicità.values()[new Random().nextInt(Periodicità.values().length)];
        return new Riviste(ISBN, titolo, annoPubblicazione, numeroPagine, periodicità);
    };
    private final Periodicità periodicità;


    public Riviste(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);

        this.periodicità = periodicità;
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }


}
