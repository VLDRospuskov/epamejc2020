package homeworks.homework2;

public final class ImmutableSpatialDimension extends SpatialDimension {
    private final String name;

    public ImmutableSpatialDimension(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SpatialDimension{" +
                "name='" + name + '\'' +
                '}';
    }

    public static ImmutableSpatialDimension getInstance(SpatialDimension sD) {
        return new ImmutableSpatialDimension(sD.getName());
    }
}
