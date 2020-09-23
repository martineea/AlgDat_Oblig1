package Oblig2;

public class Main {
    public static void main (String[] args) {

        // Tester dette i oppg 1, etter oppgave 2 er ferdig:
        String[] s = {"Ole", null, "Per", "Kari", null};
        // Utskrift: 3 false

        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom());
        // Utskrift: 0 true


    }
}
