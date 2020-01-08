package main.homeworks.hw3.strings.secondstringtask;

class LineByIndex {

    static StringBuilder makeTheLineByIndexes(String word, int... indexes) {

        StringBuilder line = new StringBuilder();

        for (int x : indexes) {
            if (x >= 0 && x <= word.length()) {

                line.append(word.charAt(x));

            } else {
                System.out.println("Attention: at least one of the indexes is bigger than word's length");
            }
        }

        System.out.println("Line from existing in the word indexes:");

        System.out.println(line);
        return line;
    }

}
