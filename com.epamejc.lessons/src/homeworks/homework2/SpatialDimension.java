package homeworks.homework2;

public class SpatialDimension {
    private String name;

    public SpatialDimension(String name) {
        this.name = name;
    }

    public SpatialDimension() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpatialDimension{" +
                "name='" + name + '\'' +
                '}';
    }
}
