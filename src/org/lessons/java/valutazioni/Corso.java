package org.lessons.java.valutazioni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corso {

    // ATTRIBUTI

    private List<Studente> studentiList;

    // COSTRUTTORE

    public Corso () {
        this.studentiList = new ArrayList<>();
    }

    // SETTER AND GETTER

    // METODI
    public void getStudentiList() {
        System.out.println("Elenco degli studenti nel corso:");
        for (Studente studente : studentiList) {
            System.out.println("ID: " + studente.getStudentId() +
                    ", Percentuale Assenze: " + studente.getPercentageAbsences() + "%" +
                    ", Media Voti: " + studente.getFormattedAverageGrades());
        }
    }

    public void addStudente(Studente studente) {
        studentiList.add(studente);
    }

    public void removeStudente(int studentId) {
        Iterator<Studente> iterator = studentiList.iterator();
        while (iterator.hasNext()) {
            Studente studente = iterator.next();
            if (studente.getStudentId() == studentId) {
                iterator.remove();
                System.out.println("Studente con ID " + studentId + " rimosso.");
                return;
            }
        }

        System.out.println("Studente con ID " + studentId + " non trovato.");
    }

    public double percentualePromossi() {
        if (studentiList.isEmpty()) {
            return 0.0; // Nel caso non ci siano studenti nel corso, la percentuale è 0
        }

        int promossi = 0;

        for (Studente studente : studentiList) {
            if (studente.isPromoted(studente.getPercentageAbsences(), studente.getAverageGrades())) {
                promossi++;
            }
        }

        return ((double) promossi / studentiList.size()) * 100.0;
    }
}


