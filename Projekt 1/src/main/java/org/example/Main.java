package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main
{
    public static void main( String[] args ) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd MM yyyy");
        Date date = df.parse("02 26 1991");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        List<Pracownik> pracownicy = new ArrayList<>();

        PracKatedry pracKatedry = new PracKatedry("pracownik", "katedry", cal, 10);
        KierownikKatedry kierownikKatedry = new KierownikKatedry("kierownik",
                "katedry", cal, 10, 10.01);
        PracAdmin pracAdmin = new PracAdmin("pracownik", "admin", cal, "role");

        pracownicy.add(pracKatedry);
        pracownicy.add(kierownikKatedry);
        pracownicy.add(pracAdmin);

        for (Pracownik pracownik:
             pracownicy) {
            System.out.println(pracownik.getDescription());
        }
    }
}
