# Obligatorisk oppgave 2 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 

# Krav til innlevering

Se oblig-tekst for alle krav. Oppgaver som ikke oppfyller følgende vil ikke få godkjent:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* Ingen debug-utskrifter
* Alle testene som kreves fungerer (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet

# Arbeidsfordeling

Oppgaven er levert av følgende studenter:
* Martine Holmberg, s236808, s236808@oslomet.no
* Camilla Harirchi Carlsen, s197235, s197235@oslomet.no

Vi har brukt git til å dokumentere arbeidet vårt. Vi har <INSERT> commits totalt, og hver logg-melding beskriver det vi har gjort av endringer.

I oppgaven har vi hatt følgende arbeidsfordeling:
* Martine har gjort oppgave: 1, 2, 6, 7
* Camilla har gjort oppgave: 3, 4, 5, 8


# Beskrivelse av oppgaveløsning (maks 5 linjer per oppgave)

* Oppgave 1: (Lage en dobbelt lenket liste)
    - Oppretter først en ny node, p - som ikke har verdi eller forrige-/neste-pekere
    - Så kjører vi gjennom tabellen a - og hvis tabellen inneholder noen verdier så setter vi det inn i p-noden og peker hode-pekeren på p
        og plusser på 1.
    - Hvis det kun er 1 node i listen så peker vi både hale- og hode-pekeren på denne noden.
    - Men hvis det finnes flere enn 1 node i tabellen a (det er 2 nå) så må vi kjøre igjennom for å sette halen: vi oppretter en ny node q og setter
        denne til å være halen, og setter neste-peker fra p til å peke på q og forrige-peker fra q til å peke på p.

* Oppgave 2 a); (Skrive ut strenger med verdier)
    - Bruker StringBuilder til å bygge opp en tegnstreng.
    - Hvis listen er tom så returneres den tommelisten med tegnstrengen []
    - Hvis listne ikke er tom legger den til verdier vba .append, også går den bortover:
        så lenge det er en neste node i listen så legges det til ny verdi i den. 
    - Helt til neste-pekeren ikke lenger finner noen ny node.
    - Det samme gjøres på omvendtString - bare at da starter vi på halen og hopper bakover (forrige) og skriver ut listen baklengs.
    
* Oppgave 2 b): (Legge inn ny node)
    - Løste oppgaven ved å først lage en ny node p.
    - Hvis listen er tom så satte jeg både hode- og hale-pekeren til å peke på den ny noden p, og neste- og forrige-pekerne er satt lik null.
    - Hvis listen ikke er tom så settes p noden inn bakerst (etter hale med hale.neste = p), og setter denne noden som ny hale.
 
* Oppgave 3:
* Oppgave 4:
* Oppgave 5:
 
* Oppgave 6: (Fjerne verdi (og returnere true/ false) + returnere verdien på posisjon indeks)
    - Lager en hjelpenode kalt p igjen, som er den første i listen (hode). Så skal vi fjerne første, siste eller mellomste node:
        - Første: Da tar vi bort første node ved å sette p sin neste (nest første node) til å være nye hode og hode sin forrige lik null.
        - Siste: Da gjør vi noe ala det samme, bare at vi starter på halen (siste noden) og setter p sin forrige til å være den nye halen, 
            og hale.neste lik null.
        - Mellomste: For å få bort den mellomste så må vi sette neste- og forrige-pekerne slik at den hopper over denne noden. 
            Dette gjør vi ved å si at p sin forrige sin neste er den nye neste, og at p sin neste sin forrige er den nye forrige. 
            Da står noden i mellom der utenfor og Java fjerner den automatisk.
    - Når vi skal fjerne og returnere verdien gjør vi likt som på forrige, bare at vi returnerer verdien (på den indeksen) 
        i stedet for true eller false.
        
* Oppgave 7: (Tømme/ NULLe listen)
    - Måte 1: Kjører igjennom listen p ved å hoppe til p.neste og nuller ut neste node helt til vi har nullet ut alle noder.
        Til slutt settes hade og holde til null også, og Java fjerner alt.
    - Måte 2: Kjører igjennom listen q ved å hoppe til neste og bruker fjern-metoden til å fjerne noden 
        på indeks 0 (første noden) helt til listen er tom.

* Oppgave 8:




* Spørsmål til øvingen:
- Får feil på oppg 6 sin test, whyyy?
- Hvordan teste millisek på nullstill() (oppgave 7)?