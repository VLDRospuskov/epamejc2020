package homeworks.homework7.functional_interface.myfunctional;

import homeworks.homework7.functional_interface.model.User;

@FunctionalInterface
public interface UserCreator<T extends User>{

    T getUser(String name, String password);
}
