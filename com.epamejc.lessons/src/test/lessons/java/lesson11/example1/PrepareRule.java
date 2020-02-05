package test.lessons.java.lesson11.example1;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class PrepareRule implements TestRule {

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("BEFORE");
                base.evaluate();
                System.out.println("AFTER");
            }
        };
    }
}
