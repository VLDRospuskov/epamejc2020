package homework.hw8;

public class JobHistoryEntry {

    private final int duration;
    private final String position;
    private final String company;

    public JobHistoryEntry(int duration, String position, String company) {
        this.duration = duration;
        this.position = position;
        this.company = company;
    }

    public int getDuration() {
        return duration;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }
}