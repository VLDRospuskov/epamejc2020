package homeworks.homework4.indexStringGenerator;

class StringGenerator {

    StringBuilder result = new StringBuilder();

    void generate(String userString, int userIndex) {

        char[] chars = userString.toCharArray();
        int beginningOfNewWord = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ' && i < userIndex) {

                beginningOfNewWord = addFromPreviousWord(chars, beginningOfNewWord, i);

            } else if (i == userIndex && chars[i] != ' ') {

                addFromCurrentWord(userIndex, chars, beginningOfNewWord);
                break;

            } else if (i == userIndex && chars[i] == ' ') {

                addFromNextWord(userIndex, chars, beginningOfNewWord);
                break;
            }
        }
        System.out.println(result);
    }

    private void addFromNextWord(int userIndex, char[] chars, int beginningOfNewWord) {
        if (userIndex != 0) {
            result.append(chars[beginningOfNewWord]);
        }
        result.append(chars[userIndex - 1]);
    }

    private void addFromCurrentWord(int userIndex, char[] chars, int beginningOfNewWord) {
        if (userIndex != 0 && userIndex != beginningOfNewWord) {
            result.append(chars[beginningOfNewWord]);
        }
        result.append(chars[userIndex]);
    }

    private int addFromPreviousWord(char[] chars, int beginningOfNewWord, int i) {
        result.append(chars[beginningOfNewWord]);
        result.append(chars[i - 1]);
        beginningOfNewWord = i + 1;
        return beginningOfNewWord;
    }
}
