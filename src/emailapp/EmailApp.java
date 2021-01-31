package emailapp;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        CreateEmailForNewEmployee em1 = new CreateEmailForNewEmployee("John", "Smith");
        int choice = -1;
        do {
            System.out.println("\nENTER CHOICE\n1.Show Info\n2.Change Password"
                    + "\n3.Change Mailbox Capacity\n4.Set Alternate CreateEmailForNewEmployee\n5.Exit");
            choice = s.nextInt();
            switch(choice) {
                case 1:
                    em1.printInfo();
                    break;
                case 2:
                    em1.changePassword();
                    break;
                case 3:
                    em1.setupMailCap();
                    break;
                case 4:
                    em1.alternateEmail();
                    break;
                case 5:
                    System.out.println("\nTHANKS!");
                    break;
                default:
                    System.out.println("INVALID CHOICE! ENTER AGAIN!");
            }
        }while(choice!=5);
    }
}