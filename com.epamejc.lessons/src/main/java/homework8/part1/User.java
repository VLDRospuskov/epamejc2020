package homework8.part1;

class User {
    private String name;
    private Integer age;
    private String profession;
    private Integer salary;

    User(String name, Integer age, String profession, Integer salary) {
        this.name = name;
        this.age = age;
        this.profession = profession;
        this.salary = salary;
    }

    void selectInfo(MyTriFunctional<String, Integer, String, String> usr, MySupplier<Integer> sal) {
        String pi = usr.get(name, age, profession);
        String si =sal.get().toString();
        System.out.println("Personal Information\n"+pi+"\nSalary\n"+si);
    }

    Integer getSalary() {
        return salary;
    }
}
