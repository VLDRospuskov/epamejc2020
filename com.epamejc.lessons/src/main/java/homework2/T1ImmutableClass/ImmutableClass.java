package homework2.T1ImmutableClass;

final class ImmutableClass {
    private final int id;
    private final String username;

    ImmutableClass(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }


}