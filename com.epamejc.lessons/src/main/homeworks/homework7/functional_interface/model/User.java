package homeworks.homework7.functional_interface.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.getName()) &&
                password.equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
