package homeworks.java.hw2;

public class MutableAge {

    private int day;
    private int month;
    private int year;

    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else {
            System.out.println("Day setting message: Input number between 1 and 31");
        }
    }

    public int getDay() {
        return day;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            System.out.println("Month setting message: Input number between 1 and 12");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        if (year >= 1900) {
            this.year = year;
        } else {
            System.out.println("Year setting message: input number must be more then 1900");
        }
    }

    public int getYear() {
        return year;
    }

}
