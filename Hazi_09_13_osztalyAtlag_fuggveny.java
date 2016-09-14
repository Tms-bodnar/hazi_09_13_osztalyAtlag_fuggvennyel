/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazi_09_13_osztalyatlag_fuggveny;

import java.util.Scanner;

/**
 *
 * @author bodnart
 */
public class Hazi_09_13_osztalyAtlag_fuggveny {

    /**
     * @param args the command line arguments
     */

    static int maxPont;
    static int osztalyLetszam;
    static double atlag;
    
    public static int maxPontszam() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mennyi az elérhető maximum pontszám? ");
        int maxPont = sc.nextInt();
        return maxPont;
    }


    public static int osztalyLetszam() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mekkora az osztály létszáma? ");
        int osztalyLetszam = sc.nextInt();
        
        return osztalyLetszam;
       }
        
    public static int eredmeny(){
        Scanner sc = new Scanner(System.in);
        System.out.print(". tanuló pontszáma: ");
        int eredmeny = sc.nextInt();
        return eredmeny;
    }

    public static int osztalyzat(int maxPont, int eredmeny ) {
        double szazalek =  ((double)eredmeny / maxPont) * 100;
        int osztalyzat = 5;
        if (szazalek < 20) {
            osztalyzat = 1;
        } else if (szazalek < 40) {
            osztalyzat = 2;
        } else if (szazalek < 60) {
            osztalyzat = 3;
        } else if (szazalek < 80) {
            osztalyzat = 4;
        }
        
        return osztalyzat;
    }
           
    public static double osztalyAtlag(int[] osztalyzatok, int osztalyLetszam) {
        int osztalyzatokOsszege = 0;    
        for( int i = 0; i < osztalyzatok.length; i++){
             osztalyzatokOsszege += osztalyzatok[i];   
            }
       atlag = ((double) osztalyzatokOsszege / osztalyLetszam);
        return atlag;
    }
    
    public static void atlagFeletti(int[] osztalyzatok){
        for( int i = 0; i < osztalyzatok.length; i++){
            if (osztalyzatok[i] > atlag){
                System.out.println("A(z) " + (i+1) + ". tanuló átlag feletti osztályzata: " + osztalyzatok[i]);
            }
        }
    }

    public static void main(String[] args) {
            maxPont = maxPontszam();
            osztalyLetszam = osztalyLetszam();
            int[] osztalyzatok = new int[osztalyLetszam];
        for (int i = 0; i < osztalyLetszam; i++) {
            System.out.print(i + 1);
            int osztalyzat = osztalyzat(maxPont, eredmeny());
            osztalyzatok[i] = osztalyzat;
            System.out.println("A " + (i + 1) + ". tanuló osztályzata: " + osztalyzat);
       }
            System.out.println("Az osztály átlaga: " + osztalyAtlag( osztalyzatok , osztalyLetszam));
            atlagFeletti(osztalyzatok);
    }
}
