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

    // Oppgave 1
    public DobbeltLenketListe(T[] a) { // konstruktør
        Objects.requireNonNull(a, "Tabellen a er null!"); // nullPointerException

        Node<T> p = new Node(null, null, null);

        // Først settes hode - gir noden i p en verdi og peker hode på denne:
        int teller = 0; // hjelppevariabel

        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                p.verdi = a[i];
                hode = p;
                teller++;
                antall++;
                break;
            }
            else {
                teller++;
            }
        }
        // Hvis det bare er 1 node i listen a, så settes både hale- og hode-pekerene på denne noden
        if (a.length == 1) {
            hale = hode;
        }
        else { // Hvis det er flere enn 1 node i listen, så må vi sette hale-pekeren:
            for (int i = teller; i < a.length; i++) {
                if (a[i] != null) {
                    Node q = new Node(a[i]);
                    q.forrige = p;
                    p.neste = q;
                    p = q;
                    hale = q;
                    antall++;
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

        //lager en ny node som angir verdien fra:
        Node<T> nodeFra= finnNode(fra);

        //finne antall elementer i listen:
        int antall= til-fra;
        //husk at et tomt intervall er lovlig. Det betyr at vi får en tom liste.
        if(antall<1){
            return new DobbeltLenketListe<>();
        }

        while(antall>0){
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

    // Oppgave 2b
    @Override
    public boolean leggInn(T verdi) {

        Objects.requireNonNull(verdi,"Null-verdier ikke tillatt");

        Node<T> p = new Node(verdi);

        // 1. Hvis listen på forhånd er tom
        if (antall == 0 && hode == null && hale == null) {
            hode = p;
            hale = p;
            p.neste = p.forrige = null;
            antall++;
            endringer++;
        }
        // 2. Hvis listen ikke er tom
        else {
            hale.neste = p;
            p.forrige = hale;
            hale = p;
            antall++;
            endringer++;
        }
        return true;
    }

    //oppgave5
    @Override
    public void leggInn(int indeks, T verdi) {

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
        antall++;
        endringer++;
    }

    //oppgave 4
    @Override
    public boolean inneholder(T verdi) {

         if(indeksTil(verdi) != -1) {
            return true;
         }
         else {
             return false;
         }
    }

    @Override
    //oppgave 3a
    public T hent(int indeks) {
        indeksKontroll(indeks, false);
        return finnNode(indeks).verdi;
    }

    //oppgave 4
    @Override
    public int indeksTil(T verdi) {
        // Ikke kastes unntak hvis​ verdi​ er n​ull​, men -1

        Node<T> node=hode;

        for(int indeks=0; indeks<antall; indeks++, node=node.neste ){
            //Den skal returnere indeksen/posisjonen til ​verdi​ hvis den finnes i listen
            if(node.verdi.equals(verdi)){
                return indeks;
                }
            }
        // og returnere -1 hvis den ikke finnes.
        return -1;

    }

    @Override
    //oppgave 3a
    public T oppdater(int indeks, T nyverdi) {
        //Husk at indeks må sjekkes,
        indeksKontroll(indeks, false);

        // at null-verdier ikke skal kunne legges inn.
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
        endringer++;
        //skal returnere verdien til verdien som var der før.
        return gammelVerdi;
    }

    // Oppgave 6
    @Override
    public boolean fjern(T verdi) {
        // Ikke kastes unntak hvis VERDI er null, men returnere false
        if (verdi == null) {
            return false;
        }

        // Hjelpevariabel
        Node<T> p = hode;

        while (p != null) {
            if (verdi.equals(p.verdi)) {
                break;
            }
            p = p.neste;
        }

        // Hvis verdi er null returnere false
        if (p == null) {
            return false;
        }
        // Hvis det kun er én node i listen, skal denne nulles ut
        else if (antall == 1) {
            hode = hale = null;
        }

        // Fjerner første node
        else if (p == hode) {
            hode = hode.neste;
            hode.forrige = null;
        }

        // Fjerner siste node
        else if (p == hale) {
            hale = hale.forrige;
            hale.neste = null;
        }

        // Fjerner mellomste
        else {
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
        }
        p.verdi = null;
        p.forrige = p.neste = null;
        antall--;
        endringer++;
        return true;
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {
        // Sjekke indeks
        indeksKontroll(indeks, false);

        Node<T> p = hode;
        T verdi; // verdien vi leter etter

        // Fjerne første (hvis kun 1 eller flere noder)
        if (indeks == 0) {
            verdi = p.verdi;
            if (p.neste != null) {
                hode = p.neste;
                hode.forrige = null;
            }
            else { // hvis p ikke kan peke på noen neste node, så er det kun 1 node i listen
                hode = null;
                hale = null;
            }
            antall--;
            endringer++;
            return verdi;
        }

        // Fjerne siste
        else if (indeks == antall-1) {
            p = hale;
            verdi = hale.verdi;
            hale = p.forrige;
            hale.neste = null;
            antall--;
            endringer++;
            return verdi;
        }

        // Fjerne mellomste
        else {
            for (int i = 0; i < indeks; i++) {
                p = p.neste;
            }
            verdi = p.verdi;
            p.forrige.neste = p.neste;
            p.neste.forrige = p.forrige;
            antall--;
            endringer++;
            return verdi;
        }
    }

    // Oppgave 7
    @Override
    public void nullstill() {

        /*
        Når jeg kjører tidstester i main så får jeg ulike resultater for hver gang jeg kjører de. Litt usikker på hvorfor?
        Feks:
        - Måte 1: 91 millisek (denne kan også finne på å være 185)
        - Måte 2: 196 millisek (mens denne da er 178 på samme kjøring)
        Men overordnet (hvis man ser på flertallene av resultater) så ser det ut som måte 1 er ca dobbelt så effektiv som måte 2

        */
        // Måte 1: nuller alt
        Node<T> p = hode;
        Node<T> temp; // hjelpe-noder

        while (p != null) {
            temp = p.neste;
            p.neste = null;
            p. forrige = null;
            p = temp;
        }
        antall = 0;
        endringer++;
        hode = hale = null;

        /*
        // Måte 2: fjerner en etter en indeks
        Node<T> q = hode;
        for (; q != null; q = q.neste) {
            fjern(0);
            endringer++;
        }
        */
    }

    // Oppgave 2a
    @Override
    public String toString() {

        Node<T> p = hode;

        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("["); // start tegnstreng

        if (antall == 0) {
            tegnStreng.append("]"); // hvis tom
            return tegnStreng.toString();
        }
        else {
            tegnStreng.append(p.verdi); // hvis ikke tom, sett inn verdier
            p = hode.neste;
            while (p != null) {
                tegnStreng.append(", ");
                tegnStreng.append(p.verdi);
                p = p.neste;
            }
        }
        tegnStreng.append("]"); // avslutt tegnstreng
        return tegnStreng.toString();
    }

    // Oppgave 2a
    public String omvendtString() {

        Node<T> p = hale;

        StringBuilder tegnStreng = new StringBuilder();
        tegnStreng.append("["); // start tegnstreng

        if (antall == 0) {
            tegnStreng.append("]"); // hvis tom
            return tegnStreng.toString();
        }
        else {
            tegnStreng.append(p.verdi); // hvis ikke tom, sett inn verdier
            p = p.forrige;
            while (p != null) {
                tegnStreng.append(", ");
                tegnStreng.append(p.verdi);
                p = p.forrige;
            }
        }
        tegnStreng.append("]"); // avslutt tegnstreng
        return tegnStreng.toString();
    }

    //oppgave 8b
    @Override
    public Iterator<T> iterator() {
        //Den skal returnere en instans av iteratorklassen.
        return new DobbeltLenketListeIterator();
    }

    //oppgave 8d
    public Iterator<T> iterator(int indeks) {

        // Sjekkee at indeksen er lovlig vba indeksKontroll​()​.
        indeksKontroll(indeks, false);

        //Deretter skal den ved hjelp av konstruktøren i punkt c) returnere en instans av iteratorklassen.
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
        //oppgave 8c
        private DobbeltLenketListeIterator(int indeks) {
            //setter denne til den oppgitte indeksen
           denne = finnNode(indeks);

            //Resten skal være som i den konstruktøren som er ferdigkodet.
            //setter fjernOk til være false
            fjernOK = false;

            //setter iteratorendringer itl endringer
            iteratorendringer = endringer;
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        //oppgava 8a
        @Override
        public T next() {

            if (iteratorendringer != endringer) {
                //Hvis ikke, kastes en ​ConcurrentModificationException​.
                throw new ConcurrentModificationException("Det er ikke lovlig at endringer og iteratorendringer ikke er like");
            }
            if (!hasNext()) {
                ////Så en ​NoSuchElementException hvis det ikke er flere igjen i listen (dvs. hvis ​hasNext​()​ ikke er sann/true).
                throw new NoSuchElementException(" Det er ikke flere elementer i listen");
            }
            //Deretter settes ​fjernOK​ til sann/true, verdien til ​denne​ returneres og ​denne​ flyttes til den neste node.
            fjernOK = true;
            T verdi = denne.verdi;
            denne = denne.neste;
            return verdi;
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

        //Hvis indeks er mindre enn ​antall​/2, ​skal letingen etter noden starte fra hode og gå mot høyre ved hjelp av neste-pekere.
        if (indeks <= antall / 2) {
            for (int i = 0; i < indeks; i++) {
                forerstCurrent = forerstCurrent.neste;
            }
            return forerstCurrent;
        }
        //Hvis ikke, ​skal​ letingen starte fra halen og gå mot venstre ved hjelp av forrige-pekere.
        else {
            for (int i = antall - 1; i > indeks; i--) {
                bakerstCurrrent = bakerstCurrrent.forrige;
            }
            return bakerstCurrrent;
        }
    }
}// class DobbeltLenketListe


