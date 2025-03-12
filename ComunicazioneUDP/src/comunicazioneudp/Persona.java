/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicazioneudp;

/**
 *
 * @author raffa
 */
public class Persona {
    private String CF;
    private String nome;
    private String cognome;
    
    public Persona(String CF, String nome, String cognome){
        this.CF = CF;
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public String getCF(){
        return CF;
    }
    public void setCF(String CF){
        this.CF = CF;
    }
    
    public String nome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String cognome(){
        return nome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    
    public String toString(){
        return "- " + CF + ", " + nome + ", " + cognome;
    }
}

