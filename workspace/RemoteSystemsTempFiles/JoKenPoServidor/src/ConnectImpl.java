
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConnectImpl extends UnicastRemoteObject implements Connect {

    private static final long serialVersionUID = -7854287696962149563L;
    private List<String> lista = new ArrayList<String>();
    private int resultado; // jogada do servidor
    private int placarJogador = 0;
    private int placarServidor = 0;

    protected ConnectImpl() throws RemoteException {
        super();
    }

    public void adiciona(String str) throws RemoteException {
        //lista.add(str);
        int jogadaPlay = 4;

        GeraJogadaServidor();
        
        
        imprimindoJogadaServidor();

        jogadaPlay = gerandoJogadaP1(str, jogadaPlay);

        logicaJogo(jogadaPlay);
        
        imprimindoPlacarGeral();
        
        verificaVencedor();
            
    }

    private void verificaVencedor() {
        if(placarJogador+placarServidor == 3){
            if(placarJogador > placarServidor){
                System.out.println("O jogador venceu!");
                //placarJogador = 0;
                //placarServidor = 0;
            }
            else{
                System.out.println("O servidor venceu!");
                //placarJogador = 0;
                //placarServidor = 0;
            }
        }
        /*if(placarJogador == 3)
        {
            placarJogador = 0;
            placarServidor = 0;
        }
            
        if(placarServidor == 3)
        {
            System.out.println("O servidor venceu!");
            placarJogador = 0;
            placarServidor = 0;
        }*/
    }

    private void imprimindoPlacarGeral() {
        System.out.println("Placar:");
        System.out.println("Jogador : "+ placarJogador);
        System.out.println("Servidor: "+ placarServidor);
    }

    private void imprimindoJogadaServidor() {
        System.out.print("Jogada do Servidor: ");
        switch (resultado) {
            case 0:
                System.out.println("Pedra");
                break;
            case 1:
                System.out.println("Papel");
                break;
            case 2:
                System.out.println("Tesoura");
                break;
            case -1:
                System.out.println("não jogou");
                break;
            default:
                System.out.println(resultado);
                break;
        }
    }

    private int gerandoJogadaP1(String str, int jogadaPlay) {
        switch (str) {
            case "Pedra": // Pedra = 0
                System.out.println("Jogada do P1: " + str);
                jogadaPlay = 0;
                break;
            case "Papel": // Papel = 1
                System.out.println("Jogada do P1: " + str);
                jogadaPlay = 1;
                break;
            case "Tesoura": // Tesoura = 2
                System.out.println("Jogada do P1: " + str);
                jogadaPlay = 2;
                break;
            default:
                System.out.println("Jogada do P1: " + str);
        }
        return jogadaPlay;
    }

    private void logicaJogo(int jogadaPlay) {
        switch (resultado) {
            case 0: // pedra
                if (jogadaPlay == 2) { // pedra > tesoura -> servidor ganha
                    placarServidor++;
                } else if (jogadaPlay == 1) { // papel > pedra -> jogador ganha
                    placarJogador++;
                }
                break;
            case 1: // papel
                if (jogadaPlay == 0) { // papel > pedra -> servidor ganha
                    placarServidor++;
                } else if (jogadaPlay == 2) { // tesoura > papel -> jogador ganha
                    placarJogador++;
                }
                break;
            case 2: // tesoura
                if (jogadaPlay == 1) { // tesoura > papel -> servidor ganha
                    placarServidor++;
                } else if (jogadaPlay == 0) { // pedra > tesoura -> jogador ganha
                    placarJogador++;
                }
                break;
        }
    }

    private void GeraJogadaServidor() {
        Random aleatorio = new Random();
        resultado = aleatorio.nextInt(3); //Pedra = 0, Papel = 1, Tesoura = 2;
    }
    
    public void comecaJogo() throws RemoteException{
        placarJogador = 0;
        placarServidor = 0;
    }

    public List<String> getLista() throws RemoteException {
        return lista;
    }

    public int getPlacarPlayer() throws RemoteException {
        return placarJogador;
    }

    public int getPlacarServer() throws RemoteException {
        return placarServidor;
    }
    
    public String getJogadaServer() throws RemoteException{
        switch (resultado) {
            case 0: // pedra
                return "Pedra";
            case 1: // papel
                return "Papel";
            case 2: // tesoura
                return "Tesoura";
        }
        return "";
}
}
