public class C {
    public static void main (String [] args) {
        // a)
        A a1 = new A(5); // (1)
        System.out.println (A.x);
        System.out.println (a1.y);
        A a2 = new A(); // (2)
        System.out.println (A.x);
        System.out.println (a2.y);
        B b = new B(); // (3)
        System.out.println (A.x);
        System.out.println (b.x);
        System.out.println (((A) b).y);
        System.out.println (b.y);
        A ab = new B(3); // (4)
        System.out.println (ab.y);
        System.out.println (((B) ab).y);
        // b)
        int i = 1;
        long l = 2;
        double d = 3.0;
        a1.f(i, a1); // (1)
        a1.f(l, ab); // (2)
        b.f(i, (B) ab); // (3)
        b.f(d, ab); // (4)
        ab.f(i, a1); // (5)
        ab.f(i, b); // (6)
    }
}
