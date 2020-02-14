package Homeworks.HW2;

public class ImmutableClass {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private ImmutableClass(ImmutableClassBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static class ImmutableClassBuilder{
        private int id;
        private String name;

        public ImmutableClassBuilder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public ImmutableClass build() {
            return new ImmutableClass(this);
        }
    }
}
