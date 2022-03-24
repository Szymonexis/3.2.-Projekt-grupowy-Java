package org.example;

import java.util.GregorianCalendar;

public abstract class PracNaukowy extends Pracownik{

    private GregorianCalendar emplEndDate;
    private Integer pensum;

    public PracNaukowy(String name, String surname,
                       GregorianCalendar emplStartDate, Integer pensum) {
        super(name, surname, emplStartDate);
        this.pensum = pensum;
    }

    public abstract String getDescription();
}
