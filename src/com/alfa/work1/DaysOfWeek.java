package com.alfa.work1;

public enum DaysOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public DaysOfWeek nextDay() {
        int i = this.ordinal() +1;
        if (i == DaysOfWeek.values().length) {
            i = 0;
        }
        return DaysOfWeek.values()[i];
    }

}
