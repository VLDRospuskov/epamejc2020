package homeworks.homework01;

import lombok.Data;

@Data
public class MutableMood {
    public String moodState;

    @Override
    public Object clone() {
        MutableMood mutableMood = new MutableMood();
        mutableMood.setMoodState(this.moodState);
        return mutableMood;
    }
}
