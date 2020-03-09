package homeworks.homework6;

public class Main {

    public static void main(String[] args) {

        ShowOff coolGuy = author -> System.out.printf("\nAuthor's age is %d and you'll never guess his name ... it's %s\n",
                author.age, author.name);

        try {

            Author badAuthor = new Author("Yarik", 0);
            coolGuy.show(badAuthor);
            Author author = new Author();
            coolGuy.show(author);

        } catch (NegativeAgeException ex) {
            ex.printStackTrace();
        }

    }
}
