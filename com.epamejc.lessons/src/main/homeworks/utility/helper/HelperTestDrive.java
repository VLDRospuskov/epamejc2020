package homeworks.utility.helper;

public class HelperTestDrive {
    public static void main(String[] args) {
        try {

            while (true) {
                String s = Helper.getStringInLoop();
                System.out.println(s);

                String s2 = Helper.getStringInLoop("Что-нибудь: ");
                System.out.println(s2);

                int n1 = Helper.getIntInLoop();
                System.out.println(n1);

                int n2 = Helper.getIntInLoop("Где-нибудь: ");
                System.out.println(n2);
                System.out.println("------------------------------");
            }

        } catch (CancellationException ignored) {}
    }
}
