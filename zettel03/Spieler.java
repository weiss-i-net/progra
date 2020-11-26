public class Spieler {

    Karte[] kartenhand;
    String name;
    double siegesquote;

    Spieler(String init_name, double init_siegesquote) {
        name = init_name;
        siegesquote = init_siegesquote;
    }

    public String toString() {
        return name;
    }

    public static Spieler besterSpieler(Spieler... club) {
        Spieler outBesterSpieler = club[0];
        for (Spieler s : club)
            if (outBesterSpieler.siegesquote < s.siegesquote)
                outBesterSpieler = s;
        return outBesterSpieler;
    }

    public void kannBedienen(Karte k) {
        System.out.println(k.bedienbar(kartenhand) ?
                                this + " kann bedienen!" :
                                this + " kann nicht bedienen!");
    }

    public static void main(String[] args) {

        Spieler[] spielGruppe = { new Spieler("Elisabeth", 37.5 ),
                                  new Spieler("Klaus",     12.5 ),
                                  new Spieler("Helmut",    38.75),
                                  new Spieler("Erwin",     11.25) };

        Spieler besterSpielerSpielGruppe = Spieler.besterSpieler(spielGruppe);

        besterSpielerSpielGruppe.kartenhand = new Karte[] { Karte.neueKarte("HERZ", "SIEBEN"),
                                                            Karte.neueKarte("HERZ", "NEUN"  ),
                                                            Karte.neueKarte("KARO", "KOENIG") };

        besterSpielerSpielGruppe.kannBedienen(Karte.neueKarte("KARO", "BUBE"));

    }
}


