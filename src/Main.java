import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        ArrayList<String> websites = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        Scanner scanner =new Scanner(System.in);
        boolean isRunning=true;

        System.out.println("--- Password Manager Started Successfully ---");


        System.out.println("--- Welcome to Secure Password Manager ---");

        while(isRunning){
            System.out.println("\n=== MENU ===");
            System.out.println("1.Add a Password");
            System.out.println("2.Display Saved Passwords");
            System.out.println("3.Exit Application");
            System.out.print("Choose an Option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice==1) {
                System.out.print("Enter website Name(e.g.,Facebook): ");
                String site = scanner.nextLine();
                System.out.print("Enter password for" + site + ":");
                String rawPass = scanner.nextLine();

                String encryptedPass = Base64.getEncoder().encodeToString(rawPass.getBytes());
                websites.add(site);
                passwords.add(encryptedPass);
                System.out.println("\n[SUCCESS]Password saved for" + site + "!");

            }else if (choice==2) {
                System.out.println("\n--- Your Saved Passwords ---");
                if (websites.isEmpty()) {
                    System.out.println("No passwords saved yet.");
                } else {
                    for (int i = 0; i < websites.size(); i++){
                        String storedPass = passwords.get(i);
                        byte[]decodeBytes = Base64.getDecoder().decode(storedPass);
                        String decryptedPass=new String (decodeBytes);

                        System.out.println("Website:" + websites.get(i) + " | Stored(Encrypted):" + storedPass+ "Actual Password:"+ decryptedPass);
                    }
                }

            }else if(choice==3) {
                isRunning = false;
                System.out.println("Exiting Application.Goodbye!");
            }else{
                System.out.println("Invalid option! Please try again.");
            }
        }
        scanner.close();
    }
}
