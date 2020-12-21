import java.math.*;

class Test {
    public static void main(String[] args) {
        Punkt a = new Punkt(1, 2);
        Punkt b = new Punkt(new BigDecimal(2), new BigDecimal(3));
        assert a.abstand(b).doubleValue() > 1.4;
        assert !a.equals(b);

        Gerade A = new Gerade(a, b);
        Gerade B = new Gerade(new Punkt(3, 4), new Punkt(1.5, 2.5));

        assert A.equals(B);

        Strahl C = new Strahl(a, b);
        Strahl D = new Strahl(b, a);
        assert !C.equals(D);

        Strecke E = new Strecke(a, b);
        assert !E.enthaelt(new Punkt(3, 4));
        assert D.equals(E.verlaengern(false));
        assert !E.equals(A);


    }
}

