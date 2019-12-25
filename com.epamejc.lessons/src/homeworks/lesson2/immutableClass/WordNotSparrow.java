package homeworks.lesson2.immutableClass;

public final class WordNotSparrow {
    final String word;
    final String person;

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