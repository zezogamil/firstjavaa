import java.io.IOException;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        double firstNum;
        double secondNum;

        double Sum;
        double Difference;
        double product;

        System.out.println("Enter first Number please : ");
        double num1 = scanner.nextDouble();
        System.out.println("Enter Second Number Please : ");
        double num2 = scanner.nextDouble();

        Sum = num1 + num2;
        Difference = num1 - num2;
        product = num1 * num2;

        System.out.println("Sum = " + Sum);
        System.out.println("Difference = " + Difference );
        System.out.println("Multiplication = " + product);
    }
}