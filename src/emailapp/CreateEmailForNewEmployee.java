package emailapp;

import java.util.Scanner;
import java.util.Random;

public class CreateEmailForNewEmployee {

    public Scanner s = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String altEmail;

    public CreateEmailForNewEmployee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New worker: " + this.firstName + " " + this.lastName);

        this.department = this.choiceDept();

        this.password = this.generatePassword(8);

        this.email = this.generateEmail();
    }

    private String generateEmail() {
        return this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department.toLowerCase()
                + ".4programmers.net";
    }

    private String choiceDept() {
        System.out.println(
                "Department code\n1 Sales\n2 Development\n3 Accounting\n0 None");
        boolean flag = false;
        do {
            System.out.print("Enter Department Code: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("INVALID CHOICE");
            }
        } while (!flag);
        return null;
    }

    public void setupMailCap() {
        System.out.println("Current capacity = " + this.mailCapacity + "mb");
        System.out.print("Enter new capacity: ");
        this.mailCapacity = s.nextInt();
        System.out.println("MAILBOX CAPACITY CHANGED SUCCESSFULLY!");

    }
    public void alternateEmail() {
        System.out.print("Enter new alternate email: ");
        this.altEmail = s.next();
        System.out.println("ALTERNATE EMAIL SET SUCCESSFULLY!");
    }

    public void printInfo() {
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("Department: " + this.department);
        System.out.println("CreateEmailForNewEmployee: " + this.email);
        System.out.println("Password: " + this.password);
        System.out.println("Mailbox Capacity: " + this.mailCapacity + "mb");
        System.out.println("Alter CreateEmailForNewEmployee: " + this.altEmail);
    }
    private String generatePassword(int length) {
        Random r = new Random();

        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;

        String password = "";
        for (int i = 0; i < length; i++) {
            password = password + values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

    public void changePassword() {
        boolean flag = false;
        do {
            System.out.print("Change password? (Y/N) : ");
            char choice = s.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.print("Enter current password: ");
                String temp = s.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password: ");
                    this.password = s.next();
                    System.out.println("PASSWORD CHANGED");
                } else {
                    System.out.println("Incorrect Password!");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("PASSWORD CHANGE CANCELED!");
            } else {
                System.out.println("ENTER A VALID CHOICE");
            }
        } while (!flag);
    }
}