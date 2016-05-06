import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
 
public class StandaloneServer implements Serializable {
    private static final long serialVersionUID = -1942995922934818734L;
 
    private ConnectImpl server;
    private Registry registry;
 
    public void init() throws RemoteException {
        server = new ConnectImpl();
        registry = LocateRegistry.createRegistry(1099);
    }
 
    public void connect() throws RemoteException, MalformedURLException {
        init();
        registry.rebind("server", server);
    }
 
    public void disconnect() throws AccessException, RemoteException,
            NotBoundException {
        UnicastRemoteObject.unexportObject(registry, true);
    }
 
    public static void main(String[] args) {
        StandaloneServer server = new StandaloneServer();
 
        try {
            server.connect();
        } catch (RemoteException e) {       
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
 
}