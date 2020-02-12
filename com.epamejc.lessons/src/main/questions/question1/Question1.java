package questions.question1;

public class Question1 {

    public String method(int i, Object o) {
        return methodPrivate("something", i, o);
    }

    private String methodPrivate(String something, int i, Object o) {
        /**
         * some logic here
         */
        return "stuff";
    }
}
