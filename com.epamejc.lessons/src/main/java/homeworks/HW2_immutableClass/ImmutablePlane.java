package homeworks.HW2_immutableClass;

public final class ImmutablePlane {
    private final String manufacturer;
    private final String model;
    private final int productionYear;
    private final int planeId;

    public ImmutablePlane(String manufacturer, String model, int productionYear, int planeId) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.planeId = planeId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public int getPlaneId() {
        return planeId;
    }
}
