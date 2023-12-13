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
/*
    - se lo studente ha fatto più del 50% di assenze è bocciato VV
- se ha fatto tra il 25% e il 50% di assenze è promosso solo se la media dei voti è superiore a 2
            - se ha fatto meno del 25% di assenze è promosso se la media dei voti è superiore o uguale a 2

 */
    public String failureOrNot(int studentId, int percentageAbsences, BigDecimal averageGrades) {
        if (percentageAbsences > 50) {
            return studentId + " ha superato il 50% di assenze, è bocciato!";
        } else if (percentageAbsences >= 25 && percentageAbsences < 50 && averageGrades.compareTo(new BigDecimal("2")) > 0) {
            return studentId + " è promosso!";
        } else if (percentageAbsences < 25 && averageGrades.compareTo(new BigDecimal("2")) >= 0) {
            return studentId + " è promosso!";
        } else {
            return studentId + " è bocciato!";
        }
    }

}
