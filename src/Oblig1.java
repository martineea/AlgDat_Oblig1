import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

////// Løsningsforslag Oblig 1 ////////////////////////

public class Oblig1 {

    public static void main (String[] args) {

        int[] a = {5,4,3,2,1,10};
        // 1, 2, 3, 4, 5

        System.out.println(maks(a)); // skriver ut tabellens største verdi
        System.out.println((Arrays.toString(a))); // skriver ut hele tabellen
        int[] tabell6 = {4, 3, 3, 1, 2, 1};
        System.out.println(antallUlikeUsortert(tabell6));
    }


    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a)
    {
        if (a.length == 0) {
            throw new UnsupportedOperationException("Tabellen er tom!");
        }

        int størst = a[0]; // setter størst = den verdien på index 0
        for (int i=1; i<a.length; i++) // går igjennom for å komme til neste index
        {
            int teller = 0;
            if (a[i] > størst) { // hvis størst er større enn neste tall
                ombyttinger(a); // gjør vi en ombytting
                teller++; // og registrerer at en ombytting har blitt gjort
                return størst;
            }
        }
        return størst;
    }

    public static int ombyttinger(int[] a) {
        for(int i=1; i<a.length; i++) {
            for(int j=1; j<a.length; j++) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                return temp;
            }
        }
        return maks(a);
    }


    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {


        throw new UnsupportedOperationException();
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //foreløpig oppgave 3:
        if (a.length == 0) {
            return 0;
        }
        int tellerUlike = 0;
        int hjvaribel = 0;
        for (int i = 0; i < a.length; i++) {
            int k = a[0];

            int j=0;
            while (a[i] != k) {
                //hjvaribel=a[j];
                if (a[i] == k) {
                }
                else{
                    tellerUlike++;
                    break;
                }
                j++;
            }


        }
        return tellerUlike;


            //throw new UnsupportedOperationException();



    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
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

}  // Oblig1


