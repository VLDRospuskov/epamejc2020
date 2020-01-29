package homeworks.HW_2_immutableClass;

public final class WordNotSparrow {
    private final String word;
    private final String person;

    public WordNotSparrow(String word, String person) {
        this.word = word;
        this.person = person;
    }

    public String getWord() {
        return word;
    }

    public String getPerson() {
        return person;
    }
}