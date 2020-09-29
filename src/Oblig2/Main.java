package Oblig2;

import java.util.ArrayList;
import java.util.List;

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

        //oppgave 3a
        DobbeltLenketListe list= null;
        list.leggInn(2);
        list.leggInn(3);
        list.leggInn(4);
        list.leggInn(6);
        //System.out.println(list.finnNode(2));
        System.out.println(list.hent(2));

        //oppgave 3b:
        //Sjekk så at følgende programbit gir rett utskrift:
        Character [] c= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        DobbeltLenketListe<Character> liste1 = new DobbeltLenketListe<>(c);

        System.out.println(liste1.subliste(3,8));// [D, E, F, G, H]
        System.out.println(liste1.subliste(5,5));
        System.out.println(liste1.subliste(8, liste1.antall()));//[I, J]
        System.out.println(liste1.subliste(8,liste1.antall()));

        //System.out.println(liste.subliste(0,11)); // skal kaste unntak

        //oppgave 4:
       System.out.println(list.indeksTil(3));

        //oppgave 5:

        /*Sjekkliste for ​leggInn(int indeks, T verdi)​:
            ● Stoppes null-verdier? Kastes i så fall en ​NullPointerException​?
            ● Sjekkes indeksen?
            ● Blir det korrekt hvis listen fra før er tom?
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges først?
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges bakerst?
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges mellom to
                    verdier?
            ● Blir ​antall​ økt?
            ● Blir ​endringer​ økt?

         */

        DobbeltLenketListe siste= null;

        siste.leggInn(4, 30 );
        System.out.println(siste.hent(4));


    }




}
