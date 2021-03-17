package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankAcc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankMain> vault = new HashMap<>();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String output;
            switch (tokens[0]){
                case "Deposit":
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);
                vault.get(id).deposit(amount);
                output = "Deposited " + amount + " to ID" + id;
                    break;
                case "SetInterest":
                    double newInterest = Double.parseDouble(tokens[2]);
                    BankMain.setInterestRate(newInterest);
                    output = null;
                    break;
                case "GetInterest":
                    id = Integer.parseInt(tokens[1]);
                    int years = Integer.parseInt(tokens[2]);
                    double interest = vault.get(id).getInterest(years);
                        output = String.format("%.2f",interest);
                    break;
                default:
                    BankMain bankMain = new BankMain();
                    vault.put(bankMain.getId(), bankMain);
                    output = "Account ID" + bankMain.getId() + " created";
                    break;
            }
                if (output != null) {
                    System.out.println(output);
                }
            input = scanner.nextLine();
        }
    }
}
