package Oblig2;


////////////////// class DobbeltLenketListe //////////////////////////////


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
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

    public Liste<T> subliste(int fra, int til) {
        throw new UnsupportedOperationException();
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

    @Override
    public boolean leggInn(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    //oppgave 3a
    public T hent(int indeks) {
        //skal lages ved ved å bruke ​finnNode(​)​

        //Pass på at ​indeks ​sjekkes.

        //Bruk metoden ​indeksKontroll(​)​ som arves fra​ Liste​(bruk ​false​ som parameter).
        indeksKontroll(indeks,false);

        throw new UnsupportedOperationException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    //oppgave 3a
    public T oppdater(int indeks, T nyverdi) {

        //skal erstatte verdien på plass ​indeks med ​nyverdi​ og returnere det som lå der fra før.

        //Husk at indeks må sjekkes,
        // at null-verdier ikke skal kunne legges inn og at variabelen ​endringer​ skal økes.

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T fjern(int indeks) {
        throw new UnsupportedOperationException();
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

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new UnsupportedOperationException();
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

        @Override
        public T next() {
            throw new UnsupportedOperationException();
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
    private Node<T> finnNode(int indeks){

        //Den skal returnere noden med den gitte indeksen/posisjonen.
        this.antall=0;

        DobbeltLenketListe<T> verdi= new DobbeltLenketListe<>();


        //head
        Node current= verdi.hode;
        Node bakerste=verdi.hale;
        //Hvis indeks er mindre enn ​antall​/2,
        if(indeks<antall/2) {


            //while(verdi.hode < verdi.hale){
            //må ha en måte å gjøre dette på

            //for(Node i=current; i=verdi.hale; )
            int i=0;
            if (i<indeks) {
                for(; i<indeks; i++) {
                    current = current.neste;
                    return current;
                }
                if (i>indeks) {
                    for(; i>indeks; i++) {
                        bakerste = bakerste.forrige;
                        return bakerste;
                    }
                }
            }

            //i++;
            // så ​skal letingen etter noden starte fra hode og gå mot høyre ved hjelp av neste-pekere.
            //}
        }
        else{
            //while(verdi.hale>hode){
            // bakerste= bakerste.forrige;
            // // Hvis ikke, ​skal​ letingen starte fra halen og gå mot venstre ved hjelp av forrige-pekere.
            //j--;
            // }
        }







        //legger til returnstatement.
        return null;
    }






} // class DobbeltLenketListe


