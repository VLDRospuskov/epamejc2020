package lessons.java.lesson21.example18;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Main {

    public static void main(String[] args) {
         Cat barsik = new Cat("barsik");
         Cat murzik = new Cat("murzik"); // 2
         Cat rijik = new Cat("rijik"); // 1

         rijik = barsik; // new Cat("barsik")
         murzik = rijik;
         barsik = murzik;

         //GC = 2
    }

}

@AllArgsConstructor
@Data
class Cat {

    String name;

}