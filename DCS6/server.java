import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
public class server {

    public static void main(String[] args) {
        try {
            // Create and export a registry on port 5001
            Registry registry = LocateRegistry.createRegistry(5001);
            System.out.println("RMI Registry started on port 5001");

            // Instantiate the object that implements the remote interface
            UserDatabaseImpl userDatabase = new UserDatabaseImpl();

            // Bind the remote object to the registry
            Naming.rebind("//localhost:5001/UserDB", userDatabase);
            System.out.println("Server is ready and bound to RMI registry.");
        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
