package homeworks.homework2_arrays.strategy;

public class OddBuildStrategy implements BuildStrategy {

    public String build(Character[][] chars) {
        StringBuilder sb = new StringBuilder();
        if (chars.length > 0) {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i].length; j++) {
                    if (j % 2 != 0) {
                        sb.append(chars[i][j]);
                    }
                }
            }
        }
        return sb.toString();
    }
}