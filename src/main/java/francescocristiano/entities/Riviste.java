package francescocristiano.entities;

public class Riviste extends ElementoCatalogo {
    private final Periodicità periodicità;

    public Riviste(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(ISBN, titolo, annoPubblicazione, numeroPagine);

        this.periodicità = periodicità;
    }


    public Periodicità getPeriodicità() {
        return periodicità;
    }


}
