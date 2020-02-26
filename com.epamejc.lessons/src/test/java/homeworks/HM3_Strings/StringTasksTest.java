package homeworks.HM3_Strings;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

public class StringTasksTest {

    StringTasks stringTasks = new StringTasks();
    private BufferedReader reader;
    private String value = "Hello, world!";

        @Test
        public void testPrintOddEvenLetters() {
            String input = value + "\neven";
            String expected = "el,wrd";

            mockReader(input);
            stringTasks.setReader(reader);

            Assert.assertEquals(expected,stringTasks.printOddEvenLetters());
    }

    @Test
    public void testPrintStringFromIndexes() {
        String input = value + "\n2\n4\n5\n6\nexit";
        String expected = "elo,";

        mockReader(input);
        stringTasks.setReader(reader);

        Assert.assertEquals(expected,stringTasks.printStrFromIndexes());
    }

    @Test
    public void testSwapLetters() {
        String input = value + "\n2\n7";
        String expected = "Hewlo, lorld!";

        mockReader(input);
        stringTasks.setReader(reader);

        Assert.assertEquals(expected, stringTasks.swapLetters());
    }

    @Test
    public void testReverseWords() {
        String input = value;
        String expected = "olleH, dlrow!";

        mockReader(input);
        stringTasks.setReader(reader);

        Assert.assertEquals(expected, stringTasks.reverseWords());
    }

    // TODO можно ли вместо добавления этого метода во все классы теста, например, создать абстрактный класс (или интерфейс) MockableTest и всегда наследоваться от него?
    //  Или создать статический метод где то во вспомогательном классе в папке тестов?
    private void mockReader(String str) {
        byte[] bytes = str.getBytes();
        reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
    }

}
