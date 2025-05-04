import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {
        try {
            // Lookup the remote UserDatabaseInterface object from the RMI registry
            UserDatabaseInterface userDB = (UserDatabaseInterface) Naming.lookup("//localhost:5001/UserDB");
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. Add User\n2. Delete User\n3. Get User\n4. List Users\n5. Modify User\n6. Exit");
                System.out.print("Choose option: ");
                int option = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (option) {
                    case 1:
                        // Collect information for the new user
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();  // consume newline
                        System.out.print("First name: ");
                        String firstName = sc.nextLine();
                        System.out.print("Last name: ");
                        String lastName = sc.nextLine();
                        System.out.print("Birthdate (YYYY-MM-DD): ");
                        String birthDate = sc.nextLine();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();  // consume newline
                        System.out.print("Gender (MALE/FEMALE/OTHER): ");
                        User.Gender gender = User.Gender.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Division: ");
                        String division = sc.nextLine();
                        System.out.print("Position: ");
                        String position = sc.nextLine();

                        // Create a new user object with the provided data
                        User newUser = new User(id, firstName, lastName, birthDate, salary, gender, division, position);
                        // Add the new user to the database
                        userDB.addUser(newUser);
                        System.out.println("User added.");
                        break;

                    case 2:
                        // Delete user by ID
                        System.out.print("Enter user ID to delete: ");
                        int idDel = sc.nextInt();
                        sc.nextLine();
                        userDB.deleteUser(idDel);
                        System.out.println("User deleted.");
                        break;

                    case 3:
                        // Get user by ID
                        System.out.print("Enter user ID to get: ");
                        int idGet = sc.nextInt();
                        sc.nextLine();
                        User user = userDB.getUser(idGet);
                        System.out.println("User: " + user);
                        break;

                    case 4:
                        // List all users
                        List<User> users = userDB.listUsers();
                        for (User u : users) {
                            System.out.println(u);
                        }
                        break;

                    case 5:
                        // Modify user details
                        System.out.print("Enter user ID to modify: ");
                        int idMod = sc.nextInt();
                        sc.nextLine();
                        User modUser = userDB.getUser(idMod);
                        System.out.println("Modifying user: " + modUser);

                        System.out.print("New first name (or press Enter to skip): ");
                        String fn = sc.nextLine();
                        if (!fn.isEmpty()) modUser.setFirstName(fn);

                        System.out.print("New salary (or press Enter to skip): ");
                        String sal = sc.nextLine();
                        if (!sal.isEmpty()) modUser.setSalary(Double.parseDouble(sal));

                        userDB.modifyUser(modUser);
                        System.out.println("User modified.");
                        break;

                    case 6:
                        // Exit the program
                        System.out.println("Exiting.");
                        return;

                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
