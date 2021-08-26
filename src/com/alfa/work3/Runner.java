package com.alfa.work3;

import com.alfa.work1.DaysOfWeek;

import java.util.Scanner;

public class Runner {


    public void run() {
        TrainSchedule trainSchedule = new TrainSchedule(5);
        createTrainSchedule(trainSchedule);
        trainSchedule.printSchedule();
        trainSchedule.addTrain();
        trainSchedule.printSchedule();
        searchTrain(trainSchedule);
    }

    private void createTrainSchedule(TrainSchedule trainSchedule) {
        trainSchedule.addTrain(12, "Львов", "Киев", "8:30", "21:20",
                new DaysOfWeek[]{DaysOfWeek.valueOf("SUNDAY"), DaysOfWeek.valueOf("MONDAY"), DaysOfWeek.valueOf("TUESDAY"), DaysOfWeek.valueOf("WEDNESDAY"), DaysOfWeek.valueOf("THURSDAY"), DaysOfWeek.valueOf("FRIDAY"), DaysOfWeek.valueOf("SATURDAY")});
        trainSchedule.addTrain(11, "Одесса", "Киев", "21:30", "7:00",
                new DaysOfWeek[]{DaysOfWeek.valueOf("SUNDAY"), DaysOfWeek.valueOf("MONDAY"), DaysOfWeek.valueOf("TUESDAY"), DaysOfWeek.valueOf("WEDNESDAY"), DaysOfWeek.valueOf("THURSDAY"), DaysOfWeek.valueOf("FRIDAY"), DaysOfWeek.valueOf("SATURDAY")});
        trainSchedule.addTrain(14, "Ивано-Франковск", "Донецк", "18:30", "9:10",
                new DaysOfWeek[]{DaysOfWeek.valueOf("SUNDAY"), DaysOfWeek.valueOf("TUESDAY"), DaysOfWeek.valueOf("THURSDAY"), DaysOfWeek.valueOf("SATURDAY")});
        trainSchedule.addTrain(1, "Винница", "Киев", "20:30", "6:00",
                new DaysOfWeek[]{DaysOfWeek.valueOf("FRIDAY"), DaysOfWeek.valueOf("SATURDAY")});
        trainSchedule.addTrain(10, "Николаев", "Чоп", "18:30", "11:25",
                new DaysOfWeek[]{DaysOfWeek.valueOf("SUNDAY"), DaysOfWeek.valueOf("MONDAY"), DaysOfWeek.valueOf("TUESDAY"), DaysOfWeek.valueOf("WEDNESDAY"), DaysOfWeek.valueOf("THURSDAY")});

    }

    public void searchTrain(TrainSchedule trainSchedule) {
        String arrival;
        String day;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите станцию прибытия:");
        arrival = sc.nextLine();
        System.out.println("Введите день недели:");
        day = sc.nextLine();
        Train[] searchResult = trainSchedule.searchTrainByArrivalAndDay(arrival, DaysOfWeek.valueOf(day));
        if (searchResult.length > 0) {
            System.out.println("Поезда, идущие до станции " + arrival + " в " + day);
            trainSchedule.printTrains(searchResult);
        } else {
            System.out.println("Нет поездов, идущих до станции " + arrival + " в " + day);
        }
    }



}
