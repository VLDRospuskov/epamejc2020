package lessons.java.lesson6.example2;

public class Hospital {
    public static void main(String[] args) {
//        Doctor doctor = new Doctor();
//        doctor.info();
//        doctor.print();
//        System.out.println(doctor.x);


        MedicalStaff med = new Doctor();
        System.out.println(med);
        med.info();
        System.out.println(med.getX());
//        med.print();
        Man man = new Doctor();
        System.out.println(man.x);
    }

}

class Man {

    public int x = 5;

    public void info() {
        System.out.println("Man");
    }

    public int getX() {
        return x;
    }

}

class MedicalStaff extends Man {

    private int x = 10;

    public void info() {
        System.out.println("MedicalStaff");
    }

    public int getX() {
        return x;
    }

}

class Doctor extends MedicalStaff {

    public int x = 15;

    @Override
    public int getX() {
        return x;
    }

    public void info() {
        System.out.println("Doctor");
    }

    public void print() {
        System.out.println("print");
    }

}
