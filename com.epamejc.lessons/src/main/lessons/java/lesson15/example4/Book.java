package lessons.java.lesson15.example4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String bookName;
    private List<Author> authorList;

}
