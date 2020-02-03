package main.lessons.lesson7.example8;

public enum Day {
    FRIDAY, SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, SATURDAY;

    public boolean isWeekend() {
        switch (this) {
            case SUNDAY:
            case SATURDAY:
                return true;
            default:
                return false;
        }
    }

}
