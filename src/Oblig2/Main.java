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


        //oppgave 3a
        DobbeltLenketListe<Integer> list= new DobbeltLenketListe<>();
        list.leggInn(2);
        list.leggInn(3);
        list.leggInn(4);
        list.leggInn(6);
        list.leggInn(3);

        System.out.println( "Her er oppgave 3a: " +list.hent(2));

        //oppgave 3b:
        System.out.println("");
        System.out.println("Tester oppgave 3b:");
        //Sjekk så at følgende programbit gir rett utskrift:
        Character [] c= {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        DobbeltLenketListe<Character> liste2 = new DobbeltLenketListe<>(c);

        ;
        System.out.println(liste2.subliste(3,8));// [D, E, F, G, H]
        System.out.println(liste2.subliste(5,5));

        //denne gir java.lang.NullPointerException uten at jeg vet hvorfor.
       // System.out.println(liste2.subliste(8,liste2.antall()));

        //System.out.println(liste2.subliste(0,11));//skal kaste avvik



        //oppgave 4:
       System.out.println("her er oppgave 4: "+list.indeksTil(3));

        //oppgave 5:
        System.out.println("");
        System.out.println("Tester oppgave 5:");
        /*Sjekkliste for ​leggInn(int indeks, T verdi)​:
            ● Stoppes null-verdier? Kastes i så fall en ​NullPointerException​? ja
            ● Sjekkes indeksen?
            ● Blir det korrekt hvis listen fra før er tom? nei, det går ikke å legge inn med tom tabell:(
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges først?
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges bakerst?
            ● Blir pekerne (forrige og neste) korrekte i alle noder hvis ny verdi legges mellom to
                    verdier?
            ● Blir ​antall​ økt?
            ● Blir ​endringer​ økt? vet ikke hvordan jeg sjekker dette

         */


        DobbeltLenketListe<Integer> siste= new DobbeltLenketListe<>();
        siste.leggInn(1);
        siste.leggInn(2);
        siste.leggInn(3);
        siste.leggInn(4);
        siste.leggInn(6);
        siste.leggInn(3);


        siste.leggInn(4, 30 );
        System.out.println("Tester oppgave 5: "+ siste.hent(4));

        //tester nullverdi fungerer
        //siste.leggInn(0, null );
        //System.out.println("Tester oppgave 5: "+ siste.hent(0));

        //sjekker om det går hvis listen er tom: Fungerer ikke
        DobbeltLenketListe<Integer> siste2= new DobbeltLenketListe<>();
        /*siste.leggInn(0, 10 );
        System.out.println("Tester oppgave 5: "+ siste2.hent(0));*/


        //sjekker at det går å legge inn noe bakerst
        siste.leggInn(7, 10 );
        System.out.println("Tester oppgave 5: "+ siste.hent(7));

        //sjekker at antall er riktig:
        System.out.println("antall for oppgave 5: "+ siste.antall());
        System.out.println(siste.toString());


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

        //tester op fjern(indeks)
        // Kjører fjern-metoden for å se om verdier blir fjernet:
        DobbeltLenketListe<Integer> listeIgjen= new DobbeltLenketListe<>();
        listeIgjen.leggInn(10);
        listeIgjen.leggInn(129);
        listeIgjen.leggInn(3);
        listeIgjen.leggInn(15);
        System.out.println("listen før fjerning:"+listeIgjen.toString());
        listeIgjen.fjern(1);

        System.out.println(listeIgjen.toString()+" fjerner indeks 2: " +listeIgjen.fjern(2));
        System.out.println(listeIgjen.toString());

        // Teste om listen er tom: Gir feilmelding IndexOutOfBoundsException
       /* DobbeltLenketListe<Integer> listeTom= new DobbeltLenketListe<>();
        listeTom.fjern(0);
        */

        // Teste om første er fjernet:
        DobbeltLenketListe<Integer> listeIgjen1= new DobbeltLenketListe<>();
        listeIgjen1.leggInn(10);
        listeIgjen1.leggInn(129);
        listeIgjen1.leggInn(3);
        listeIgjen1.leggInn(15);
        System.out.println("Liste før noe er fjernet forerst"+listeIgjen1.toString());
        System.out.println("Fjerner indeks 0 "+ listeIgjen1.fjern(0));
        System.out.println("Skriver ut listen etter fjerning forerst "+listeIgjen1.toString());


        // Teste om siste er fjernet:
        DobbeltLenketListe<Integer> listeIgjen2= new DobbeltLenketListe<>();
        listeIgjen2.leggInn(10);
        listeIgjen2.leggInn(129);
        listeIgjen2.leggInn(3);
        listeIgjen2.leggInn(15);
        System.out.println("Liste før noe er fjernet siste"+listeIgjen2.toString());
        System.out.println("Fjerner indeks 3 "+ listeIgjen2.fjern(3));
        System.out.println("Skriver ut listen etter fjerning forerst "+listeIgjen2.toString());

        // Teste om mellomste er fjernet:
        DobbeltLenketListe<Integer> listeIgjen3= new DobbeltLenketListe<>();
        listeIgjen3.leggInn(10);
        listeIgjen3.leggInn(129);
        listeIgjen3.leggInn(3);
        listeIgjen3.leggInn(15);
        System.out.println("Liste før noe er fjernet midterste "+listeIgjen3.toString());
        System.out.println("Fjerner indeks 1 "+ listeIgjen3.fjern(1));
        System.out.println("Skriver ut listen etter fjerning midterst "+listeIgjen3.toString());

        //Oppgave 7
        System.out.println("");
        System.out.println("Tester oppgave 7:");

        //Oppgave 8
        System.out.println("");
        System.out.println("Tester oppgave 8:");

        String[]navn={"Lars","Anders", "Bodil", "Kari","Per", "Berit"};
        Liste<String> listeSiste= new DobbeltLenketListe<>(navn);
        listeSiste.forEach(t-> System.out.print(t+" "));

        
        System.out.println();


        for(String t: listeSiste){
            System.out.print(t+" ");
        }


    }




}
