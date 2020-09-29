package Oblig2;

public class Main {
    public static void main (String[] args) {

        // Oppgave 0: Sjekker at oppsettet funker
        Liste<String> liste = new DobbeltLenketListe<>();

        // Oppgave 1: Sjekker om antall og tom gir rett utskrift
        System.out.println(liste.antall() + " " + liste.tom());
        // Utskrift: 0 true

        // Tester dette i oppg 1, etter oppgave 2 er ferdig:
        String[] s = {"Ole", null, "Per", "Kari", null};
        // Utskrift: 3 false

        // Oppgave 2a: sjekk at følgende programbit gir rett utksirft:
        String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + " " + l2.toString() +
                " " + l3.toString() + " " + l1.omvendtString() +
                " " + l2.omvendtString() + " " + l3.omvendtString());
        // Utkskrift: [] [A] [A, B] [] [A] [B, A]

        // Oppgave 2b: sjekk at følgende programbit gir rett utksrift:
        DobbeltLenketListe<Integer> liste1 = new DobbeltLenketListe<>();
        System.out.println(liste.toString() + " " + liste1.omvendtString());

        for (int i=1; i <= 3; i++) {
            liste1.leggInn(i);
            System.out.println(liste1.toString() + " " + liste1.omvendtString());
        }

        // Utskrift:
        // []
        // [1] [1]
        // [1, 2] [2,1]
        // [1,2,3] [3,2,1]


    }
}
