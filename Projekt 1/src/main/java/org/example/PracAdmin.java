package org.example;

import java.util.GregorianCalendar;

public class PracAdmin extends Pracownik {
    private String role;

    public PracAdmin(String name, String surname, GregorianCalendar emplStartDate, String role) {
        super(name, surname, emplStartDate);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getDescription() {
        return "Pracownik admin";
    }
}
