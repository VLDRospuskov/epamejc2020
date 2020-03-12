package homeworks.homework3.task2_2;

public class ABStrategy {
    
    public String selectStrategy(char[][] inputArray, String strategy) {
        switch (strategy.toUpperCase()) {
            case "A":
                return useAStrategy(inputArray);
            case "B":
                return useBStrategy(inputArray);
            default:
                System.out.println("Wrong input");
                return "";
        }
    }
    
    private String useAStrategy(char[][] inputArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < inputArray.length; i += 2) {
            for (int j = 0; j < inputArray[0].length; j += 2) {
                stringBuilder.append(inputArray[i][j]);
            }
        }
        return stringBuilder.toString();
    }
    
    private String useBStrategy(char[][] inputArray) {
        StringBuilder stringBuilder = new StringBuilder();
        if ((inputArray.length > 1) && (inputArray[0].length > 1)) {
            for (int i = 1; i < inputArray.length; i += 2) {
                for (int j = 1; j < inputArray[0].length; j += 2) {
                    stringBuilder.append(inputArray[i][j]);
                }
            }
            return stringBuilder.toString();
        } else {
            System.out.println("Too short for B strategy");
            return "";
        }
    }
    
}
