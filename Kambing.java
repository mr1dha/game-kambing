/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.*;
/**
 *
 * @author ASUS PC
 */
public class Kambing {
    private int posX;
    private int posY;
    private int energy;
    private AudioClip clip;
    private URL urlClip;
    
    public Kambing(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
        energy = 100;
        urlClip = Kambing.class.getResource("mbee_fad.wav");
        clip = Applet.newAudioClip(urlClip);
    }
    
    public void playSound(){
        clip.play();
    }
    public void stopSound(){
        clip.stop();
    }
    public int getX(){
        return posX;
    }
    public int getY(){
        return posY;
    }
    public int up(int n){
        posY -= 25*n;
        return posY;
    }
    public int down(int n){
        posY += 25*n;
        return posY;
    }
    public int right(int n){
        posX += 50*n;
        return posX;
    }
    public int left(int n){
        posX -= 50*n;
        return posX;
    }
    public void addEnergy(){
        energy += 5;
    }
    public int getEnergy(){
        return energy;
    }
    public void minEnergy(){
        energy -= 5;
    }
    public String coordinate(){
        return "("+posX+", "+posY+")";
    }
    public void sudut(double sudut, double n){
        double cosX = posX + (Math.cos(Math.toRadians(-sudut))) * n;
        double sinY = posY + (Math.sin(Math.toRadians(-sudut))) * n;
        
        if((cosX>0 && cosX<915)&& (sinY > 0 && sinY < 330)){
            posX = (int) cosX;
            posY = (int) sinY;
            energy -= 5; 
        }
    }
    
}
