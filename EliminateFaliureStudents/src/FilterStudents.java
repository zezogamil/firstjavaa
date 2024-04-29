import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterStudents {

    public static void main(String[] args) {
        String inputFile = "studentsEN.txt";
        String outputFile = "studentsWith5.txt";
        int passingGrade = 5;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\t");
                System.out.println(parts[1]);
                if (parts.length >= 3) {
                    String name = parts[0].trim();
                    String surname = parts[1].trim();
//                    int passingGrade = parts[2].trim();
                    if (Integer.parseInt(parts[2]) == passingGrade) {
                        writer.write(name + " " + surname + " " + passingGrade +"\n");
                    }
                }
            }
            writer.close();


        } catch (IOException e) {
            System.err.println("Error reading or writing files: " + e.getMessage());
        }


        System.out.println("Successfully processed student grades.");
    }
}
