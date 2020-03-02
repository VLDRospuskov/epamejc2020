package homeworks.homework4.indexStringGenerator;

class StringGenerator {

    void generate (String userString, int userIndex) {

        char[] chars = userString.toCharArray();
        int beginningOfNewWord = 0;
        String result = "";

        for (int i=0; i<chars.length; i++) {

            if (chars[i] == ' ' && i < userIndex) {

                result += chars[beginningOfNewWord];
                result += chars[i-1];
                beginningOfNewWord = i + 1;

            } else if (i == userIndex && chars[i] != ' ') {

                if (userIndex != 0 && userIndex != beginningOfNewWord) {
                    result += chars[beginningOfNewWord];
                }
                result += chars[userIndex];
                break;

            } else if (i == userIndex && chars[i] == ' ') {

                if (userIndex != 0) {
                    result += chars[beginningOfNewWord];
                }
                result += chars[userIndex-1];
                break;
            }
        }
        System.out.println(result);
    }
}
