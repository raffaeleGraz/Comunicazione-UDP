/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneudp;

import java.io.IOException;

/**
 *
 * @author raffa
 */
public class MainClientUDP {
    public static void main(String[] args) throws IOException {
       ClientUDP c = new ClientUDP("client1", 1026);
       c.send();
    }
}
