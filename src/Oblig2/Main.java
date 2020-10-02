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
        // Listen er tom og returnerer true

        // Tester dette i oppg 1, etter oppgave 2 er ferdig:
        String[] s = {"Ole", null, "Per", "Kari", null};
        Liste<String> liste4 = new DobbeltLenketListe<>(s);
        System.out.println(liste4.antall() + " " + liste4.tom());
        // Utskrift: 3 false
        // Listen inneholder 3 verdier og returnerer false fordi den ikke er tom

        // Oppgave 2a: sjekk at følgende programbit gir rett utksirft:

        System.out.println("");
        System.out.println("Tester oppgave 2a:");

        String[] s1 = {}, s2 = {"A"}, s3 = {null, "A", null, "B", null};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println(l1.toString() + " " + l2.toString() + " " + l3.toString() + " "
                + l1.omvendtString() + " " + l2.omvendtString() + " " + l3.omvendtString());
        System.out.println("TEST: "+l3.toString() + " " + l3.omvendtString());
        // Utkskrift: [] [A] [A, B] [] [A] [B, A]


        System.out.println("");
        System.out.println("Tester oppgave 2b:");

        DobbeltLenketListe<Integer> liste1 = new DobbeltLenketListe<>();
        System.out.println(liste1.toString() + " " + liste1.omvendtString());

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

        System.out.println("");
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

       
        System.out.println(liste2.subliste(8,liste2.antall()));

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

        // Teste på tom liste
        DobbeltLenketListe<Integer> testeTom = new DobbeltLenketListe<>();
        // testeTom.leggInn(1);
        //testeTom.fjern(1);
        System.out.println("Skal returnere false om listen er tom: " + testeTom.fjern(null));
        // Utskrift: false

        // Teste når første er fjernet:
        System.out.println("");
        DobbeltLenketListe<Integer> testeFjern= new DobbeltLenketListe<>();
        testeFjern.leggInn(1);
        testeFjern.leggInn(2);
        testeFjern.leggInn(3);
        testeFjern.leggInn(4);
        System.out.println("Teste om første er fjernet:");
        System.out.println("Listen før fjerning av verdi: " + testeFjern.toString() + " " + testeFjern.omvendtString()); // [1, 2, 3, 4] [4, 3, 2, 1]
        System.out.println("Antall noder: " + testeFjern.antall());
        System.out.println("Fjerner første indeks, verdi "+ testeFjern.fjern(0)); // fjerner verdien 1 fra listen
        System.out.println("Listen etter at første er fjernet: " + testeFjern.toString() + " "  + testeFjern.omvendtString()); // [2, 3, 4] [4, 3, 2]
        System.out.println("Antall noder: " + testeFjern.antall());

        // Teste om siste er fjernet:
        System.out.println("");
        DobbeltLenketListe<Integer> testeFjern2 = new DobbeltLenketListe<>();
        testeFjern2.leggInn(1);
        testeFjern2.leggInn(2);
        testeFjern2.leggInn(3);
        testeFjern2.leggInn(4);
        System.out.println("Fjerne siste: ");
        System.out.println("Liste før noe er fjernet: " + testeFjern2.toString() + " " + testeFjern2.omvendtString()); // [1, 2, 3, 4] [4, 3, 2, 1]
        System.out.println("Antall noder: " + testeFjern2.antall());
        System.out.println("Fjerner siste indeks, verdi " + testeFjern2.fjern(3));
        System.out.println("Skriver ut listen etter at siste verdi er fjernet " + testeFjern2.toString() + " " + testeFjern2.omvendtString());  // [1, 2, 3] [3, 2, 1]
        System.out.println("Antall noder: " + testeFjern2.antall());

        // Teste om mellomste er fjernet:
        System.out.println("");
        DobbeltLenketListe<Integer> testeFjern3 = new DobbeltLenketListe<>();
        testeFjern3.leggInn(1);
        testeFjern3.leggInn(2);
        testeFjern3.leggInn(3);
        System.out.println("Fjerne mellomste: ");
        System.out.println("Liste før noe er fjernet: "+testeFjern3.toString() + " " + testeFjern3.omvendtString()); // [1, 2, 3] [3, 2, 1]
        System.out.println("Antall noder: " + testeFjern3.antall());
        System.out.println("Fjerner indeks 1, verdi "+ testeFjern3.fjern(1));
        System.out.println("Skriver ut listen etter at mellomste er fjernet: "+testeFjern3.toString() + " " + testeFjern3.omvendtString()); // [1, 3] [3, 1]
        System.out.println("Antall noder: " + testeFjern3.antall());

        // Teste om kun 1 node igjen
        System.out.println("");
        DobbeltLenketListe<Integer> testeFjern4 = new DobbeltLenketListe<>();
        testeFjern4.leggInn(1);
        testeFjern4.leggInn(2);
        testeFjern4.leggInn(3);
        System.out.println("Fjerne alle utenom 1 node: ");
        System.out.println("Liste før noe er fjernet "+testeFjern4.toString() + " " + testeFjern4.omvendtString()); // [1, 2, 3] [3, 2, 1]
        System.out.println("Antall noder: " + testeFjern4.antall());
        System.out.println("Fjerner to av tre verdier, verdi "+ testeFjern4.fjern(2) + " og " + testeFjern4.fjern(1));
        System.out.println("Skriver ut listen etter at 2 av 3 noder er fjernet "+testeFjern4.toString() + " " + testeFjern4.omvendtString()); // [1] [1]
        System.out.println("Antall noder: " + testeFjern4.antall());

        // TEste om alle noder fjernes
        System.out.println("");
        DobbeltLenketListe<Integer> testeFjern5 = new DobbeltLenketListe<>();
        testeFjern5.leggInn(1);
        testeFjern5.leggInn(2);
        testeFjern5.leggInn(3);
        System.out.println("Fjerne alle noder: ");
        System.out.println("Liste før noe er fjernet "+testeFjern5.toString() + " " + testeFjern5.omvendtString()); // [1, 2, 3] [3, 2, 1]
        System.out.println("Antall noder: " + testeFjern5.antall());
        System.out.println("Fjerner alle noder, verdi "+ testeFjern5.fjern(2) + ", " + testeFjern5.fjern(1) + ", " + testeFjern5.fjern(0));
        System.out.println("Skriver ut listen etter at 2 av 3 noder er fjernet "+testeFjern5.toString() + " " + testeFjern5.omvendtString()); // [] []
        System.out.println("Antall noder: " + testeFjern5.antall());

        //Oppgave 7
        System.out.println("");
        System.out.println("Tester oppgave 7:");

        int antall = 10_000_000;
        long start = 0;
        long slutt = 0;

        DobbeltLenketListe<Integer> testTid = new DobbeltLenketListe<>();

        // Tester metode 1 der man bruker nullstill til å nulle ut alt
        for (int i = 0; i < antall; i++) {
            testTid.leggInn(i);
        }
        start = System.currentTimeMillis(); // starter å telle
        testTid.nullstill();
        slutt = System.currentTimeMillis(); // stopper å telle
        System.out.println(slutt - start + " millisek - når man bruker nullstill-metoden til å nulle ut");

        // TEster metode 2 der man fjerner en etter en indeks til det er tomt
        for (int i = 0; i < antall; i++) {
            testTid.leggInn(i);
        }
        start = System.currentTimeMillis(); // starter å telle
        while (testTid.antall() > 0) {
            testTid.fjern(0);
        }
        slutt = System.currentTimeMillis(); // slutter å telle
        System.out.println(slutt - start + "millisek - når man fjerner en og en indeks");

        // Måte 1: 243 millisek
        // Måte 2: 77 millisek
        //

        /*
        DobbeltLenketListe<Integer> oppg7 = new DobbeltLenketListe<>();
        for (int i = 0; i < 10000000; i++) { // 10mill tall
            oppg7.leggInn(i);
        }

        long start = System.currentTimeMillis();
        oppg7.nullstill();
        long slutt = System.currentTimeMillis();
        System.out.print(slutt - start);


        for (int i = 0; i < 10000000; i++) {
            oppg7.leggInn(i);
        }

        start = System.currentTimeMillis();
        while (oppg7.antall() > 0) {
            oppg7.fjern(0);
        }
        slutt = System.currentTimeMillis();
        System.out.print(slutt - start);


        /*


        Liste<Integer> liste = new DobbeltLenketListe<>();
        for(int i = 0; i < 1000000; i++){
            liste.leggInn(i);
        }
        long tic = System.currentTimeMillis();
        liste.nullstill();
        long toc = System.currentTimeMillis();
        long timetaken = toc - tic;
        System.out.println("Dette tok " + timetaken + "ms");
         */

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
