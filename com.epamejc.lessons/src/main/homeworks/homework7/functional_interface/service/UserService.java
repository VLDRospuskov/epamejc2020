package homeworks.homework7.functional_interface.service;

import homeworks.homework7.functional_interface.exception.UserAlreadyExistException;
import homeworks.homework7.functional_interface.exception.UserNotFoundException;
import homeworks.homework7.functional_interface.model.User;
import homeworks.homework7.functional_interface.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void addUser(String name, String password) {
        userRepository.addUser(User::new, name, password,
                () -> new UserAlreadyExistException(name + " " + password));
    }

    public User getUser(String name) {
        return userRepository.getUserByName(name);
    }

    public User getUser(String name, String password) {
        return userRepository.getUser(User::new, name, password,
                () -> new UserNotFoundException(name + " " + password));
    }

}
