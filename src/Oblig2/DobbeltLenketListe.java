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

    public DobbeltLenketListe(T[] a) { // konstruktør
        Objects.requireNonNull(a, "Tabellen a er null!"); // kaster nullPointerException om a == null

        if (a.length > 0) {
            int i = 0;
            for (i = 0; i < a.length; i++) {
                if (a[i] != null) {
                    hode = new Node<>(a[i]);
                    antall++;
                    break;
                }
            }

            hale = hode;
            if (hode != null) {
                i++;
                for (; i < a.length; i++) {
                    if (a[i] != null) {
                        hale.neste = new Node<>(a[i], hale, null);
                        hale = hale.neste;
                        antall++;
                    }

                }
            }
        }


        Node p = new Node(null, null, null); //lager en ny
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

        for(int i=0; i<antall; i++){
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
    //oppgave 3b
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
                    ("til(" + til + ") > tablengde(" + antall + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
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

    //oppgave 4
    @Override
    public boolean inneholder(T verdi) {

        //Den skal returnere true hvis listen inneholder ​verdi​ og returnere false ellers.
        // Her lønner det seg å bruke et kall på metoden ​indeksTil​ som en del av koden.
        throw new UnsupportedOperationException();
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
        //Den skal returnere indeksen/posisjonen til ​verdi​ hvis den finnes i listen
        // og returnere -1 hvis den ikke finnes.
        //Her skal det ikke kastes unntak hvis​ verdi​ er n​ull​. men -1
        //Hvis ​verdi​ forekommer flere ganger, skal indeksen til den første av dem (fra venstre) returneres.


        throw new UnsupportedOperationException();
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

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    public String omvendtString() {
        throw new UnsupportedOperationException();
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
            //
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


