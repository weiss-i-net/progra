public class Karte {

    enum Farbe { KREUZ, PIK, HERZ, KARO }

    enum Wert { SIEBEN, ACHT, NEUN,   ZEHN,
                BUBE,   DAME, KOENIG, ASS }

    public Wert kartenWert;
    public Farbe kartenFarbe;

    Karte(Farbe initFarbe, Wert initWert) {
        kartenWert = initWert;
        kartenFarbe = initFarbe;
    }

    public String toString() {
        return this.kartenFarbe.toString() + this.kartenWert.toString();
    }

    public static Karte neueKarte(String f, String w) {
        return new Karte(Farbe.valueOf(f), Wert.valueOf(w));
    }

    public static int kombinationen() {
        return Farbe.values().length * Wert.values().length;
    }

    public static Karte[] skatblatt() {
        Karte[] outSkatblatt = new Karte[Karte.kombinationen()];
        int i = 0;
        for (Farbe f : Farbe.values())
            for (Wert w : Wert.values()) {
                outSkatblatt[i] = new Karte(f, w);
                ++i;
            }
        return outSkatblatt;
    }

    public boolean bedient(Karte other) {
        return this.kartenWert  == other.kartenWert
            || this.kartenFarbe == other.kartenFarbe
            || this.kartenWert  == Wert.BUBE;
    }

    public boolean bedienbar(Karte... karten) {
        for (Karte currKarte : karten)
            if (currKarte.bedient(this))
                return true;
        return false;
    }

    public static void druckeEinbahnBedienungen() {
        Karte[] alleKarten = Karte.skatblatt();
        for (Karte karteA : alleKarten)
            for (Karte karteB : alleKarten)
                if (karteA.bedient(karteB) && !karteB.bedient(karteA))
                    System.out.println(karteA + " bedient " + karteB + ", aber "
                                     + karteB + " nicht " +   karteA + ".");
    }
}
