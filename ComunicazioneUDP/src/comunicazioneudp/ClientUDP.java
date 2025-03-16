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
import java.util.Scanner;

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
    
    public void send(String message) throws IOException{
        try {
            DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), serverAddress, portaServer);
            dSocket.send(outPacket);

        } catch (UnknownHostException e) {
            System.err.println("Errore DNS!");
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
        } catch (IOException e) {
            System.err.println("Errore di I/O!");
        }
    }

    public void receive(){
        try {

            byte[] buffer = new byte[256];
            DatagramPacket inPacket = new DatagramPacket(buffer, buffer.length);
            dSocket.receive(inPacket);

            String response = new String(inPacket.getData(), 0, inPacket.getLength());
            System.out.println("Il server ha risposto: \033[92m" + response + "\033[0m");

        } catch (UnknownHostException e) {
            System.err.println("Errore DNS!");
        } catch (SocketException e) {
            System.err.println("Errore nel socket!");
        } catch (IOException e) {
            System.err.println("Errore di I/O!");
        }
    }

    public void menu() throws IOException {
        while(true) {
            Scanner scanner = new Scanner(System.in);

            //MENU
            System.out.println("┌───────────────────────┐");
            System.out.print("│");
            System.out.print("\033[92m    Invio messaggio    \033[0m");
            System.out.println("│");
            System.out.println("├───────────────────────┤");
            System.out.println("│ 1. Messaggio di testo │");
            System.out.println("│ 0. Termina            │");
            System.out.println("└───────────────────────┘");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();  //pulire il buffer

            switch (scelta) {
                case 0:
                    dSocket.close();
                    System.out.println("\033[31mConnessione terminata\033[0m");
                    return;  // Termina il ciclo e quindi la funzione.
                case 1:
                    System.out.print("Inserisci il messaggio: ");
                    String message = scanner.nextLine();
                    send(message);
                    System.out.println("\033[92mMessaggio inviato\033[0m\n");
                    break;
                case 2:
                    // toString per gli oggetti
                    break;
                default:
                    System.out.println("\033[31mScelta non valida\033[0m");
                    break;
            }
        }
    }

    public void close(){
        dSocket.close();
    }

}
