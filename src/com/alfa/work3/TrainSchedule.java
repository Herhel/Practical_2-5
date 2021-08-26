package com.alfa.work3;

import com.alfa.work1.DaysOfWeek;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TrainSchedule {
    private int trainsCount = 0;
    private Train[] trains;

    public TrainSchedule(int trainsCount) {
        trains = new Train[trainsCount];
    }

    public Train[] getTrains() {
        return Arrays.copyOf(trains, trainsCount);
    }

    public void addTrain() {
        int number;
        String stationDispatch;
        String stationArrival;
        String timeDispatch;
        String timeArrival;

        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("Введите номер поезда:");
//            if (sc.hasNextInt()) {
//                number = sc.nextInt();
//                break;
//            } else {
//                System.out.println("\nВы ввели не числовое значение! Повторите ввод.");
//                sc.nextLine();
//            }
//        }
        number = enterTrainNumber(sc);
        //sc = new Scanner(System.in);
        System.out.println("Введите станцию отправления:");
        stationDispatch = sc.next();
        System.out.println("Введите время отправления в формате HH:MM :");
        timeDispatch = sc.next();
        System.out.println("Введите станцию прибытия:");
        stationArrival = sc.next();
        System.out.println("Введите время прибытия в формате HH:MM :");
        timeArrival = sc.next();
        DaysOfWeek[] days = enterTrainDays(sc);
//        System.out.println("Вводите дни движения поезда через Enter, или введите all для выбора всех дней недели, или x для завершения ввода:");
//        String input = sc.next();
//        DaysOfWeek[] days = new DaysOfWeek[DaysOfWeek.values().length];
//        if (input.equalsIgnoreCase("all")) {
//            days = DaysOfWeek.values();
//        } else {
//            int index = 0;
//            while (true) {
//                if (input.equalsIgnoreCase("x")) {
//                    days = Arrays.copyOf(days, index);
//                    break;
//                }
//                try {
//                    days[index] = DaysOfWeek.valueOf(input.toUpperCase());
//                    index++;
//                } catch (IllegalArgumentException e) {
//                    System.out.println("Введено некорректное название дня, повторите ввод:");
//                }
//                input = sc.next();
//            }
//        }
        addTrain(number, stationDispatch, stationArrival, timeDispatch, timeArrival, days);
    }

    private DaysOfWeek[] enterTrainDays(Scanner sc) {
        System.out.println("Вводите дни движения поезда через Enter, или введите all для выбора всех дней недели, или x для завершения ввода:");
        String input = sc.next();
        DaysOfWeek[] days = new DaysOfWeek[DaysOfWeek.values().length];
        if (input.equalsIgnoreCase("all")) {
            return DaysOfWeek.values();
        } else {
            int index = 0;
            while (true) {
                if (input.equalsIgnoreCase("x")) {
                    return Arrays.copyOf(days, index);
                }
                try {
                    days[index] = DaysOfWeek.valueOf(input.toUpperCase());
                    index++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено некорректное название дня, повторите ввод:");
                }
                input = sc.next();
            }
        }
    }

    private int enterTrainNumber(Scanner sc) {
        while (true) {
            System.out.println("Введите номер поезда:");
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("\nВы ввели не числовое значение! Повторите ввод.");
                sc.nextLine();
            }
        }
    }

    public void addTrain(int number, String stationDispatch, String stationArrival, String timeDispatch, String timeArrival, DaysOfWeek[] days) {
        if (trains.length == trainsCount) {
//            Train[] newTrains = new Train[trains.length + 5];
//            System.arraycopy(trains, 0, newTrains, 0, trains.length);
//            trains = newTrains;
            trains = Arrays.copyOf(trains, trains.length + 5);
        }
        trains[trainsCount] = new Train(number, stationDispatch, stationArrival, timeDispatch, timeArrival, days);
        trainsCount++;
    }

    public void printSchedule() {
        System.out.println("\nРасписание поездов:");
        printTrains(trains);
    }

    public void printTrains(Train[] trains) {
        for (Train train : trains) {
            if (train != null) System.out.println(train);
        }
    }

    public Train[] searchTrainByArrivalAndDay(String arrival, DaysOfWeek day) {
        Train[] searchResult = new Train[trainsCount];
        for (int i = 0; i < searchResult.length; i++) {
            if (trains[i].getStationArrival().equalsIgnoreCase(arrival) && trains[i].inDay(day)) {
                searchResult[i] = trains[i];
            }
        }
        return Arrays.stream(searchResult).filter(Objects::nonNull).toArray(Train[]::new);
    }



}
