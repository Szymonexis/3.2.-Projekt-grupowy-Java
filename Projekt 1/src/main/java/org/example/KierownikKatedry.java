package org.example;

import java.util.GregorianCalendar;

public class KierownikKatedry extends PracNaukowy {

    private Double funcAddition;

    public KierownikKatedry(String name, String surname, GregorianCalendar emplStartDate,
                            Integer pensum, Double funcAddition) {
        super(name, surname, emplStartDate, pensum);
        this.funcAddition = funcAddition;
    }

    @Override
    public String getDescription() {
        return "Kierownik katedry";
    }
}
