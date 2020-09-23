package Oblig1;

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

////// Løsningsforslag Oblig 1 ////////////////////////

public class Oblig1 {

    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    /*
    Svar på spørsmålene på oppgave 1:

    - Når blir det flest ombyttinger?
      Det blir flest ombyttinger når største verdi kommer først i tabellen.
      Det er verste tilfelle (n-1 ganger).

    - Når blir det færrest?
      Det blir færrest ombytteringer når minste verdi kommer først i tabellen (da blir det 0 ombyttinger).
      Dette er beste tilfelle (da går den 0 ganger inn i if-setningen).

    - Hvor mange blir det i gjennomsnitt? --> det finnes en formel for gjennomsnittet
      Formelen for å regne ut gjennomsnittet er: log(n) - 0,423
      Hvis vi har en tabell med 5 tall så blir det: log(5) - 0,423 = 0,699 - 0,423 = 0,276
      Hvis vi hadde hatt 100 tall i tabbellen vår så ville den i gjennomsnitt gått in i if 2 ganger.

    - Kan du på grunnlag av dette si om metoden ​maks​ er bedre (eller dårligere) enn de maks-metodene
      vi har sett på tidligere?
      De er ca like effektive eller ineffektive fordi begge har formelen log(n). Hadde formelen n2 så ville det vært
      større forskjell.
     */

    public static int maks(int[] a)
    {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int temp;
        for (int i=1; i<a.length; i++)
        {
            if (a[i-1] > a[i]) {
                temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int temp;
        int tellerOmbyttinger = 0;
        for (int i=1; i<a.length; i++) {
            if (a[i-1] > a[i]) {
                temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
                tellerOmbyttinger++;
            }
        }
        return tellerOmbyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////

    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int tellerUlike = 1;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){
                throw new IllegalStateException("Listen er ikke sortert!");
            }

            if (a[i] < a[i+1]) {
                tellerUlike++;
            }
        }
        return tellerUlike;
    }

    ///// Oppgave 3 //////////////////////////////////////

    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int tellerUlike = 1;
        for (int i = 1; i < a.length; i++) {
            boolean uniktTall = true;
            for(int j=i-1; j >= 0; j--) {
                if (a[i] == a[j]) {
                    uniktTall = false;
                }
            }
            if (uniktTall) {
                tellerUlike++;
            }
        }
        return tellerUlike;
    }

    ///// Oppgave 4 //////////////////////////////////////

    public static void delsortering(int[] a) {
        if (a.length == 0) {
            return;
        }

        int partallPlass = a.length-1;
        int oddetallPlass = 0;
        int temp;


        boolean fortsettByttePlass = true;
        for ( int i=0; fortsettByttePlass; i++)
        {
            while ((oddetallPlass <= partallPlass) && ((a[oddetallPlass] % 2 == 1)||(a[oddetallPlass] % 2 == -1))) {
                oddetallPlass++;
            }
            while ((oddetallPlass <= partallPlass) && (a[partallPlass] % 2 == 0)) {
                partallPlass--;
            }
            if ( partallPlass > oddetallPlass) {
                temp = a[partallPlass];
                a[partallPlass] = a[oddetallPlass];
                a[oddetallPlass] = temp;
            } else {
                fortsettByttePlass = false;
            }
        }
        partallPlass++;
        oddetallPlass--;
        quickSort(a,0,oddetallPlass);
        quickSort(a, partallPlass,a.length-1);
    }

    private static void quickSort(int[] a, int fra, int til) {
        if (fra < til) {
            int nyByttetVerdiIndex = byttPlass(a,fra,til);

            quickSort(a, fra, nyByttetVerdiIndex-1);
            quickSort(a,nyByttetVerdiIndex+1, til);
        }
    }

    private static int byttPlass(int[] a, int fra, int til) {
        int vippeVerdi = a[til];
        int i = fra-1;

        for (int j = fra; j < til; j++) {
            if (a[j] <= vippeVerdi) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[til];
        a[til] = temp;

        return i+1;
    }


    ///// Oppgave 5 //////////////////////////////////////

    public static void rotasjon(char[] a) {
        if (a.length < 2) {
            return;
        }

        int tempL = a.length;
        char tempBok = a[a.length-1];

        for (int i = tempL-1; i >=  1; i-- ) {
            a[i] = a[i-1];
        }
        a[0] = tempBok;
    }

    ///// Oppgave 6 //////////////////////////////////////

    public static void rotasjon(char[] a, int k) {
        if (a.length < 2) {
            return;
        }

        k = k % a.length;
        if (k < 0) {
            k += a.length;
        }

        char[] nyA = Arrays.copyOf(a, a.length);

        int tempIndex;
        for (int i = 0; i < a.length; i++) {
            tempIndex = i+k;
            if (tempIndex < a.length) {
                a[tempIndex] = nyA[i];
            }
            else {
                a[tempIndex - a.length] = nyA[i];
            }
        }
    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)

    public static String flett(String s, String t) {
        //lager hjelpe tabeller:
        String [] s1= s.split("(?<=.)");
        String [] t1= t.split("(?<=.)");

        String ut="";
        for(int i=0; i<s1.length || i<t1.length; i++){
            if(i<s1.length){
                ut+=s1[i];
            }
            if(i<t1.length){
                ut+=t1[i];
            }
        }
        return ut;
    }

    /// 7b)
    public static String flett(String... s) {
        String ut= "";

        int lengde = 0;

        for(int i = 0; i < s.length; i++) {
            if(s[i].length() > lengde) {
                lengde = s[i].length();
            }
        }

        for(int i=1; i<=lengde; i++){
            for(int j=0; j<=s.length-1; j++){
                if(i <= s[j].length()){
                    ut+=s[j].charAt(i-1);
                }
            }
        }
        return ut;
    }

    ///// Oppgave 8 //////////////////////////////////////

    public static int[] indekssortering(int[] a) {
        int[] indexTabell = new int[a.length];

        if (a.length == 0) {
            return indexTabell;
        }

        int[] tempA = Arrays.copyOf(a, a.length);
        Arrays.sort(tempA);

        for (int i = 0; i < tempA.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (tempA[i] == a[j]) {
                    indexTabell[i] = j;
                }
            }
        }
        return indexTabell;
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1.Oblig1


