package homework2.ArrayPyramid;

public class buildPyramidLogic {

    public String buildPyramid(int height) {
        StringBuilder out = new StringBuilder();
        if (height > 0) {
            String str = "X";
            for (int i = 0; i < height; i++) {
                StringBuilder tempString = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    tempString.append(str);
                }
                out.append(tempString).append("\r\n");
            }
        }
        return out.reverse().toString();
    }

}
