/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author raffa
 */
public class ClientUDP {
    
    String nome;
    int portaServer;
    InetAddress serverAddress;
    DatagramSocket dSocket;
    
    public ClientUDP(String nome, int portaServer){
        this.nome = nome;
        this.portaServer = portaServer;
        try{
            dSocket = new DatagramSocket();
            serverAddress = InetAddress.getLocalHost(); //recupero il dns locale
        }catch(UnknownHostException e){
            System.err.println("Errore Ip");
        }catch(SocketException e){
            System.err.println("Errore socket");
        }
    }
    
    public void sendReceive() throws IOException{
        try {
            Persona p = new Persona("xxx", "giovanni", "pascoli");
            String message;
            message = p.toString();
            DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, portaServer);
            dSocket.send(outPacket);
            
            //RICEVERE
            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            dSocket.receive(inPacket);
            
            String response = new String(inPacket.getData(), 0, inPacket.getLength());
            System.out.println("Il server ha risposto: " + response);
                
        } catch (UnknownHostException e) {
            System.err.println("Errore DNS!");
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
        } catch (IOException e) {
            System.err.println("Errore di I/O!");
        }
    }
}
