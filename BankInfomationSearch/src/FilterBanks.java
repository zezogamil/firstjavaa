import java.io.*;
import java.util.Scanner;

public class FilterBanks {

    public static void main(String[] args) {
        String readDatabase = "BankDatabase.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the Three Digit of the bank : ");
        String input = scanner.nextLine().trim();
        int threeDigitNum = Integer.parseInt(input);

        try (BufferedReader reader = new BufferedReader(new FileReader(readDatabase))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");

                if (parts.length > 0 && Integer.parseInt(parts[0].trim()) == threeDigitNum) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }

        System.out.println("Successfully processed bank branches.");
    }
}
