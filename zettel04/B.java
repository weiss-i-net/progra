public class B {
    public static void main(String[] args) {
        B b = new B();

        b.a(Long.valueOf(100));       // a2, da Long -> double das
        b.a(Double.valueOf(100));     // a3, da passende Methode
        b.a(Integer.valueOf(100));    // a1

        double r1 = b.b(100D);        // b1
        int r2 = (int) b.b(100);      // error

        c(Integer.valueOf(100), "0"); // c3
        c(100L, "0");                 // c2
        c(100L, '0');                 // c1
    }

    public void a(int p) {
        System.out.println("a1");
    }

    public void a(double p) {
        System.out.println("a2");
    }

    public void a(Double p) {
        System.out.println("a3");
    }

    public int b(double p) {
        System.out.println("b1");
        return 0;
    }

    public double b(int p) {
        System.out.println("b2");
        return 0;
    }

    public static void c(Long p1, int p2) {
        System.out.println("c1");
    }

    public static void c(long p1, String p2) {
        System.out.println("c2");
    }

    public static void c(Long p1, String p2) {
        System.out.println("c3");
    }
}
