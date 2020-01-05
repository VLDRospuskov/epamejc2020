package homework.homework2.evenOddString;

class Even {

    void createString (String str) {

        String result = "";

        for(int i=1; i<str.length(); i=i+2) {
            result += str.charAt(i);
        }

        System.out.println(result);
    }
}
