package homework8.part1;


class Main {

    public static void main(String[] args) {
        User user = new User("Art", 21, "dev", 100);
        user.selectInfo((name1, age1, profession1) -> {
            return "name:"+name1 +"; age:"+ age1+ "; profession:" + profession1;
        }, user::getSalary);
    }
}










