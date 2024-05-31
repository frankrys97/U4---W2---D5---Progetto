package francescocristiano;

import francescocristiano.entities.Catalogo;

public class Application {

    public static void main(String[] args) {
        System.out.println("Benvenuto in EpiBooks - JAVA Edition!");

        System.out.println("Inizializzo il catalogo...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Catalogo.startApp();
    }


}
