import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserDatabaseInterface extends Remote {
    void addUser(User user) throws RemoteException;
    void deleteUser(int userId) throws RemoteException;
    User getUser(int userId) throws RemoteException;
    List<User> listUsers() throws RemoteException;
    void modifyUser(User user) throws RemoteException;
}
