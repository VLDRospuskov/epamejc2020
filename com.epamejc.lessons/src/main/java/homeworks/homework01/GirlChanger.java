package homeworks.homework01;

public class GirlChanger {
    public static void main(String[] args) {
        ImmutableGirl immutableGirl = new ImmutableGirl(18, "Alice");

        MutableMood mood = immutableGirl.getMood();

        mood.setMoodState("sad");

        System.out.println(immutableGirl.getMood());
    }
}
