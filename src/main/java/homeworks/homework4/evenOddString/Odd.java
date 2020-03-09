package homeworks.homework4.evenOddString;

class Odd {

    void createString (String str) {

        StringBuilder result = new StringBuilder();

        for(int i=0; i<str.length(); i=i+2) {
            result.append(str.charAt(i));
        }

        System.out.println(result);
    }
}
