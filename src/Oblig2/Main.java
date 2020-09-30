package Oblig2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        // Oppgave 0: Sjekker at oppsettet funker
        Liste<String> liste = new DobbeltLenketListe<>();

        // Oppgave 1: Sjekker om antall og tom gir rett utskrift
        System.out.println("Tester oppgave 1:");
        System.out.println(liste.antall() + " " + liste.tom());
        // Utskrift: 0 true

        // Tester dette i oppg 1, etter oppgave 2 er ferdig:
        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste4 = new DobbeltLenketListe<>(s);
        System.out.println(liste4.antall() + " " + liste4.tom());
        // Utskrift: 3 false

        // Oppgave 2a: sjekk at følgende programbit gir rett utksirft:
        /*
            Sjekkliste for metoden ​leggInn(T verdi)​:
            ●  Stoppes null-verdier? Kastes i så fall en ​NullPointerException​?
            ● Blir det korrekt hvis listen fra før er tom?
            ● Blir det korrekt hvis listen fra før ikke er tom?
            ● Blir antallet økt?
            ● Blir endringer økt?
            ● Er det rett returverdi?
         */
        System.out.println("");
        System.out.println("Tester oppgave 2a:");

        String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", null, "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + " " + l2.toString() +
                " " + l3.toString() + " " + l1.omvendtString() +
                " " + l2.omvendtString() + " " + l3.omvendtString());
        // Utkskrift: [] [A] [A, B] [] [A] [B, A]


        // Oppgave 2b: sjekk at følgende programbit gir rett utksrift:
        System.out.println("");
        System.out.println("Tester oppgave 2b:");

        DobbeltLenketListe<Integer> liste1 = new DobbeltLenketListe<>();
        System.out.println(liste.toString() + " " + liste1.omvendtString());

        for (int i=1; i <= 3; i++) {
            liste1.leggInn(i);
            System.out.println(liste1.toString() + " " + liste1.omvendtString());
        }

        // Utskrift:
        // [] []
        // [1] [1]
        // [1, 2] [2,1]
        // [1,2,3] [3,2,1]

        /*
        //oppgave 3a
        System.out.println("");
        System.out.println("Tester oppgave 3a:");
        DobbeltLenketListe list= null;
        list.leggInn(2);
        list.leggInn(3);
        list.leggInn(4);
        list.leggInn(6);

        System.out.println(list.hent(2));

        //oppgave 3b:
        System.out.println("");
        System.out.println("Tester oppgave 3b:");
        //Sjekk så at følgende programbit gir rett utskrift:
        Character [] c= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        DobbeltLenketListe<Character> liste2 = new DobbeltLenketListe<>(c);

        System.out.println(liste2.subliste(3,8));// [D, E, F, G, H]
        System.out.println(liste2.subliste(5,5));
        System.out.println(liste2.subliste(8, liste2.antall()));//[I, J]
        System.out.println(liste2.subliste(8,liste2.antall()));

        //System.out.println(liste.subliste(0,11)); // skal kaste unntak

        //oppgave 4:
        System.out.println("");
        System.out.println("Tester oppgave 4:");
        System.out.println(list.indeksTil(3));

        //oppgave 5:
        System.out.println("");
        System.out.println("Tester oppgave 5:");
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
        /*
        DobbeltLenketListe siste= null;

        siste.leggInn(4, 30 );
        System.out.println(siste.hent(4));
        */

        //Oppgave 6
        System.out.println("");
        System.out.println("Tester oppgave 6:");
        /*
         Sjekkliste for fjern-Metodene nedenfor:
        ● Blir det korrekt hvis listen fra før er tom?
        ● Blir pekerne (forrige og neste) korrekte i alle noder hvis første verdi (indeks 0)
            fjernes?
        ● Blir pekerne (forrige og neste) korrekte i alle noder hvis siste verdi fjernes?
        ● Blir pekerne (forrige og neste) korrekte i alle noder hvis det fjernes en verdi
            mellom to verdier?
        ● Blir pekerne (forrige og neste) korrekte hvis listen etter fjerningen får kun én
            verdi? Hva med ingen verdier?
        ● Blir ​antall​ redusert?
        ● Blir ​endringer​ økt?
        */
        /*
        Pass på tilfellene:
        1. Den første fjernes
        2. Den siste fjernes
        3. En verdi mellom to andre fjernes
        - Alle neste- og forrige-pekere må være korrekte etter fjerningen
        - Variabelen ANTALL skal også reduseres og variabelen ENDRINGER økes
        - Sjekk om tilfellet der listen blir tom etter fjerningen blir korrekt behandlet
        - Bruk metodene toString() og omvendtString() til å sjekke at pekerne er satt riktig
         */

        // Skriver først ut listen med toString og omvendtString
        Integer[] f1 = {};
        Integer[] f2 = {1};
        Integer[] f3 = {1,2,3};
        DobbeltLenketListe<Integer> m1 = new DobbeltLenketListe<>(f1);
        DobbeltLenketListe<Integer> m2 = new DobbeltLenketListe<>(f2);
        DobbeltLenketListe<Integer> m3 = new DobbeltLenketListe<>(f3);

        System.out.println(m1.toString() + " " + m2.toString() +
                " " + m3.toString() + " " + m1.omvendtString() +
                " " + m2.omvendtString() + " " + m3.omvendtString());
        // Utkskrift: [] [1] [1,2,3] [] [1] [3,2,1]

        // Kjører fjern-metoden for å se om verdier blir fjernet:
        DobbeltLenketListe.fjern();

        // Teste om listen er tom:

        // Teste om første er fjernet:

        // Teste om siste er fjernet:

        // Teste om mellomste er fjernet:

    }




}
