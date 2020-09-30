package Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.*;

import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() { // konstruktør for tom liste
        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    /*
    Sjekkliste for konstrultøren DobbeltLenketListe(T[]):
    ● Stoppes en null-tabell? Kastes i så fall en ​NullPointerException​?
    ● Blir det korrekt hvis parametertabellen inneholder en eller flere null-verdier?
    ● Blir det korrekt hvis parametertabellen er tom (har lengde 0)?
    ● Blir det korrekt hvis parametertabellen kun har null-verdier?
    ● Blir det korrekt hvis parametertabellen har kun én verdi som ikke er null?
    ● Blir antallet satt korrekt?
    ● Får verdiene i listen samme rekkefølge som i tabellen?
     */

    // Oppgave 1
    public DobbeltLenketListe(T[] a) { // konstruktør
        // Skal lage en dobbeltlenket liste med verdiene fra tabellen a
        // Verdiene skal ligge i samme rekkefølge i listen som i tabellen

        // Hvis a er null skal det kastes en NullPointerException
        // Hvis a inneholder en eller flere null-verdier skal de ikke tas med
        // Dvs den skal returnere liste med verdiene fra a som ikke er null
        Objects.requireNonNull(a, "Tabellen a er null!"); // kaster nullPointerException om a == null

        // Passe på at hode peker til den første i listen og hale til den siste
        // Pass på at neste og forrige er satt riktig i alle noder.
        // hode.forrige og hale.neste skal være null
        // Hvis tabellen a kun har en verdi skal både hode og hale peke på samme node
        // Hvis a er tom skal det ikke opprettes noen noder og hode og hale er fortsatt null

        Node p = new Node(null, null, null); // oppretter en ny node

        if (a.length > 0) {
            int i = 0;
            for (; i < a.length; i++) {
                if (a[i] != null) { // hvis a sin verdi ikke er null/ hvis a ikke er tom
                    p.verdi = a[i]; // så setter den noden p sin verdi til å være lik a sin verdi
                    hode = p; // og peker hode på noden
                    antall++; // og legger på 1 i antall noder
                    break;
                }
            }

            //Så skal man sette hode, kjører igjennom tabellen a
            // og lage resten av listen
            hale = hode;
            if (hode != null) { // hvis det er flere noder etter hode i listen (ikke består kun av 1 eller tom)
                i++; // plusser den på i
                for (; i < a.length; i++) { // og kjører igjennom a
                    if (a[i] != null) { // og hvis a sin ikke er null (ikke flere noder)
                        Node q = new Node(a[i]); // lages ny node q
                        hale.neste = q; // og setter q til hale.neste
                        hale = hale.neste;
                        antall++; // og plusser på antall i listen
                    }
                }
            }
        }
    }

    //oppgave 3b
    public Liste<T> subliste(int fra, int til) {
        //Denne kontrollmetoden kan da kalles med​ antall​,f​ra​ og​ til​ som argumenter.
        fraTilKontroll(antall,fra, til);
        //lager en dobbeltlenketListe
        DobbeltLenketListe <T> liste=new DobbeltLenketListe<>();

        //lager en ny node som angir verdien til fra:
        Node<T> nodeFra= finnNode(fra);

        //finne antall elementer i listen:
        int antall= til-fra;
        //husk at et tomt intervall er lovlig. Det betyr at vi får en tom liste.
        if(antall<1){
            return new DobbeltLenketListe<>();
        }

        while(antall>0){
            // Variabelen ​endringer​ skal være 0. Her kan alle metoder brukes - også ​leggInn​()​.

            liste.leggInn(nodeFra.verdi);
            nodeFra= nodeFra.neste;
            //Pass på at variablen ​antall ​ i den listen som metoden​ subliste(​)​returnerer,får korrekt verdi.
            antall--;

        }
        //Den skal returnere en liste (en instans av klassen ​DobbeltLenketListe​)
        // som inneholder verdiene fra intervallet [fra:til> i «vår» liste.
        return liste;







    }
    //oppgave 3b hentet fra kompendiet
    private static void fraTilKontroll(int antall, int fra, int til){

        //Her må det først sjekkes om indeksene ​fra​ og ​til​ er lovlige.
        //Hvis ikke, skal det kastes unntak slik som i metoden ​fratilKontroll​()​.
        //legg derfor den inn som en privat metode i klassen ​DobbeltLenketListe​
        // og bytt ut ArrayIndexOutOfBoundsException​ med ​IndexOutOfBoundsException siden vi ikke har noen tabell (array) her.
        //Bytt også ut ordet ​tablengde​ med ordet ​antall.​

        if (fra < 0)                                  // fra er negativ
        throw new IndexOutOfBoundsException
                ("fra(" + fra + ") er negativ!");

        if (til > antall)                          // til er utenfor tabellen
            throw new IndexOutOfBoundsException
                    ("til(" + til + ") > antall(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

    }

    @Override
    public int antall() {
        // Returnere antallet verdier i listen
        return antall;
    }

    @Override
    public boolean tom() {
        // Returnere true eller false avhengig av om listen er tom eller ikke
        if (antall == 0) {
            return true;
        }
        return false;
    }

    /*
    Sjekkliste for metoden ​leggInn(T verdi)​:
    ●  Stoppes null-verdier? Kastes i så fall en ​NullPointerException​?
    ● Blir det korrekt hvis listen fra før er tom?
    ● Blir det korrekt hvis listen fra før ikke er tom?
    ● Blir antallet økt?
    ● Blir endringer økt?
    ● Er det rett returverdi?
     */
    // Oppgave 2b
    @Override
    public boolean leggInn(T verdi) {

        // Null-verdier ikke tillatt - bruk en requireNonNull.metode fra klassen Objects
        Objects.requireNonNull(verdi,"Null-verdier ikke tillatt");

        // innleggingsmetoden: legge en ny node med oppgitt verdi bakerst i listen og returnere true
        /*
        Skille mellom to tilfeller:
        1. at listen på forhånd er tom
        2. at den ikke er tom
        - I en tom liste skal både hode og hale være null (og antall lik 0)
        - I tilfelle 1 skal både hode og hale etter innleggingen peke på den nye noden
            (både forrige-peker og neste-peker i noden skal da være null
        - I tilfelle 2 er det kun hale-pekeren som skal endres etter innleggingen.
            Pass da på at forrige-peker og neste-peker i den nye noden og i den noden
            som opprinnelig lå bakerst, får korrekte verdier.
        -  Husk at antallet må økes etter en innlegging.
        - Det samme med variabelen endringer.
        - Metoden skal returnere true
         */

        Node<T> p = new Node(verdi); // lager en ny node, kalt p

        // 1. Hvis listen på forhånd er tom
        if (antall == 0 && hode == null && hale == null) { // ssjekke om antall er lik 0 og hode og hale er null
            hode = p; // både hode og hale skal peke på den nye noden p
            hale = p;
            antall++;
            endringer++;
        }
        // 2. Hvis listen ikke er tom
        else {
            hale.neste = p; // setter inn p bakerst: p lik hale sin neste node - dvs den bakerste noden
            p.forrige = hale; // setter så hale lik p sin forrige - dvs neste bakerste noden
            hale = p; // setter så p lik hale, så den nye hale-pekeren peker på den nye noden å
            antall++;
            endringer++;
        }
        return true;
    }


    //oppgave5
    @Override
    public void leggInn(int indeks, T verdi) {
        // Den skal legge ​verdi​ inn i listen slik at den får indeks/posisjon ​indeks​.
        //Husk at negative indekser og indekser større enn antall
        // er ulovlige (indekser fra og med 0 til og med antall er lovlige).

        //kaster et avvik hvis verdi er null
        Objects.requireNonNull(verdi, "Det er ikke tillatt med null.");
        Node <T> forandretNode= new Node<T>(verdi,null, null);

        if(indeks<0 || indeks>antall){
            throw new IndexOutOfBoundsException("indeks: "+ indeks+ " må være mer enn 0 og må være mindre enn antall" );
        }
        else if (hode == null && hale == null)
        {
            hode = forandretNode;
            hale = forandretNode;
        }
        else if (indeks == 0)
        {
            forandretNode.neste = hode;
            hode.forrige = forandretNode;
            hode = forandretNode;
        }
        else if (indeks == antall) {
            forandretNode.forrige = hale;
            hale.neste = forandretNode;
            hale = forandretNode;
        }
        else
        {
            Node<T> høyreNode = finnNode(indeks);
            forandretNode.forrige = høyreNode.forrige;
            forandretNode.neste = høyreNode;
            høyreNode.forrige = forandretNode;
            forandretNode.forrige.neste = forandretNode;
        }
        // Her må du passe på de fire tilfellene
        // 1) listen er tom,
        // 2) verdien skal legges først,
        // 3) verdien skal legges bakerst og
        // 4) verdien skal legges mellom to andre verdier.
        //Sørg for at neste- og forrige-pekere får
        // korrekte verdier i alle noder
        //Spesielt skal forrige-peker i den første noden være null og neste-peker i den siste noden være null.

        antall++;
        endringer++;




    }

    //oppgave 4
    @Override
    public boolean inneholder(T verdi) {


        //Den skal returnere true hvis listen inneholder ​verdi​ og returnere false ellers.
        // Her lønner det seg å bruke et kall på metoden ​indeksTil​ som en del av koden.
         if(indeksTil(verdi) != -1){
            return true;
         }
         else{
             return false;
         }


    }

    @Override
    //oppgave 3a
    public T hent(int indeks) {
        //skal lages ved ved å bruke ​finnNode(​)​

        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;

        //Pass på at ​indeks ​sjekkes.

        //Bruk metoden ​indeksKontroll(​)​ som arves fra​ Liste​(bruk ​false​ som parameter).

    }
    //oppgave 4
    @Override
    public int indeksTil(T verdi) {

        // og returnere -1 hvis den ikke finnes.
        //Her skal det ikke kastes unntak hvis​ verdi​ er n​ull​. men -1

        Node<T> node=hode;

            for(int indeks=0; indeks<antall; indeks++, node=node.neste ){

                if(node.verdi.equals(verdi)){
                    //Den skal returnere indeksen/posisjonen til ​verdi​ hvis den finnes i listen

                    //Hvis ​verdi​ forekommer flere ganger, skal indeksen til den første av dem (fra venstre) returneres.
                    return indeks;
                }
            }

        return -1;

    }

    @Override
    //oppgave 3a
    public T oppdater(int indeks, T nyverdi) {
        //Husk at indeks må sjekkes,
        indeksKontroll(indeks, false);

        // at null-verdier ikke skal kunne legges inn og at variabelen ​endringer​ skal økes.

        if(nyverdi==null){
            throw new NullPointerException("Null-verdier er ikke lov.");
        }

        //skal erstatte verdien på plass ​indeks med ​nyverdi​ og returnere det som lå der fra før.
        //lager en ny Node og finner noden til den gitte indeksen.
        Node<T> nodeEksempel= finnNode(indeks);
        //lagrer den gamle verdien
        T gammelVerdi = nodeEksempel.verdi;
        //lager ny verdi
        nodeEksempel.verdi=nyverdi;

        //skal returnere verdien til verdien som var der før.
        return gammelVerdi;

    }

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
    // Oppgave 6
    @Override
    public boolean fjern(T verdi) {
        // Skal fjerne VERDI fra listen og så returnere true
        // Hvis det er flere forekomster av verdier er det den første av dem (fra venstre) som skal fjernes
        // Lag metoden så effektiv som mulig, må derfor kodes direkte og IKKE ved hjelp av indeksTil(T verdi) og fjern(int indeks)

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

        // Hvis VERDI ikke er i listen, skal metoden returnere false
        // Her skal det ikke kastes unntak hvis VERDI er null, metoden skal
        // i stedet for returnere false.
        if (verdi == null) {
            return false;
        }

        // Hjelpevariabel
        Node<T> p = hode; // peker som peker på samme som hode - dvs første i listen

        // Fjerne første
        if (p.verdi.equals(verdi) && p.neste != null) { // hvis peker sin verdi er lik verdi og det er en verdi etter neste
            hode = p.neste; // så skal neste node være nye hode - derned den første i listen
            hode.forrige = null; // og den forrige er null - den tas dermed bort
            antall--;
            endringer++;
            return true; // return true for VERDI er nå fjernet
        }
        else { // hvis p sin verdi ikke er lik verdi og det ikke finnes en neste
            hode = null; // skal hode og hale settes lik null (for da er det ingenting der)
            hale = null;
        }

        // Fjerne mellomste
        p = hode.neste; // peker p på nest første node
        for (; p != null; p = p.neste) { // kjører igjennom: så lenge p ikke er null (dvs neste node eksisterer) så hopper vi til neste node
            if(p.verdi.equals(verdi)) { // og hvis p sin verdi er lik verdi
                // så må vi sette ..??
            }
        }

        // Fjerne siste
        p = hale; // setter pekeren på siste node
        if (p.verdi.equals(verdi)) { // hvis verdien der p peker er lik verdi
            hale = p.forrige; // så skal vi sette hale lik p sin forrige
            hale.neste = null; // og hale sin neste til lik null - vi tar da bort siste noden
            antall--;
            endringer++;
            return true;
        }


        return false;
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();

        // Skal fjerne (og returnere) verdien på posisjon INDEKS
        // Indeks må først sjekkes
        // Lag metoden så effektiv som mulig
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
    }

    @Override
    public void nullstill() {
        throw new UnsupportedOperationException();
    }

    // Oppgave 2a
    @Override
    public String toString() {
        /*
        - Skal bruke StringBuilder (eller StringJoiner) til å bygge opp tegnstrengen
            og verdiene i listen finner du ved å travesere fra hode til hale vha
            neste-pekere
        - Skal returnere en tegnstreng med listens verdier
        - Hvis listen feks inneholder tallene 1,2 og 3, skal metoden returenre strengen:
            [1,2,3] og kun [] hvis liten er tom
        */

        // Lager en peker, som først peker på første:
        Node<T> peker = hode;

        StringBuilder tegnStreng = new StringBuilder(); // Begynner å bygge tegnstrengen
        tegnStreng.append("["); // lager første del av strengen med [

        if (antall == 0) {
            tegnStreng.append("]"); // hvis den er tom returnerer den bare []
            return tegnStreng.toString(); // og returnerer toString som er []
        }
        else { // hvis den ikke er 0
            tegnStreng.append(peker.verdi); // legger den til peker sin verdi
            peker = hode.neste; // og peker på neste node
            while (peker != null) { // og hvis peker ikke er null - altså hvis det er flere noder
                tegnStreng.append(", "); // setter den inn et komma for å skille flere verdier
                tegnStreng.append(peker.verdi); // og setter inn neste node sin verdi, der pekeren peker nå
                peker = peker.neste; // også peker den på neste og sjekker om denne er null eller om der er flere noder i listen
            }
        }
        tegnStreng.append("]"); // avslutter tegnstrengen med ]
        return tegnStreng.toString();
    }

    // Oppgave 2a
    public String omvendtString() {
        /*
        - Skal returnere en tegnstreng på samme form som den toString() gir,
            men verdiene skal komme i omvendt rekkefølge
        - Skal finne verdiene i omvendt rekkefølge ved å travesere fra hale til hode vha
            forrige-pekere
        - hensikten ved omvendtString er å sjekke at forrige-pekerne er satt riktig
         */

        Node<T> peker = hale;

        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("[");

        if (antall == 0) {
            tegnStreng.append("]");
            return tegnStreng.toString();
        }
        else {
            tegnStreng.append(peker.verdi);
            peker = peker.forrige;
            while (peker != null) {
                tegnStreng.append(", ");
                tegnStreng.append(peker.verdi);
                peker = peker.forrige;
            }
        }
        tegnStreng.append("]");
        return tegnStreng.toString();
    }

    //oppgave 8b
    @Override
    public Iterator<T> iterator() {

        //Den skal returnere en instans av iteratorklassen.
        return new DobbeltLenketListeIterator();
    }

    //oppgave 8c
    public Iterator<T> iterator(int indeks) {

        //Den skal sette pekeren ​denne​ til den noden som hører til den oppgitte indeksen.
        indeksKontroll(indeks, false);
        // Resten skal være som i den konstruktøren som er ferdigkodet.
        return new DobbeltLenketListeIterator(indeks);


    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        //oppgava 8a
        @Override
        public T next() {

            //Den skal først sjekke om ​iteratorendringer​ er lik ​endringer.​
            if(iteratorendringer==endringer){
                fjernOK=true;
                T boolsk = denne.verdi;
                denne = denne.neste;
                return boolsk;
            }
            else if(!hasNext()){
                ////Så en ​NoSuchElementException hvis det ikke er flere igjen i listen (dvs. hvis ​hasNext​()​ ikke er sann/true).
                throw new NoSuchElementException("Det er ikke flere elementer i listen.");
            }
            else{
                //Hvis ikke, kastes en ​ConcurrentModificationException​.
                throw new ConcurrentModificationException("Det er ikke lovlig at endringer og iteratorendringer ikke er like");
            }

            //Deretter settes ​fjernOK​ til sann/true, verdien til ​denne​ returneres og ​denne​ flyttes til den neste node.


        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }

    //Oppgave 3.
    private Node<T> finnNode(int indeks) {

        Node forerstCurrent=hode;
        Node bakerstCurrrent=hale;

        //Hvis indeks er mindre enn ​antall​/2,
        if (indeks <= antall / 2) {

            for (int i = 0; i < indeks; i++) {
                forerstCurrent = forerstCurrent.neste;
            }
            // så ​skal letingen etter noden starte fra hode og gå mot høyre ved hjelp av neste-pekere.
            return forerstCurrent;
            //hvis ikke
        } else {


            for (int i = antall - 1; i > indeks; i--) {
                bakerstCurrrent = bakerstCurrrent.forrige;
                // Hvis ikke, ​skal​ letingen starte fra halen og gå mot venstre ved hjelp av forrige-pekere.
            }

            return bakerstCurrrent;
            //legger til returnstatement.

        }
    }

}// class DobbeltLenketListe


