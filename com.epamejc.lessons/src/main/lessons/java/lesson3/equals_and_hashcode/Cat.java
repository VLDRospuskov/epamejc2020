package lessons.java.lesson3.equals_and_hashcode;

import java.util.Objects;

public class Cat {

    private int id;
    private String name;

    public Cat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id &&
                Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    //    @Override
//    public int hashCode() {
//        System.out.println("call hashCode: " + id);
//        return 31 * id * name.length();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        System.out.println("call equals: " + id);
//        Cat secondCat = (Cat) obj;
//        return this.id == secondCat.id && this.name.equals(secondCat.name);
//    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
