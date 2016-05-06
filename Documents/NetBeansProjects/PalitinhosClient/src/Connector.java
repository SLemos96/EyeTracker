import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
 
public class Connector {
    private RMIClient client;
    private Connect connect;
    private int i; // apagar depois
     
    private void connect() {
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
        Connector connector = new Connector();
         
        connector.connect();
         
        Connect obj = connector.getConnect();
         
        try {
            
            obj.jogar(0);
            obj.login("Samuel");
            obj.jogar(4);
            obj.login("Reinaldo");
 
            for (String s : obj.getLista()) {
                System.out.println(s);
                }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}