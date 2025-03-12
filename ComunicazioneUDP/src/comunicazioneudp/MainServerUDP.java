/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneudp;
/**
 *
 * @author raffa
 */
public class MainServerUDP {

public static void main(String[] args) {
        ServerUDP s = new ServerUDP(1026);
        s.receive();
    }

}