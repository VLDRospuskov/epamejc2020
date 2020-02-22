package homeworks.utility.helper;

public class HelperTestDrive {
    public static void main(String[] args) {
        try {

            while (true) {
                String s = Helper.getString();
                System.out.println(s);

                String s2 = Helper.getString("Что-нибудь: ");
                System.out.println(s2);

                int n1 = Helper.getInt();
                System.out.println(n1);

                int n2 = Helper.getInt("Где-нибудь: ");
                System.out.println(n2);
                System.out.println("------------------------------");
            }

        } catch (CancellationException ignored) {}
    }
}
