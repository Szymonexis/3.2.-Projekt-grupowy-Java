package org.example;

import java.util.GregorianCalendar;

public abstract class Pracownik {
    private String name;
    private String surname;
    private GregorianCalendar emplStartDate;
    private static Integer nextId = 1;
    private Integer id;
    private Double pension;

    public Pracownik (String name, String surname, GregorianCalendar emplStartDate) {
        this.name = name;
        this.surname = surname;
        this.emplStartDate = emplStartDate;
        this.id = nextId++;
    }

    // getters
    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmplDate() {
        return emplStartDate.toString();
    }

    public Double getPension() {
        return pension;
    }
}
