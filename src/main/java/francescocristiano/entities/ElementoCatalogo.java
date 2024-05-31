package francescocristiano.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementoCatalogo {
    public static List<ElementoCatalogo> elementi = new ArrayList<>();
    private final String ISBN;
    private final String titolo;
    private final int annoPubblicazione;
    private final int numeroPagine;

    public ElementoCatalogo(String ISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.ISBN = ISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public static void addElemento(ElementoCatalogo elemento) {
        elementi.add(elemento);
    }

    public static void removeElemento(String ISBN) {
        for (ElementoCatalogo elemento : elementi) {
            if (elemento.getISBN().equals(ISBN)) {
                elementi.remove(elemento);
                break;
            }
        }
    }

    public static List<ElementoCatalogo> searchByYear(int annoPubblicazione) {
        return elementi.stream().filter(elemento -> elemento.getAnnoPubblicazione() == annoPubblicazione).toList();
    }

    public static List<ElementoCatalogo> searchByAuthor(String autore) {
        return elementi.stream().filter(elemento -> elemento instanceof Libri).filter(elemento -> ((Libri) elemento).getAutore().equals(autore)).toList();
    }
    

    public String getISBN() {
        return ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

   /* public static ElementoCatalogo searchByISBN (String ISBN) {
       return elementi.stream().filter(elemento -> elemento.getISBN().equals(ISBN)).;
    }*/

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public String toString() {
        return ISBN + ", " + titolo + ", " + annoPubblicazione + ", " + numeroPagine;
    }
}
