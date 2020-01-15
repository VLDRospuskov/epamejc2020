package homeworks.homework2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class RickSanchez {
    private final String name;
    private final SpatialDimension spatialDimension;
    private final List<String> family;

    public RickSanchez(String name, SpatialDimension spatialDimension, List<String> family) {
        this.name = name;
        this.spatialDimension = spatialDimension;
        this.family = Collections.unmodifiableList(family);
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

    public RickSanchez setSpatialDimension(SpatialDimension sd) {
        return new RickSanchez(this.name, sd, this.family);
    }

    public boolean hasMorty() {
        if (this.family.contains("Morty")) {
            return true;
        }

        return false;
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
