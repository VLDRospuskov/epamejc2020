package Home_works.HW_8_part_2;

import lombok.Data;

@Data
public class JobHistoryEntry {

    private  int duration;
    private  String position;
    private  String company;

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
