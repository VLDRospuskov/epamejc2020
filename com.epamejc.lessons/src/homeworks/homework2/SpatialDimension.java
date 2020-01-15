package homeworks.homework2;

public final class SpatialDimension {
    private final String name;

    SpatialDimension(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public SpatialDimension setName(String name) {
        return new SpatialDimension(name);
    }

    @Override
    public String toString() {
        return "SpatialDimension{" +
                "name='" + name + '\'' +
                '}';
    }
}
