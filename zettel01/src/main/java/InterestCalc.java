import java.util.Arrays;

public class InterestCalc {
    private static double getMoney(double min_money) {
        double money = SimpleIO.getDouble("Bitte geben Sie den Betrag ein.\n");
        while (money < min_money)
            money = SimpleIO.getDouble("Bitte versuchen Sie es erneut mit einem Betrag größer als "
                                       + String.format("%.2f", min_money));
        return money;
    }

    private static double getInterest() {
        double percent = SimpleIO.getDouble("Bitte geben Sie den Zinssatz als Prozentwert ein.\n");
        while (percent <= 0)
            percent = SimpleIO.getDouble("Bitte geben Sie ein Prozentwert > 0 an.\n");
        return 1 + percent/100;
    }

    private static boolean getModeIsTime() {
        String mode_string = SimpleIO.getString("Bitte waehlen Sie aus:\n"
                + "Ziel: Berechnet die Zeit, bis ein gegebener Betrag angespart wurde.\n"
                + "Zeit: Berechnet den Betrag , der nach einer gegebenen Zeit angespart wurde.\n");
        while (!Arrays.asList("Ziel", "Zeit").contains(mode_string))
            mode_string = SimpleIO.getString("Bitte geben Sie entweder \"Ziel\" oder \"Zeit\" ein.\n");
        return mode_string.equals("Ziel") ? false : true;
    }

    private static int getTimeInYears() {
        int time = SimpleIO.getInt("Bitte geben Sie den zu berechnenden Zeitraum in Jahren ein.");
        while (time < 0)
            time = SimpleIO.getInt("Bitte geben Sie eine positive Zahl ein.");
        return time;
    }

    public static void main(String[] args) {
        double init_money = getMoney(0);
        double intrest_rate = getInterest();
        boolean mode_is_time = getModeIsTime();

        double curr_money = init_money;

        if (mode_is_time) {

            int max_year = getTimeInYears();
            for (int year = 1; year <= max_year; ++year)
                curr_money *= intrest_rate;

            SimpleIO.output("Nach " + max_year + " Jahren mit einem Zinzsatz von "
                            + String.format("%.2f", (intrest_rate - 1)*100) + "% hat man "
                            + String.format("%.2f", curr_money) + "€.");

        } else {

            double aim_money = getMoney(init_money);
            int year = 0;
            while (curr_money < aim_money) {
                curr_money *= intrest_rate;
                ++year;
            }

            SimpleIO.output("Es dauert " + year + " Jahre bei einem Zinssatz von "
                    + String.format("%.2f", (intrest_rate - 1)*100) + "%, um von "
                    + String.format("%.2f", init_money) + "€ auf den Betrag "
                    + String.format("%.2f", aim_money) + "€ zu sparen.\nNach dieser Zeit hat man "
                    + String.format("%.2f", curr_money) + "€.");
        }
    }
}
