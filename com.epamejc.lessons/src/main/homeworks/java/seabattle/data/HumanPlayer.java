package homeworks.java.seabattle.data;

import homeworks.java.utils.UserInputReader;

public class HumanPlayer extends Player{

    private String REGEX = "^[a-zA-Z]\\d+$";
    private String SPLIT_REGEX = "(?<=[a-zA-Z])(?=\\d)";

   public HumanPlayer(String name) {

       super();
       super.setName(name);
       super.setVisible(true);

   }

    @Override
    public Cell shoot() {

       String input = UserInputReader.readInput();
       Cell cell = null;

            if (input.length() != 0 && input.matches(REGEX)) {
                String[] split = input.split(SPLIT_REGEX);
                cell = new Cell(Character.toLowerCase(split[0].charAt(0)) - 96, Integer.valueOf(split[1]));
        }
        return cell;

    }

}
