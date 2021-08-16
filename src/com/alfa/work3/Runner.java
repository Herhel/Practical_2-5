package com.alfa.work3;

import com.alfa.work1.DaysOfWeek;

public class Runner {
    private TrainSchedule trainSchedule;

    public void run() {
        trainSchedule = new TrainSchedule(5);
        createTrainSchedule();
        trainSchedule.printSchedule();
        trainSchedule.addTrain();
        trainSchedule.printSchedule();
        trainSchedule.searchTrain();
    }

    private void createTrainSchedule() {
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



}
