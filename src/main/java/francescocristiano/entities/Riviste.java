package francescocristiano.entities;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.Scanner;
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

    public static void addMagazineManually(Scanner scanner) {
        Faker faker = new Faker();
        String ISBN = faker.code().isbn13();
        System.out.println("Inserisci titolo");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci anno di pubblicazione");
        int annoPubblicazione = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Inserisci numero di pagine");
        int numeroPagine = Integer.parseInt(scanner.nextLine());
        System.out.println("Inserisci periodicità ( SETTIMANALE, MENSILE, SEMESTRALE ):");
        Periodicità periodicità = Periodicità.valueOf(scanner.nextLine().toUpperCase());
        Catalogo.addElemento(new Riviste(ISBN, titolo, annoPubblicazione, numeroPagine, periodicità));
        System.out.println("Rivista aggiunta con successo");
    }

    public static void addMagazineRandom() {
        Catalogo.addElemento(Riviste.randomicMagazine.get());
        System.out.println("Rivista generata ed aggiunta con successo");
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    @Override
    public String toString() {
        return "Rivista: " + super.toString() +
                ", Periodicità: " + periodicità;
    }
}
