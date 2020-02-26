package homeworks.homework2.arrays;


import homeworks.control.services.ServiceImpl;


public class Pyramid extends ServiceImpl {


    @Override
    public String getResult(String userRequest) {
        Integer pirLength = chekInt(userRequest);
        return makePiramide(pirLength);
    }

    private String makePiramide(int pirLength) {
        char[][] strings = getCharArr(pirLength);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pirLength; i++) {
            for (int j = 0; j < pirLength - i; j++) {
                sb.append(strings[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private char[][] getCharArr(int pirLength) {
        char[][] piramide = new char[pirLength][];
        char randomChar = makeRandomChar();
        for (int i = 0; i < pirLength; i++) {
            char[] stroke = new char[pirLength - i];
            for (int j = 0; j < pirLength - i; j++) {
                stroke[j] = randomChar;
            }
            piramide[i] = stroke;
        }
        return piramide;
    }


}
