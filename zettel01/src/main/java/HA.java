public class HA{

    public static void main (String[]args){


        String auswahl;
        double startbetrag;
        double zinssatz;
        double zielbetrag;
        double ergebnis;
        int jahr;
        double zwischenergebnis;


        startbetrag= SimpleIO.getDouble("Bitte geben Sie den Startbetrag ein"); //frage nach startbetrag

        zinssatz= SimpleIO.getDouble("Bitte geben Sie den Zinssatz ein"); //frage nach zinssatz

        auswahl= SimpleIO.getString("Bitte waehlen Sie aus: \n Ziel: Berechnet die Zeit , bis ein gegebener Betrag angespart wurde .\n Zeit : Berechnet den Betrag , der nach einer gegebenen Zeit angespart wurde .");
        // auswahlmögl. Ziel, Zeit als string

        ergebnis= startbetrag;

        if(auswahl.equals("ziel") || auswahl.equals("Ziel")){            // ist auswahl == ziel?

            zielbetrag= SimpleIO.getDouble("Bitte geben Sie den Zielbetrag ein");

            if (startbetrag>zielbetrag){                            // Fehler: startbetrag größer als zielbetrag
                SimpleIO.output("Kein gültiger Zielbetrag.");
                System.exit(0);
            }

            //zinssatz in Kommazahlmain
            jahr= 0;


            while(ergebnis<=zielbetrag){
                zwischenergebnis = (ergebnis * zinssatz) / (double)100;
                ergebnis= zwischenergebnis + ergebnis;
                jahr++;
            }



            String textausgabeziel_1 = " Es dauert "+jahr;
            String textausgabeziel_2 = " Jahre bei einem Zinssatz von "+ zinssatz;
            String textausgabeziel_3 = " % um von "+ startbetrag;                                                   //Ausgabe, die generiert wird durch die eingegebenen Werte
            String textausgabeziel_4 = " auf den Betrag " + zielbetrag;
            String textausgabeziel_5 = " zu sparen . Nach dieser Zeit hat man " + ergebnis;

            SimpleIO.output(textausgabeziel_1+textausgabeziel_2+textausgabeziel_3+textausgabeziel_4+textausgabeziel_5+".");
            System.exit(0);
        }
        else {
            if (auswahl.equals("zeit") || auswahl.equals("Zeit")){
                jahr = SimpleIO.getInt("Bitte geben Sie eine beliebige Anzahl von Jahren an.");

                if(jahr==0) //Fehler: jahr = 0
                {
                    SimpleIO.output("0 ist kein gültiges Jahr");
                    System.exit(0);
                }

                for(int i=1; i<=jahr; i++){
                    zwischenergebnis = (ergebnis*zinssatz)/(double)100;
                    ergebnis=(double)zwischenergebnis+ (double)ergebnis;

                }


                String textausgabezeit_1 = "Bei einem Zinssatz von " + zinssatz;
                String textausgabezeit_2 = " % und einem Startbetrag von "+ startbetrag;
                String textausgabezeit_3 = " hat man nach "+ jahr;
                String textausgabezeit_4 = " Jahren "+ ergebnis;
                SimpleIO.output(textausgabezeit_1+textausgabezeit_2+textausgabezeit_3+textausgabezeit_4+" gespart.");
                System.exit(0);
            }


        }

        SimpleIO.output("Sie haben eine ungültige Auswahl getätigt");
        System.exit(0);
    }
}
