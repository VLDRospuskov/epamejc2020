package homework.homework6;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Author {

    public String name;
    public int age;

    public Author () {
        Package thisPackage = Author.class.getPackage();
        this.name = thisPackage.getDeclaredAnnotation(AuthorAnnotation.class).name();
        this.age = thisPackage.getDeclaredAnnotation(AuthorAnnotation.class).age();
    }
}
