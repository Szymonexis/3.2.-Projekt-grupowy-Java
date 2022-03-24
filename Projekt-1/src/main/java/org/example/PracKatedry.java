package org.example;

import java.util.GregorianCalendar;

public class PracKatedry extends PracNaukowy {
    public PracKatedry(String name, String surname,
                       GregorianCalendar emplStartDate, Integer pensum) {
        super(name, surname, emplStartDate, pensum);
    }

    @Override
    public String getDescription() {
        return "Pracownik katedry";
    }


}
