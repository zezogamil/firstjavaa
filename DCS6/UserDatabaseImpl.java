import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
public class UserDatabaseImpl extends UnicastRemoteObject implements UserDatabaseInterface {
    private List<User> users = new ArrayList<>();

    public UserDatabaseImpl() throws RemoteException {}

    @Override
    public void addUser(User user) throws RemoteException {
        users.add(user);
    }

    @Override
    public void deleteUser(int userId) throws RemoteException {
        users.removeIf(user -> user.getId() == userId);
    }

    @Override
    public User getUser(int userId) throws RemoteException {
        return users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
    }

    @Override
    public List<User> listUsers() throws RemoteException {
        return users;
    }

    @Override
    public void modifyUser(User user) throws RemoteException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
        }
    }
}

