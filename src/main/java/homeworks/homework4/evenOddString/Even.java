package homeworks.homework4.evenOddString;

class Even {

    void createString (String str) {

        StringBuilder result = new StringBuilder();

        for(int i=1; i<str.length(); i=i+2) {
            result.append(str.charAt(i));
        }

        System.out.println(result);
    }
}
