package francescocristiano.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    public static List<ElementoCatalogo> elementi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addElemento(ElementoCatalogo elemento) {
        elementi.add(elemento);
    }

    private static void addElementChoose() {
        System.out.println("1. Aggiungi manualmente");
        System.out.println("2. Genera randomicamente");
        int scelta = Integer.parseInt(scanner.nextLine());
        if (scelta == 1) {
            addManuallyElement();
        } else if (scelta == 2) {
            addRandomicElement();
        }
    }

    public static ElementoCatalogo searchByISBN(String ISBN) {
    /*    for (ElementoCatalogo elemento : elementi) {
            if (elemento.getISBN().equals(ISBN)) {
                return elemento;
            }
        }
        return null;*/

        // Su consiglio di Riccardo per una sintassi più concisa ho deciso di utilizzare il metodo findFirst abbinato al filter
        // per farmi restituire il dato di mio interesse

        return elementi.stream().filter(elemento -> elemento.getISBN().equals(ISBN)).findFirst().orElse(null);
    }

    public static List<ElementoCatalogo> searchByYear(int annoPubblicazione) {
        return elementi.stream().filter(elemento -> elemento.getAnnoPubblicazione() == annoPubblicazione).toList();
    }

    public static List<ElementoCatalogo> searchByAuthor(String autore) {
        return elementi.stream().filter(elemento -> elemento instanceof Libri).filter(elemento -> ((Libri) elemento).getAutore().equals(autore)).toList();
    }

    public static void addManuallyElement() {
        System.out.println("Scegli un'opzione: ");
        System.out.println("1. Libro");
        System.out.println("2. Rivista");

        int scelta = Integer.parseInt(scanner.nextLine());
        if (scelta == 1) {
            Libri.addBookManually(scanner);
        } else if (scelta == 2) {
            Riviste.addMagazineManually(scanner);
        }
    }

    public static void addRandomicElement() {
        System.out.println("Scegli un'opzione: ");
        System.out.println("1. Libro");
        System.out.println("2. Rivista");

        int scelta = Integer.parseInt(scanner.nextLine());
        if (scelta == 1) {
            Libri.addBookRandom();
        } else if (scelta == 2) {
            Riviste.addMagazineRandom();
        }
    }

    public static void removeByISBN() {
        if (!elementi.isEmpty()) {
            System.out.println();
            System.out.println("Inserisci ISBN dell' elemento da rimuovere");
            String ISBN = scanner.nextLine();
            elementi.removeIf(elemento -> elemento.getISBN().equals(ISBN));
            System.out.println("Elemento rimosso con successo");
            System.out.println();
        } else {
            System.out.println("Non ci sono elementi da rimuovere");
            System.out.println();
        }

    }

    public static void searchElement() {
        System.out.println("Scegli un'opzione: ");
        System.out.println("1. Cerca per ISBN");
        System.out.println("2. Cerca per anno di pubblicazione");
        System.out.println("3. Cerca per autore");

        int scelta = Integer.parseInt(scanner.nextLine());
        switch (scelta) {
            case 1:
                System.out.println("Inserisci ISBN");
                String ISBN = scanner.nextLine();
                searchByISBN(ISBN);
                System.out.println();
                if (searchByISBN(ISBN) != null) {

                    System.out.println(searchByISBN(ISBN));
                    System.out.println();
                } else {
                    System.out.println("Elemento non trovato");
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Inserisci anno di pubblicazione");
                int annoPubblicazione = Integer.parseInt(scanner.nextLine());
                searchByYear(annoPubblicazione);
                System.out.println();
                if (!searchByYear(annoPubblicazione).isEmpty()) {
                    System.out.println("Elementi trovati: ");
                    searchByYear(annoPubblicazione).forEach(System.out::println);
                } else {
                    System.out.println("Elemento non trovato");
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Inserisci autore");
                String autore = scanner.nextLine();
                searchByAuthor(autore);
                System.out.println();
                if (!searchByAuthor(autore).isEmpty()) {
                    System.out.println("Elementi trovati: ");
                    searchByAuthor(autore).forEach(System.out::println);
                } else {
                    System.out.println("Elemento non trovato");
                }
                break;
            default:
                break;
        }
    }

    public static void startApp() {
        for (int i = 0; i < 5; i++) {
            elementi.add(Libri.randomicBook.get());
            elementi.add(Riviste.randomicMagazine.get());
        }


        while (true) {

            System.out.println();

            System.out.println("Questa è la nostra libreria: ");

            elementi.forEach(System.out::println);

            System.out.println();


            System.out.println("Scegli un'opzione: ");
            System.out.println("1. Aggiungi elemento");
            System.out.println("2. Rimuovi elemento");
            System.out.println("3. Cerca elemento");
            System.out.println("4. Salva su disco");
            System.out.println("5. Carica da disco");
            System.out.println("6. Esci");

            try {
                int scelta = Integer.parseInt(scanner.nextLine());
                switch (scelta) {
                    case 1:
                        addElementChoose();
                        break;
                    case 2:
                        removeByISBN();
                        break;
                    case 3:
                        searchElement();
                        break;
                    case 4:
                        System.out.println("Non ancora fatto");
                        break;
                    case 5:
                        System.out.println("Non ancora fatto");
                        break;

                    case 6:
                        return;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Scelta non valida");
            }
        }
    }


}
