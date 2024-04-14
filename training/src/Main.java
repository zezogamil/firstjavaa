import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d,};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] OperCode = {'d', 'a', 's', 'm'};
        double[] result = new double[OperCode.length];

        if(args.length == 0)
        {
            for (int i = 0; i < OperCode.length; i ++)
            {
                result[i] = execute(OperCode[i], leftVals[i], rightVals[i]);
            }
            for (double CurrentResult : result)
                System.out.println(CurrentResult);
        } else if (args.length == 1 && args[0].equals("Interactive"))
            excuteInteractively();
        else if (args.length == 3) {
            HanndleCommandLine(args);
        } else
            System.out.println("Please enter the Operation Code and 2 numeric values ");
    }
    static void excuteInteractively()
    {
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        PerfomeOperation(parts);

    }

    private static void PerfomeOperation(String[] parts)
    {
        char OperCode = OperCodeFromString(parts[0]);

        if(OperCode == 'w')
        {
            handleWhen(parts);
        } else {
            double leftVals = ValueAsWord(parts[1]);
            double rightVals = ValueAsWord(parts[2]);
            double result = execute(OperCode, leftVals, rightVals);
            DisplayTheResult(OperCode, leftVals, rightVals, result);
        }
    }

    private static void handleWhen(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[1]);
        long daysToAdd = (long) ValueAsWord(parts[2]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);
        System.out.println(output);
    }

    private static void DisplayTheResult(char operCode, double leftVals, double rightVals, double result) {
        char Symbol = SymbolOFOperCode(operCode);
//        StringBuilder builder = new StringBuilder(20);
//        builder.append(leftVals);
//        builder.append(" ");
//        builder.append(Symbol);
//        builder.append(" ");
//        builder.append(rightVals);
//        builder.append(" = ");
//        builder.append(result);
//        String output = builder.toString();

        String output = String.format("%.3f %c %.3f = %.3f", leftVals, Symbol, rightVals, result);
        System.out.println(output);

    }

    private static char SymbolOFOperCode(char operCode)
    {
        char[] OperCodes = {'a', 's', 'm', 'd'};
        char[] Symbols = {'+', '-', '*', '/'};
        char Symbol = ' ';
        for(int Index = 0; Index < OperCodes.length; Index++){
            if(operCode == OperCodes[Index])
            {
                Symbol = Symbols[Index];
                break;
            }
        }
        return Symbol;
    }

    private static void HanndleCommandLine(String[] args)
    {
        char OperCode = args[0].charAt(0);
        double leftVals = Double.parseDouble(args[1]);
        double rightVals = Double.parseDouble(args[2]);
        double result = execute(OperCode, leftVals, rightVals);
        System.out.println(result);
    }

    static double execute(char OperCode, double leftVals, double rightVals){
        double result;
        switch (OperCode){
            case 'a':
                result = leftVals + rightVals;
                break;
            case 's':
                result = leftVals - rightVals;
                break;
            case 'm' :
                result = leftVals * rightVals;
                break;
            case 'd':
                result = rightVals !=0 ? leftVals / rightVals : 0.0d;
                break;
            default:
                System.out.println("Invaild OperCode: " + OperCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char OperCodeFromString(String OperationName)
    {
        return OperationName.charAt(0);
    }

   static double ValueAsWord(String word)
    {
        String[] numberWords = {
                "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
        };
        double value = -1d;
        for(int index = 0; index < numberWords.length; index ++){
            if(word.equals(numberWords[index]))
            {
                value = index;
                break;
            }
        }
        if (value == -1d)
             value = Double.parseDouble(word);

        return value;
    }
}