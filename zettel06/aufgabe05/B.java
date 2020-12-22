public class B extends A {
    public float x = 1.5f;
    public int y = 1;

    public B () { // Signatur: B()
        x++;
    }

    public B (float x) { // Signatur: B(F)
        super(x);
        super.y++;
    }

    public void f(int i, B o) { // Signatur: B.f(IB)
        System.out.println("B.f(IB)");
    }

    public void f(int i, A o) {  // Signatur: B.f(IA)
        System.out.println("B.f(IA)");
    }

    public void f(long lo, A o) {  // Signatur: B.f(LA)
        System.out.println("B.f(LA)");
    }
}
