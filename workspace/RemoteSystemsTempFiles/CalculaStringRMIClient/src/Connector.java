import java.net.MalformedURLException;
import javax.swing.JOptionPane;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
 
public class Connector {
    private RMIClient client;
    private Connect connect;
     
    void connect() {
        try {
            client = new RMIClient("localhost");
            connect = (Connect) client.getRemoteObject();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
		
    public Connect getConnect() {
    	return connect;
    }
    
    public static void main(String[] args) {
        
        TelaCliete tela = new TelaCliete();
        tela.setVisible(true);
    }
}