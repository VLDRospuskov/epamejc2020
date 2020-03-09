package homework.homework8.functionalInterfaces;

import lombok.Data;

@Data
public class Human {
    private String name;
    private Integer age;

    public String formInfo(Getter<String> nameGetter, Getter<Integer> ageGetter,
                           Handler<String, Integer, String> infoHandler) {
        return infoHandler.handle(nameGetter.get(), ageGetter.get());
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.setName("Yana");
        human.setAge(24);

        Getter<String> nameGetter = () -> human.getName();
        Getter<Integer> ageGetter = () -> human.getAge();
        Handler<String, Integer, String> handler = (name, age) -> String.format(
                "My name is %1$s and I'm %2$d years old", name, age);

        System.out.println(human.formInfo(nameGetter, ageGetter, handler));
    }
}
