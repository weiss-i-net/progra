public class A {
    public static int x = 0;
    public int y = 7;

    public A () { // Signatur: A()
        this(x);
        x++;
    }

    public A (int x) { // Signatur: A(I)
        x = x + 2;
        y = y - x;
    }

    public A (double x) { // Signatur: A(D)
        y += x;
    }

    public void f(int i, A o) {  // Signatur: A.f(IA)
        System.out.println("A.f(IA)");
    }

    public void f(Long lo, A o) {  // Signatur: A.f(LA)
        System.out.println("A.f(LA)");
    }

    public void f(double d, A o) {  // Signatur: A.f(DA)
        System.out.println("A.f(DA)");
    }
}
