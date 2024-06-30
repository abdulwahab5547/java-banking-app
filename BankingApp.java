import java.util.Scanner;

// BankAccount class to manage account operations
class BankAccount {
    private int rightPin = 2244;
    private int totalBalance = 10000;
    private Scanner scanner = new Scanner(System.in);

    // Method to handle main menu operations
    public void showMainMenu() {
        char decision;
        do {
            System.out.println("Welcome to the Banking App Management System!");
            System.out.println("1- To send money, press D.");
            System.out.println("2- To request money, press R.");
            System.out.println("3- To check balance, press B.");
            System.out.println("4- For ATM security settings, press S.");
            System.out.println("5- To download your transaction history, press H.");
            System.out.println("6- To pay a utility bill, press P.");
            System.out.println("7- To log out, press N.");
            System.out.println("8- To cancel, press O.");

            decision = scanner.next().charAt(0);

            switch (decision) {
                case 'D':
                    sendMoney();
                    break;
                case 'R':
                    requestMoney();
                    break;
                case 'B':
                    checkBalance();
                    break;
                case 'S':
                    manageSecurity();
                    break;
                case 'H':
                    downloadTransactionHistory();
                    break;
                case 'P':
                    payUtilityBill();
                    break;
                case 'N':
                    return;
                case 'O':
                    System.out.println("Operation cancelled.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (decision != 'O');
    }

    // Method to handle sending money
    private void sendMoney() {
        System.out.println("Your account balance is: " + totalBalance + "rs");
        System.out.println("How much amount do you want to send?");
        int amount = scanner.nextInt();
        System.out.println("Please enter the account number of the recipient");
        int accountNo = scanner.nextInt();

        if (amount <= totalBalance) {
            System.out.println("The amount of " + amount + " has been sent to " + accountNo);
            totalBalance -= amount;
            System.out.println("The amount left in your bank account is: " + totalBalance + "rs");
            System.out.println("Thank you for using the Banking App Management System!");
            System.out.println("Press B to go back.");
            char back = scanner.next().charAt(0);
            if (back == 'B') {
                showMainMenu();
            }
        } else {
            System.out.println("You can send a maximum of " + totalBalance + " amount.");
        }
    }

    // Method to handle requesting money
    private void requestMoney() {
        System.out.println("Your account balance is: " + totalBalance + "rs");
        System.out.println("How much amount do you want to request?");
        int receive = scanner.nextInt();
        System.out.println("Enter the account number of the payer");
        int accountNo = scanner.nextInt();
        System.out.println("The payment request of " + receive + "rs has been sent to " + accountNo);
        System.out.println("Thank you for using the Banking App Management System!");
        System.out.println("Press B to go back.");
        char back = scanner.next().charAt(0);
        if (back == 'B') {
            showMainMenu();
        }
    }

    // Method to check account balance
    private void checkBalance() {
        System.out.println("Your account balance is: " + totalBalance + "rs");
        System.out.println("Press B to go back.");
        char back = scanner.next().charAt(0);
        if (back == 'B') {
            showMainMenu();
        }
    }

    // Method to manage ATM security settings
    private void manageSecurity() {
        System.out.println("To change your app PIN, press C.");
        System.out.println("To lock your ATM card, press L.");
        char decision = scanner.next().charAt(0);

        switch (decision) {
            case 'C':
                System.out.println("Are you sure you want to change your app PIN? If so, please enter your current PIN again.");
                int pin = scanner.nextInt();
                if (pin == rightPin) {
                    System.out.println("Please enter your new PIN");
                    rightPin = scanner.nextInt();
                    System.out.println("Your PIN has been changed.");
                }
                break;
            case 'L':
                System.out.println("Are you sure you want to lock your ATM card? Press Y to continue.");
                char confirm = scanner.next().charAt(0);
                if (confirm == 'Y') {
                    System.out.println("Your card has been locked. It cannot be used for transactions anymore.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Press B to go back.");
        char back = scanner.next().charAt(0);
        if (back == 'B') {
            showMainMenu();
        }
    }

    // Method to download transaction history
    private void downloadTransactionHistory() {
        System.out.println("Are you sure you want to download your transaction history? Press Y to continue. Press B to go to the main menu.");
        char decision = scanner.next().charAt(0);
        if (decision == 'Y') {
            System.out.println("Your transaction history has been downloaded.");
        }

        System.out.println("Press B to go back.");
        char back = scanner.next().charAt(0);
        if (back == 'B') {
            showMainMenu();
        }
    }

    // Method to handle utility bill payments
    private void payUtilityBill() {
        System.out.println("Which utility bill do you want to pay?");
        System.out.println("1- Press E for Electricity(MEPCO)");
        System.out.println("2- Press N for Education");
        System.out.println("3- Press I for Internet?");
        char decision = scanner.next().charAt(0);

        switch (decision) {
            case 'E':
                System.out.println("Please enter your reference number");
                int ref = scanner.nextInt();
                System.out.println("Your bill amount is 7500rs. Press P to pay the bill.");
                char pay = scanner.next().charAt(0);
                if (pay == 'P') {
                    System.out.println("The bill has been paid.");
                    totalBalance -= 7500;
                    System.out.println("Your remaining bank balance is: " + totalBalance + "rs");
                }
                break;
            case 'I':
                System.out.println("Your internet fee due is 2500rs. Press P to pay it.");
                pay = scanner.next().charAt(0);
                if (pay == 'P') {
                    System.out.println("The internet fee has been paid.");
                    totalBalance -= 2500;
                    System.out.println("Your remaining bank balance is: " + totalBalance + "rs");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        System.out.println("Press B to go back.");
        char back = scanner.next().charAt(0);
        if (back == 'B') {
            showMainMenu();
        }
    }
}

// Main class to run the banking application
public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rightPin = 2244;

        do {
            System.out.println("Enter your pin:");
            int pin = scanner.nextInt();

            if (pin == rightPin) {
                BankAccount bankAccount = new BankAccount();
                bankAccount.showMainMenu();
            } else {
                System.out.println("Incorrect pin. Press T to try again.");
                char decision = scanner.next().charAt(0);
                if (decision != 'T') {
                    break;
                }
            }
        } while (true);

        System.out.println("End of program.");
    }
}
