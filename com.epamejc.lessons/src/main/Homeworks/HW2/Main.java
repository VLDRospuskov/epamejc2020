package main.Homeworks.HW2;

public class Main {
    public static void main(String[] args) {
        //Создание объекта неизменяемого класса
        ImmutablePlane plane = new ImmutablePlane("Boeing", "737 MAX", 2018, 132);
        //plane.model = "747-800"; -> невозможно изменить поле экземпляра класса
        //private class PlaneExtends extends ImmutablePlane {} -> невозможно наследовать класс
        int planeId = plane.getPlaneId(); // -> возможно только получить значения полей экземпляра класса
        System.out.println("Plane Data: \n" + "Manufacturer: " + plane.getManufacturer() + "\nModel: " + plane.getModel());
    }
}
