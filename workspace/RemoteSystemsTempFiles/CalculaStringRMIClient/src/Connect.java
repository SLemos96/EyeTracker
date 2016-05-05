import java.rmi.Remote;
import java.rmi.RemoteException;
 import java.util.List;
 
public interface Connect extends Remote{
    void adiciona(String str) throws RemoteException;
    void comecaJogo() throws RemoteException;
    List<String> getLista() throws RemoteException;
    int getPlacarPlayer() throws RemoteException;
    int getPlacarServer() throws RemoteException;
    String getJogadaServer() throws RemoteException;
    
}