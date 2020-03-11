package homeworks.homework6;

public class Author {

    public String name;
    public int age;

    public Author () throws NegativeAgeException {

        AuthorAnnotation annotation = getDeclaredAnnotation();

        int age = annotation.age();

        String name = annotation.name();

        createAuthor(name, age);
    }

    public Author (String name, int age) throws NegativeAgeException {
        createAuthor(name, age);
    }

    private AuthorAnnotation getDeclaredAnnotation() {
        return Author.class.getPackage().getDeclaredAnnotation(AuthorAnnotation.class);
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
