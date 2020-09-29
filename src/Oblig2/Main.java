package Oblig2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        // Tester dette i oppg 1, etter oppgave 2 er ferdig:
        String[] s = {"Ole", null, "Per", "Kari", null};
        // Utskrift: 3 false

        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom());
        // Utskrift: 0 true

        //oppgave 3
        DobbeltLenketListe list= null;
        list.leggInn(2);
        list.leggInn(3);
        list.leggInn(4);
        list.leggInn(6);


        //System.out.println(list.finnNode(2));
    }
}
