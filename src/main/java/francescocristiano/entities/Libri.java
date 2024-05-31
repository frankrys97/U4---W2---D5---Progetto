package francescocristiano.entities;

import com.github.javafaker.Faker;

import java.util.function.Supplier;

public class Libri extends ElementoCatalogo {
    public static Supplier<Libri> randomicBook = () -> {
        Faker faker = new Faker();

        String ISBN = faker.code().isbn13();
        String titolo = faker.book().title();
        int annoPubblicazione = faker.number().numberBetween(1700, 2024);
        int numeroPagine = faker.number().numberBetween(1, 1000);
        String autore = faker.book().author();
        String genere = faker.book().genre();
        return new Libri(ISBN, titolo, annoPubblicazione, numeroPagine, autore, genere);
    };
    private final String autore;
    private final String genere;

    public Libri(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

}
