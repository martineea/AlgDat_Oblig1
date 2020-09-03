import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

////// Løsningsforslag Oblig 1 ////////////////////////

public class Oblig1 {

    public static void main (String[] args) {

        /// Tester oppgave 1
        int[] a = {5,4,3,2,1};

        System.out.println("Største verdi er: "+ maks(a)); // skriver ut tabellens største verdi
        System.out.println("Antall ombyttinger: "+ ombyttinger(a)); // skriver ut antall ombyttinger
        System.out.println((Arrays.toString(a))); // skriver ut hele tabellen for å se at størst ligger bakerst
        System.out.println("");

        /// Tester oppgave 2
        int[] b = {1,1,1,1,1,1,1,2};
        System.out.println("Antall ulike i et sortert array: "+antallUlikeSortert(b));
        System.out.println("");

        /// Tester oppgave 3
        int[] c = {3,3,2,1};
        System.out.println("Antall ulike i et u-sortert array: "+antallUlikeUsortert(c));
        System.out.println("");

        /// Tester oppgave 4
        //int[] d = {};

        /// Tester oppgave 5
        char[] e = {'A','B','C','D'}; // 5,1,2,3,4
        System.out.println("Skriver ut array rotert: ");
        rotasjon(e);

        /// Tester oppgave 6

        /// Tester oppgave 7

        /// Tester oppgave 8
    }


    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    /* Svar på:
    - Når blir det flest ombyttinger?
    - Når blir det færrest?
    - Hvor mange blir det i gjennomsnitt? --> det finnes en formel for gjennomsnittet
    - Kan du på grunnlag av dette si om metoden ​maks​ er bedre (eller dårligere) enn de maks-metodene
      vi har sett på tidligere?
     */
    public static int maks(int[] a)
    {
        if (a.length == 0) {
            throw new NoSuchElementException("Tabellen er tom!");
        }

        int temp; // midlertidig lagringsVariabel
        for (int i=1; i<a.length; i++) // går igjennom for å komme til neste index
        {
            if (a[i-1] > a[i]) { //hvis funnet index er større enn neste index
                temp = a[i]; //bytt plass på de
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
    /*
    Hvis ​a​ ikke er sortert stigende,skal det kastes en I​llegalStateException​(med en passende tekst).
    Tabellen ​a kan ha like verdier. Metoden skal returnere antallet forskjellige verdier i ​a​.
    Hvis f.eks. ​a inneholder 3, 3, 4, 5, 5, 6, 7, 7, 7 og 8, skal metoden returnere 6 siden det
    er 6 forskjellige verdier. Metoden skal ​ikke​ endre noe på tabellens innhold.
    Pass på at hvis tabellen er tom (har lengde 0), skal metoden returnere 0 siden det
    er 0 forskjellige verdier i en tom tabell. Med andre ord er ikke en tom tabell en feilsituasjon.
     */
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) { // Returnerer 0 hvis array er tomt, fordi det er ikke en feilsituasjon
            return 0;
        }

        int tellerUlike = 1;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i] > a[i+1]){ // hvis variabelen til venstre er større enn den til høyre er ikke listen sortert
                throw new IllegalStateException("Listen er ikke sortert!");
            }

            if (a[i] < a[i+1]) { // men hvis variabelen til venstre er mindre enn den til høyre teller den ulike
                tellerUlike++;
            }
        }
        return tellerUlike;
    }

    ///// Oppgave 3 //////////////////////////////////////
    /*
    Lag metoden ​public​ ​static​ ​int​ ​antallUlikeUsortert​(​int​[] a)​.
    Tabellen ​a​ kan nå være en hvilken som helst heltallstabell, dvs. den behøver ikke være sortert.
    Den kan også ha flere like verdier. Metoden skal finne og returnere antallet forskjellige verdier i ​a.​
    Metoden skal ​ikke​ endre noe på tabellens innhold. Hvis ​a​ f.eks. inneholder tallene
    5, 3, 7, 4, 3, 5, 7, 8, 6 og 7, skal metoden returnere 6 siden det er 6 forskjellige verdier.
    Pass på at hvis tabellen er tom (har lengde 0), skal metoden returnere 0 siden det er 0 forskjellige
    verdier i en tom tabell. Metoden skal ​ikke bruke hjelpetabeller​. At arbeidet skal foregå innenfor tabellen ​a​.
    Du kan selvfølgelig bruke en eller flere hjelpevariabler.
     */
    public static int antallUlikeUsortert(int[] a) {
        if (a.length == 0) { // Returnerer 0 hvis array er tomt, fordi da er det 0 ulike og ikke feilsituasjon
            return 0;
        }

        int tellerUlike = 1; // sier at første tallet er unikt
        for (int i = 1; i < a.length; i++) { // går igjennom tabellen, starter på tallet etter det som er telt
            boolean uniktTall = true; // sier at tallet er unikt med en boolean true
            for(int j=i-1; j >= 0; j--) { // <--- denne skjønner jeg ikke helt
                if (a[i] == a[j]) { // hvis i og j er like er det ikke et uniktTall
                    uniktTall = false;
                }
            }
            if (uniktTall) { // men hvis tallet er unikt/ uniktTall er sant
                tellerUlike++; // teller den opp
            }
        }
        return tellerUlike;
    }


    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    /*
    Det kan være aktuelt å «rotere» elementene i en tabell. En rotasjon på én enhet gjøres ved at det
    siste elementet blir det første og alle de andre forskyves én enhet mot høyre.
    På figuren over har elementene i den første tabellen blitt «rotert» én enhet.
    Lag metoden public​ ​static​ ​void​ ​rotasjon​(​char​[] a)​. Den skal «rotere» innholdet i tabellen ​a​ én enhet.
    En rotasjon i en tom tabell eller i en tabell med nøyaktig ett element er ingen feilsituasjon.
    Men rotasjonen vil da ikke endre noe.
     */
    public static void rotasjon(char[] a) {
        if (a.length < 2) { // hvis tabellen er tom eller kun har 1 tall skal den ikke gjøre noe, for da kan den ikke rotere noe tall
            return;
        }

        char temp;
        for (int i=1; i < a.length; i++) {
            if (a[i] > a[0]) {
                temp = a[i];
                a[i] = a[0];
                a[0] = temp;
            }
        }
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


