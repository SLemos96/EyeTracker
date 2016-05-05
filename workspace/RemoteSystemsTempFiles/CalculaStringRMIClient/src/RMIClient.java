import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
 
import javax.swing.JOptionPane;
 
public class RMIClient implements Serializable{
    private static final long serialVersionUID = 3063470053215537339L;
 
    private static final String RMI_PORT_SERVER = ":1099/server";
 
    private Remote remoteObject;
 
    public RMIClient(String ip) throws MalformedURLException, RemoteException,
            NotBoundException {
        try {
            remoteObject = Naming.lookup("rmi://" + ip + RMI_PORT_SERVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public Remote getRemoteObject() {
        return remoteObject;
    }
}