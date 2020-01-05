package homework.homework2.evenOddString;

class Odd {

    void createString (String str) {

        String result = "";

        for(int i=0; i<str.length(); i=i+2) {
            result += str.charAt(i);
        }

        System.out.println(result);
    }
}
