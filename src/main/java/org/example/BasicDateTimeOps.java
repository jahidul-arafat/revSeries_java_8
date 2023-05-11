package org.example;
/*
- There are two APIs in JAVA to working with Date and time.
(a) Java.util.Date and Java.util.Calendar (legacy classes)
(b) Java.time package (introduced in Java 8)
 */

import java.text.DateFormat;
import java.time.LocalDate;             // new Date time API
import java.time.LocalDateTime;         // new Date time API
import java.time.format.DateTimeFormatter;  // new Date time API
import java.util.Date;                  // legacy Date Time API
import java.util.GregorianCalendar;     // legacy Date Time API

public class BasicDateTimeOps {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        /*
        0 - Jan
        1 - Feb
        2 - March
        3 - April
        4 - May
         */
        GregorianCalendar gc = new GregorianCalendar(2023,0,10); // 10th January
        gc.add(GregorianCalendar.DATE,1); // 11th January
        System.out.println(gc.getTime());

        // For Java Versions <8
        // Lets formatting the date
        // Wed Jan 11 00:00:00 BDT 2023  --> Sunday, January 1, 2023
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL); // With FULL -> Wednesday, January 11, 2023
                                                                    // Without FULL -> January 11, 2023
        System.out.println(df.format(gc.getTime()));

        // For Java Versions >8
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt); // 2023-05-11T09:49:10.282218 --> UNIX time stamp

        /*
        1- Jan
        2- Feb
        3- March
        4- April
        5- May
         */
        LocalDate ld = LocalDate.of(2023,5,11);
        System.out.println(ld); // 2023-05-11

        // Lets format this date with my defined pattern
        // Pattern: M/d/yyyy
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        System.out.println(dtf.format(ldt)); // 5/11/2023
    }
}
