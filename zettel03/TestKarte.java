public class TestKarte {
    public static void main(String[] args) {
        Karte a = Karte.neueKarte("HERZ", "ACHT");
        System.out.println(a);
        assert (a.toString().equals("HERZACHT"));

        System.out.println(Karte.kombinationen());
        assert (Karte.kombinationen() == 4*8);

        for (Karte k : Karte.skatblatt())
            System.out.print(k + ", ");
        System.out.print("\b\b\n");
        assert (Karte.skatblatt().length == Karte.kombinationen());

        System.out.println(a.bedient(Karte.neueKarte("HERZ", "ASS")));
        assert (a.bedient(Karte.neueKarte("HERZ", "ASS")));
        assert (!a.bedient(Karte.neueKarte("KREUZ", "ASS")));

        System.out.println(a.bedienbar(Karte.skatblatt()));
        assert (a.bedienbar(Karte.skatblatt()));
        assert (!a.bedienbar(Karte.neueKarte("KARO", "SIEBEN"), new Karte(Karte.Farbe.PIK, Karte.Wert.ZEHN)));

        Karte.druckeEinbahnBedienungen();
    }
}
