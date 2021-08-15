package com.alfa.work1;

import java.util.Locale;
import java.util.Scanner;

public class Runner {

    public void run() {
        System.out.println("Дни недели:");
        printDays(DaysOfWeek.values());
        javaDays();
        System.out.println("\nВведите начальный день:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            DaysOfWeek day = DaysOfWeek.valueOf(input.toUpperCase());
            System.out.println(day.nextDay());
        } catch (IllegalArgumentException e) {
            System.out.println("Введено некорректное название дня");
        }
    }

    public void printDays(DaysOfWeek[] days) {
        for (DaysOfWeek day : days) {
            System.out.println(day);
        }
    }

    public void javaDays() {
        System.out.println("\nДни учёбы:");
        for (DaysOfWeek day : DaysOfWeek.values()) {
            switch (day) {
                case MONDAY:
                case WEDNESDAY:
                case FRIDAY:
                    System.out.println(day);
            }
        }
    }
}
