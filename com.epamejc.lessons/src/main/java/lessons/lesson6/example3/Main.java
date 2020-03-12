package lessons.lesson6.example3;

public class Main {

    public static void main(String[] args) {
        MedicalStaff med = new Doctor();
        Doctor doctor = new Doctor();

        med.info();
        med.prescriptionMedicine();
//med.createMedicine();
        MedicalStaff.staticMedical();

        doctor.info();
        doctor.prescriptionMedicine();
        doctor.createMedicine();
        Doctor.staticMedical();

    }
}


class MedicalStaff {

    public static void staticMedical() {
        System.out.println("staticMedicalStaff");
    }

    public void prescriptionMedicine() {
        System.out.println("prescriptionMedicine");
    }

    public void info() {
        System.out.println("MedicalStaff");
    }
}

class Doctor extends MedicalStaff {

    public static void staticMedical() {
        System.out.println("staticDoctor");
    }

    public void createMedicine() {
        System.out.println("createMedicine");
    }

    public void info() {
        System.out.println("Doctor");
    }
}
