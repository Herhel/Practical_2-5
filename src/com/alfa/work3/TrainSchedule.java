package com.alfa.work3;

import com.alfa.work1.DaysOfWeek;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TrainSchedule {
    private static int trainsCount = 0;
    private Train[] trains;

    public TrainSchedule(int trainsCount) {
        trains = new Train[trainsCount];
    }

    public Train[] getTrains() {
        return trains;
    }

    public void addTrain() {
        int number;
        String stationDispatch;
        String stationArrival;
        String timeDispatch;
        String timeArrival;
        DaysOfWeek[] days = new DaysOfWeek[DaysOfWeek.values().length];
        if (trains.length <= trainsCount) {
            Train[] newTrains = new Train[trains.length + 5];
            System.arraycopy(trains, 0, newTrains, 0, trains.length);
            trains = newTrains;
        }
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер поезда:");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                break;
            } else {
                System.out.println("\nВы ввели не числовое значение! Повторите ввод.");
                sc.nextLine();
            }
        }
        sc = new Scanner(System.in);
        System.out.println("Введите станцию отправления:");
        stationDispatch = sc.nextLine();
        System.out.println("Введите время отправления в формате HH:MM :");
        timeDispatch = sc.nextLine();
        System.out.println("Введите станцию прибытия:");
        stationArrival = sc.nextLine();
        System.out.println("Введите время прибытия в формате HH:MM :");
        timeArrival = sc.nextLine();
        System.out.println("Вводите дени движения поезда через Enter, или введите all для выбора всех дней недели, или x для завершения ввода:");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("all")) {
            days = DaysOfWeek.values();
        } else {
            int index = 0;
            while (true) {
                if (input.equalsIgnoreCase("x")) {
                    days = Arrays.copyOf(days, index);
                    break;
                }
                try {
                    days[index] = DaysOfWeek.valueOf(input.toUpperCase());
                    index++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Введено некорректное название дня, повторите ввод:");
                }
                input = sc.nextLine();
            }
        }
        addTrain(number, stationDispatch, stationArrival, timeDispatch, timeArrival, days);
    }

    public void addTrain(int number, String stationDispatch, String stationArrival, String timeDispatch, String timeArrival, DaysOfWeek[] days) {
        trains[trainsCount] = new Train(number, stationDispatch, stationArrival, timeDispatch, timeArrival, days);
        TrainSchedule.trainsCount++;
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

    public Train[] searchTrainByArrivalAndDay(String arrival, String day) {
        int length = trains.length;
        Train[] searchResult = new Train[length];
        for (int i = 0; i < length; i++) {
            if (trains[i].getStationArrival().equalsIgnoreCase(arrival) && trains[i].inDay(day)) {
                searchResult[i] = trains[i];
            }
        }
        return Arrays.stream(searchResult).filter(Objects::nonNull).toArray(Train[]::new);
    }

    public void searchTrain() {
        String arrival;
        String day;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите станцию прибытия:");
        arrival = sc.nextLine();
        System.out.println("Введите день недели:");
        day = sc.nextLine();
        Train[] searchResult = searchTrainByArrivalAndDay(arrival, day);
        if (searchResult.length > 0) {
            System.out.println("Поезда, идущие до станции " + arrival + " в " + day);
            printTrains(searchResult);
        } else {
            System.out.println("Нет поездов, идущих до станции " + arrival + " в " + day);
        }
    }

}
