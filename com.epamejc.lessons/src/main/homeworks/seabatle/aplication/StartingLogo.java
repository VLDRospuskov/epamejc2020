package homeworks.seabatle.aplication;

public class StartingLogo implements Runnable{
    String COMPANY = "Epam Education Java Core";
    String UPDATINGDRIVERS = "Updating Drivers";
    String CONFIGURATINGSYSTEM = "Configurating System";
    String TITLE = "Sea Battle";
    @Override
    public void run() {
        try {
            printCompany();
            printInformation(UPDATINGDRIVERS);
            printInformation(CONFIGURATINGSYSTEM);
            printTitle();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }


    }

    private void printCompany() throws InterruptedException {
        for (int i = 0; i < COMPANY.length(); i++){
            System.out.print(COMPANY.charAt(i));
            Thread.sleep(100);
        }
        Thread.sleep(1000);
        System.out.println();
    }

    private void printInformation(String string) throws InterruptedException {
        System.out.print(string);
        for (int i = 0; i < 8; i++){
            System.out.print(".");
            Thread.sleep(500);
        }
        System.out.println();
    }

    private void printTitle() throws InterruptedException {
        System.out.println(TITLE);
        Thread.sleep(1000);
    }


}
