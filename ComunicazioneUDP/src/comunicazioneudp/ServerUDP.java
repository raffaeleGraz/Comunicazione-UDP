/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneudp;

import java.io.IOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.SocketException;

/**
 *
 * @author raffa
 */
public class ServerUDP {
    
    int porta;
    DatagramSocket dSocket;
    
    public ServerUDP (int porta){
        this.porta = porta;
        try {
            dSocket = new DatagramSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException ex) {
            System.err.println("Errore nell'avvio del server");
        }
    }
    
    public void receive(){
        try{
            byte[] bufferIn = new byte [256]; //creo un array di byte per ricere il messaggio
            
            DatagramPacket inPacket = new DatagramPacket(bufferIn, bufferIn.length); //Creo un datagramPacket per ricere il messaggio, della lunghezza dell'array di byte 
            
            dSocket.receive(inPacket); //bloccante
            
            //recupera l'indirizzo ip e la porta del client
            InetAddress clientAddress = inPacket.getAddress();
            int clientPort = inPacket.getPort();
            
            //Stampa payload
            String messageIn = new String(inPacket.getData(), 0, inPacket.getLength()); //Recupera il messaggio in byte e trasformalo in stringa, 0 = dall'inizio
            System.out.println("Client: " + clientAddress + ":" + clientPort + " = " + messageIn);
            
            
        }catch(BindException e){
            System.err.println("Porta già in uso");
        }catch(SocketException e){
            System.err.println("Errore socket");
        }catch(IOException e){
            System.err.println("Errore I/O");
        }
    }
    
   
}

