package org.lessons.java.valutazioni;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Corso corso = new Corso();
        Random random = new Random();

        // numero casuale di studenti compreso tra 10 e 20
        int numeroStudenti = random.nextInt(11) + 10;

        for (int i = 1; i <= numeroStudenti; i++) {
            int assenze = random.nextInt(101); // Percentuale di assenze tra 0 e 100
            BigDecimal voti = new BigDecimal(random.nextDouble() * 5); // Voti casuali tra 0 e 5
            Studente studente = new Studente(i, assenze, voti);
            corso.addStudente(studente);
        }

        corso.getStudentiList();

        double percentualePromossi = corso.percentualePromossi();
        System.out.println("Percentuale studenti promossi: " + percentualePromossi + "%");

    }
}
