package homeworks.homework7_functional.myfunctional;

import homeworks.homework7_functional.model.User;

@FunctionalInterface
public interface UserCreator<T extends User>{
    T getUser(String name, String password);
}
