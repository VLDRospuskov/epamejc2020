package homeworks.homework6;

public class Author {

    public String name;
    public int age;

    public Author () throws NegativeAgeException {

        Package thisPackage = Author.class.getPackage();

        int age = thisPackage.getDeclaredAnnotation(AuthorAnnotation.class).age();

        String name = thisPackage.getDeclaredAnnotation(AuthorAnnotation.class).name();

        createAuthor(name, age);
    }

    public Author (String name, int age) throws NegativeAgeException {
        createAuthor(name, age);
    }

    private void createAuthor (String name, int age) throws NegativeAgeException {
        if (age >= 0) {
            this.name = name;
            this.age = age;
        } else {
            throw new NegativeAgeException();
        }
    }
}
