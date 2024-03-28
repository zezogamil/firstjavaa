import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(repFirstChar("test"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Word: ");
        String s = scanner.nextLine();
        String result = repFirstChar(s);
        System.out.println("The first letter is " + result);
    }
    public static String repFirstChar(String s)
    {
        char FirstChar = s.charAt(0);
        if (Character.isUpperCase(FirstChar))
        {
            return "Upper";
        } else if (Character.isLowerCase(FirstChar))
        {
            return "Lower";
        } else if (Character.isDigit(FirstChar))
        {
         return "Digit";
        }else
        {
            return "Other";
        }

    }

}