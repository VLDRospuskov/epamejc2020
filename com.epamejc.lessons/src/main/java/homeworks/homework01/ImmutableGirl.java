package homeworks.homework01;

public final class ImmutableGirl {

    private int age;
    private String name;
    private MutableMood mood;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public MutableMood getMood() {
        return (MutableMood) mood.clone();
    }

    public ImmutableGirl(int age, String name) {
        this.age = age;
        this.name = name;
        this.mood = new MutableMood();
        this.mood.setMoodState("cheerful");
    }

}