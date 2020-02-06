package homeworks.homework2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RickSanchez {

    private final String name;
    private final SpatialDimension spatialDimension;
    private final List<String> family;

    public RickSanchez(String name, SpatialDimension spatialDimension, List<String> family) {
        this.name = name;
        this.spatialDimension = ImmutableSpatialDimension.getInstance(spatialDimension);

        List<String> tmpList = new ArrayList<>(family);
        this.family = Collections.unmodifiableList(tmpList);
    }

    public String getName() {
        return name;
    }

    public SpatialDimension getSpatialDimension() {
        return spatialDimension;
    }

    public List<String> getFamily() {
        return family;
    }

    public boolean hasMorty() {
        return this.family.contains("Morty");
    }

    @Override
    public String toString() {
        return "RickSanchez{" +
                "name='" + name + '\'' +
                ", spatialDimension=" + spatialDimension +
                ", family=" + family +
                '}';
    }

}
