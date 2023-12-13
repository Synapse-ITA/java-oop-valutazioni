package org.lessons.java.valutazioni;

import java.math.BigDecimal;

public class Studente {

    // ATTRIBUTI

    private int studentId;
    private int percentageAbsences;
    private BigDecimal averageGrades;

    // COSTRUTTORE

    public Studente(int studentId, int percentageAbsences, BigDecimal averageGrades) throws IllegalArgumentException {
        checkNull(studentId, "ID Studente");
        checkNull(percentageAbsences, "Percentuale assenze");
        checkNull(averageGrades, "Media assenze");
        if (percentageAbsences < 0 || percentageAbsences > 100) {
            throw new IllegalArgumentException("Le assenze devono essere tra 0 e 100");
        }
        if (averageGrades.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La media non deve essere negativa");
        }
        this.studentId = studentId;
        this.percentageAbsences = percentageAbsences;
        this.averageGrades = averageGrades;
    }


    // SETTER AND GETTER


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) throws IllegalArgumentException {
        checkNull(studentId, "ID studente");
        this.studentId = studentId;
    }

    public int getPercentageAbsences() {
        return percentageAbsences;
    }

    public void setPercentageAbsences(int percentageAbsences) throws IllegalArgumentException {
        checkNull(percentageAbsences, "Percentuale assenze");
        if (percentageAbsences < 0 || percentageAbsences > 100) {
            throw new IllegalArgumentException("Percentuale delle assenze deve essere tra 0 e 100");
        }
        this.percentageAbsences = percentageAbsences;
    }

    public BigDecimal getAverageGrades() {
        return averageGrades;
    }

    public String getFormattedAverageGrades() {
        return String.format("%.2f", averageGrades);
    }

    public void setAverageGrades(BigDecimal averageGrades) throws IllegalArgumentException {
        checkNull(averageGrades, "Media voti");
        if (averageGrades.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("La media non deve essere negativa");
        }
        this.averageGrades = averageGrades;
    }

    // METODI

    // METODO NULL
    public static void checkNull(Object value, String parameter) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException(parameter);
        }
    }

    // METODO BOCCIATURA

    public boolean isPromoted(int percentageAbsences, BigDecimal averageGrades) {
        if (percentageAbsences > 50) {
            return false; // Bocciato
        } else if (percentageAbsences >= 25 && percentageAbsences < 50 && averageGrades.compareTo(new BigDecimal("2")) > 0) {
            return true; // Promosso
        } else if (percentageAbsences < 25 && averageGrades.compareTo(new BigDecimal("2")) >= 0) {
            return true; // Promosso
        } else {
            return false; // Bocciato
        }
    }

}
