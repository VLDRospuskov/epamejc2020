package homeworks.homework7.functional_interface.repository;

import homeworks.homework7.functional_interface.exception.UserNotFoundException;
import homeworks.homework7.functional_interface.model.User;
import homeworks.homework7.functional_interface.myfunctional.Supporter;
import homeworks.homework7.functional_interface.myfunctional.UserCreator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserRepository {
    private final List<User> users;

    public void addUser(UserCreator<User> creator, String name, String password, Supporter supporter) {
        User user = creator.getUser(name, password);
        if (users.contains(user)) {
            throw supporter.notifi();
        } else {
            users.add(user);
        }
    }

    public User getUser(UserCreator<User> creator, String name, String password, Supporter supporter) {
        User user = creator.getUser(name, password);
        for (User inRepUser : users) {
            if (inRepUser.equals(user)) {
                return user;
            }
        }
        throw supporter.notifi();
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (name.equals(user.getName())) {
                return user;
            }
        }
        throw new UserNotFoundException(name);
    }

}
