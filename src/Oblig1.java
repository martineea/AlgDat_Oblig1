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

    - Når blir det færrest?
        Det blir færrest ombytteringer når minste verdi kommer først i tabellen (da blir det 0 ombyttinger).

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

    /*///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        int oddetallTeller = 0; //Angir oddetall-teller
        int partallTeller = 0; //Angir partall-teller
        int teller = 0; //initaliserer teller.
        int temp = 0; //initalisererer en midlertidig variabel til ombytting

        for (int i = 0; i < a.length; i++) { //går igjennom tabellen og sjekker hvor mange partall og hvor mange oddetall.

            if (a[i] % 2 == 1) {
                oddetallTeller++; //teller opp antall oddetall
            }
            if (a[i] % 2 == 0) {
                partallTeller++; //teller opp antall partall
            }
        }
        //Sorterer alle oddetallene og partallene
        if (a.length == oddetallTeller || a.length == partallTeller) {
            sortering(a);
        }
        else{
            for (int i = 0; i < a.length; i++) {  //gå igjennom listen igjen
                if (a[i] % 2 == 1) {       //sjekke om verdien i listen er et oddetall
                    temp = a[teller];       //sette temp lik a på plass teller, er 0 første gang.
                    a[teller] = a[i];       //1 runde: a[0]= a[0]; 2.
                    a[i] = temp;            //
                    teller++;
                }
            }
            if(oddetallTeller >0 && partallTeller>0 ){
                //gjør en utvalgssortering, hvor man bytter hvert tall med det minste foran.
                utvalgssortering(a, 0, oddetallTeller);//sorterer først halve listen fra posisjon 0- antall oddetall
                utvalgssortering(a, oddetallTeller, a.length); //sorterer så fra posisjon (siste oddetall)  til siste verdi.
            }
            else if(oddetallTeller>0){
                utvalgssortering(a, 0, oddetallTeller);//sorterer først halve listen fra posisjon 0- antall oddetall
                utvalgssortering(a, oddetallTeller, a.length);
            }
            else{
                utvalgssortering(a, 0, partallTeller);//sorterer først halve listen fra posisjon 0- antall oddetall
                utvalgssortering(a, partallTeller, a.length);
            }



        }

    }

     */

    //oppgave 4
    public static void delsortering(int[] a) {
        if (a.length == 0) {
            return;
        }
        int partallPlass = a.length-1; //partallPlass begynner bakerst
        int oddetallPlass = 0; //oddetallindexen begynner forerst.
        int temp; //midlertidig variabel.


        boolean fortsettByttePlass = true;
        for ( int i=0; fortsettByttePlass; i++)                                  // stopper nar venstre(oddetalsindex) > hoyre(partallsindex)
        {
            while ((oddetallPlass <= partallPlass) && ((a[oddetallPlass] % 2 == 1)||(a[oddetallPlass] % 2 == -1))) { //oddetall kan både være -1 og 1
                oddetallPlass++;   // partallPlass er stoppverdi for oddetalsindex
            }
            while ((oddetallPlass <= partallPlass) && (a[partallPlass] % 2 == 0)) {
                partallPlass--;  // oddetallPlass er stoppverdi for partallPlass
            }
            if (oddetallPlass < partallPlass) { //bytter plasser hvis oddetallplass er mindre enn partallplass.
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
        quickSort(a,partallPlass,a.length-1);
    }

    private static void quickSort(int[] a, int fra, int til) {
        if (fra < til) {
            int nyByttetVerdiIndex = byttPlass(a,fra,til);

            quickSort(a, fra, nyByttetVerdiIndex-1);
            quickSort(a,nyByttetVerdiIndex+1, til);
        }

    }

    private static int byttPlass(int[] a, int fra, int til) { //Hjelpefunksjon for quicksort i oppgave 4
        int vippeVerdi = a[til]; //Velger bakerste
        int i = fra-1;

        for (int j = fra; j < til; j++) {
            if (a[j] <= vippeVerdi) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        // Flytter vippeVerdi etter de som er mindre
        int temp = a[i+1];
        a[i+1] = a[til];
        a[til] = temp;

        return i+1;
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

        int tempL = a.length; // hjelpevariabel som er lengden til tabellen a
        char tempBok = a[a.length-1]; // // hjelpevariabel som er siste bokstaven i tabellen a

        // Kjøre en loop, som skal kjøre alle bokstavene ett steg til høyre i tabellen a
        for (int i=tempL-1; i>= 1; i-- ) {
            a[i] = a[i-1];
        }
        a[0] = tempBok;
    }

    ///// Oppgave 6 //////////////////////////////////////
    /*
    Her skal vi gå videre fra ​Oppgave​ 5. Hvis vi tenker oss at tabellen er «bøyd til en sirkel»,
    er det mer naturlig å se på dette som en rotasjon. Dermed kan vi «rotere» et valgfritt antall enheter.
    Lag metoden ​public​ ​static​ ​void​ ​rotasjon​(​char​[] a, ​int​ k)​ der ​k​ er et vilkårlig heltall. Hvis ​k​ = 1,
    skal metoden ha samme effekt som metoden i ​Oppgave​ 5. Hvis ​k​ er negativ, skal rotasjonen gå motsatt vei.
    En rotasjon i en tom tabell eller i en tabell med nøyaktig ett element er ingen feilsituasjon.
    Men rotasjonen vil da ikke endre noe. Det er ingen grense på størrelsen til ​k​. Målet er å gjøre metoden
    så effektiv som mulig. Følgende programbit viser hvordan metoden skal virke:

    ​char​[] a = {​'A'​,​'B'​,​'C'​,​'D'​,​'E'​,​'F'​,​'G'​,​'H'​,​'I'​,​'J'​};

    System.​out.​ println(Arrays.​toString​(a));
​    rotasjon(​ a,3); System.​out​.println(Arrays.​toString(​ a)); ​
    rotasjon(​ a,-2); System.​out​.println(Arrays.​toString(​ a));

    ​// Utskrift:
    [A, B, C, D, E, F, G, H, I, J]​ ​// originaltabellen
    [H, I, J, A, B, C, D, E, F, G]​ ​// en rotasjon på tre enheter mot høyre
    [J, A, B, C, D, E, F, G, H, I]​ ​// en rotasjon to enheter mot venstre
     */
    public static void rotasjon(char[] a, int k) {
        if (a.length < 2) { // hvis tabellen er tom eller kun har 1 tall skal den ikke gjøre noe, for da kan den ikke rotere noe tall
            return;
        }

        k = k % a.length; // vi ønsker modulusen, til negative nummer
        if (k < 0) {
            k += a.length;
        }

        // Kopierer tabellen a, og setter indexen lik som a
        char[] nyA = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            nyA[i] = a[i];
        }

        int tempIndex; // en midlertidig lagringsvariabel
        for (int i = 0; i < a.length; i++) { // kjører gjennom array a
            tempIndex = i+k; // setter midlertidlig index til i + k
            if (tempIndex < a.length) { // hvis indexen er positiv?
                a[tempIndex] = nyA[i];
            }
            else {
                a[tempIndex - a.length] = nyA[i]; // hvis indexen er negativ?
            }
        }

    }


    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        //lager hjelpe tabeller:
        String [] s1= s.split("(?<=.)");
        String [] t1= t.split("(?<=.)");
        int lengde=s1.length-1+t1.length-1;
        String [] nyString= new String[lengde];
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
    /*
    Oppgaven lager først en tom tabell som heter indexTabell. Denne har lik lengde som tabell a, men har ingen verdier.
    Så sjekker den om a er tom, hvis den er det skal den bare returnere den tomme arrayen
    Så lages en hjelpetabell som er en kopi av tabell a - både verdier og lengde/ indexer
    Og sorterer den vha den innebygde metoden sort
    Nå er tabellen sortert i stigende rekkefølge (minste verdi til størst)
    Så kjører den gjennom med forløkker

    Så, det som skjer:
    Den kjører gjennom tabellen tempA og ser på VERDIEN som ligger på 1.indexplass
    Så kjører den gjennom tabell a, for å finne SAMME VERDIEN som i tempA --> kjører igjennom for-løkken helt til den finner samme VERDI
    Når den endelig finner samme VERDI --> så utføres det inn i if-en:
    Da tar den 1.indexplass i den tomme tabellen indexTabell, og setter den lik som indexplassen i tabell a som hadde samme verdien som verdien i tempA sin 1.index
    - Hva er verdien på index 0 i tempA? --> 3
    - Hvor i tabell a ligger verdien 3? --> på index 6
    - Setter dermed index 0 i den tomme tabellen "indexTabell" LIK indexen i tabell "a".
    - Dette gjør den helt til den har sammenlignet alle verdiene i "tempA" og "a", og satt alle indexene inn i den tomme tabellen "indexTabell"
    Savvy?
     */
    public static int[] indekssortering(int[] a) {
        int[] indexTabell = new int[a.length]; // lager en tom tabell med like mange index-plasser som a har

        if (a.length == 0) {
            return indexTabell; // skal returnere en tom tabell om tabellen er tom
        }

        int[] tempA = Arrays.copyOf(a, a.length); // kopi av a som midlertidig hjelpetabell
        Arrays.sort(tempA); // sorterer denne

        for (int i = 0; i < tempA.length; i++) { // kjører gjennom tabellene med forløkker
            for (int j = 0; j < a.length; j++) {
                if (tempA[i] == a[j]) { // og hvis tempA sin index er lik a sin index
                    indexTabell[i] = j; // så setter den inn indexene fra tabell a inn i indexTabellen
                }
            }
        }
        return indexTabell; // og skriver ut tabellen indexTabell
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


