package java_projects;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MiniBank {

    enum features{
        DEPOSIT(1),WITHDRAW(2),BALANCE(3),VIEWSATEMENT(4),SWITCHUSER(5);
        private final int value;
        features(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static String CurrentUser;
    static HashMap<String,Double> users = new HashMap<>();
    static HashMap<String, ArrayList<String>> statements = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Hi, Please Enter Your Name: ");
        String name = sc.nextLine();

        if(users.containsKey(name)){
            CurrentUser = name;
            allOptions(sc,name);
        }else{
            newUser(sc,name);
        }
    }

    //Function to Deposit Money
    public static void Deposit(Scanner sc){
        System.out.print("Enter the amount you want to deposit : ");
        double amount = sc.nextDouble();
        if(amount > 0){
            double currentBalance = users.get(CurrentUser);
            currentBalance += amount;
            users.put(CurrentUser,currentBalance);
            statements.get(CurrentUser).add(new Date() + " Credit : " + amount );
            System.out.println("Deposit Success! Remaining Balance: $" + currentBalance);
        }else{
            System.out.print("Amount Invalid! Please Retry");
        }
    }

    //Function to Withdraw Money
    public static void Withdraw(Scanner sc){
        System.out.print("Enter the amount you want to withdraw : ");
        double amount = sc.nextDouble();
        double currentBalance = users.get(CurrentUser);
        if(amount > 0 && amount <= currentBalance){
            currentBalance -= amount;
            users.put(CurrentUser,currentBalance);
            statements.get(CurrentUser).add(new Date() + " Debit : " + amount );
            System.out.println("Withdraw Success! Remaining Balance: $" + currentBalance);
        }else{
            System.out.println("Amount Invalid! Please Retry");
        }
    }

    //Function to Check Bank Balance
    public static void getBalance(){
        System.out.println("Your Balance $" + users.get(CurrentUser));
    }

    public static void viewStatement(){
        ArrayList<String> userStatement = statements.get(CurrentUser);
        if(userStatement == null || userStatement.isEmpty()){
            System.out.println("No transactions available for " + CurrentUser);
            return;
        }
        for (String s : userStatement) {
            System.out.println(s);
        }
    }

    public static void newUser(Scanner sc,String name){
        System.out.println("User Not Found! Do you want to create a new user (Y/N)");
        String choice = sc.next();
        if(choice.equalsIgnoreCase("Y") ){
            users.put(name,0.0);
            statements.put(name, new ArrayList<>());
            CurrentUser = name;
            System.out.println("New user created successfully!");
            allOptions(sc,name);
        }else{
            System.out.println("Exiting...");
            sc.close();
        }
    }

    public static void switchUser(Scanner sc){
        System.out.print("Please Enter User Name ");
        String name = sc.next();
        if(users.containsKey(name)){
            CurrentUser = name;
            System.out.println("Switched to user: " + name);
        }else{
            newUser(sc,name);
        }
    }

    public static void allOptions(Scanner sc,String name){
        System.out.print("Logged In Successfully");
        CurrentUser = name;
        System.out.println("Welcome to State Bank of India " + "\n" + "Hi " + CurrentUser + "!");

        while(true){
            System.out.println("Please choose one of the following Options");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Your Balance");
            System.out.println("4. View Your Statement");
            System.out.println("5. Switch User");
            System.out.println("6. Cancel");
            System.out.print("Option : ");

            try{
                int Option = sc.nextInt();

                if(Option == features.DEPOSIT.getValue()){
                    Deposit(sc);
                }else if(Option == features.WITHDRAW.getValue()){
                    Withdraw(sc);
                }else if(Option == features.BALANCE.getValue()){
                    getBalance();
                }else if(Option == features.VIEWSATEMENT.getValue()) {
                    viewStatement();
                }else if(Option == features.SWITCHUSER.getValue()){
                    switchUser(sc);
                }else{
                    System.out.print("You cancelled your last transaction");
                    sc.close();
                    break;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
            }

        }
    }
}
