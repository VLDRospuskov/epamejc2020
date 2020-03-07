package homeworks.homework4_strings;

import homeworks.control.exeption.IllegalDataException;
import homeworks.control.services.ServiceImpl;

public class EvenOdd extends ServiceImpl {
    @Override
    public String getResult(String userRequest) throws IllegalDataException {

        String[] temp = parseRequest(userRequest);
        boolean EvenOdd = isEvenOdd(temp[temp.length-1]);
        if (EvenOdd){

            String body = parseArray(temp).trim();
            return makeString(body,temp[temp.length-1]);
        } else {
            throw new IllegalDataException(String.format("%s is not even or odd",temp.length-1));
        }
    }
    private String[] parseRequest(String userRequest)throws IllegalDataException {
        String[] temp = userRequest.split("\\s+");
        int min = 2;
        if (temp.length >= min) {
            return temp;
        } else {
            throw new IllegalDataException(String.format("%s should looks like \"string even(odd)\"",userRequest));
        }
    }
    private String makeString (String str, String EvenOdd){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {

            if (EvenOdd.equals(EVEN) && i % 2 == 0) {
                sb.append(str.charAt(i));

            } else if (EvenOdd.equals(ODD) && i % 2 != 0) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
    private String parseArray(String[] strings){
        StringBuilder sb = new StringBuilder();
        if (strings.length >= 2){
            for (int i = 0; i < strings.length-1; i++){
                sb.append(strings[i]);
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        EvenOdd e = new EvenOdd();
        System.out.println(e.getResult("World of Warcraft even"));
        System.out.println(e.getResult("World of Warcraft odd"));
    }
}
