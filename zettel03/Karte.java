

public class Karte
{
    public enum Farbe {KREUZ, PIK, HERZ, KARO}
    public enum Wert {SIEBEN, ACHT, NEUN, ZEHN, BUBE, DAME, KÖNIG, ASS}

    public Farbe farbe;
    public Wert wert;

    //public Karte(Farbe farbe, Wert wert)
    //{
        //Karte(farbe,wert);
    //}

    public String toString(){
        return farbe.toString() + wert.toString();
    }


    public static Karte neueKarte(Farbe f, Wert w){
        Karte neueKarte = new Karte();
        neueKarte.farbe = f;
        neueKarte.wert = w;

        return neueKarte;
    }

    public static Karte neueKarte(String f, String w){
        return neueKarte(Farbe.valueOf(f), Wert.valueOf(w));
    }

    public static int kombination(){
        return Farbe.values().length*Wert.values().length;
    }

    public static Karte[] skatblatt() {



}
