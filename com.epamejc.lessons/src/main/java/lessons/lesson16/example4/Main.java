package lessons.lesson16.example4;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        User user = getUserById(2);
        System.out.println(user);
    }

    public static User getUserById(int id) {
        List<User> users = getUsers();
        return users.stream()
                .parallel()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElseThrow(() -> new lessons.java.lesson16.example4.UserNotFoundException("User not found by Id"));
    }

    // DB
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(2, "Boris"));
        users.add(new User(2, "Vladimir"));
        users.add(new User(2, "Alexey"));
        users.add(new User(2, "Dmitrii"));
        users.add(new User(2, "Masha"));
        users.add(new User(2, "Nastya"));
        return users;
    }

}

@Data
@AllArgsConstructor
class User {

    private int id;
    private String name;

}
