class Gerade {
    final private Punkt p1, p2;

    public Gerade(Punkt initP1, Punkt initP2) {
        if (initP1.equals(initP2)) {
            System.out.println("Ungültige Eingabe (Konstruktor Gerade): Die Punkte müssen unterschiedlich sein.");
            p1 = null;
            p2 = null;
            return;
        }

        if (initP2.isLexicoGreaterThen(initP1)) {
            p1 = initP1;
            p2 = initP2;
        } else {
            p1 = initP2;
            p2 = initP1;
        }
    }

    public Punkt getPointA() {
        return p1;
    }

    public Punkt getPointB() {
        return p2;
    }

    public String toString() {
        return "Gerade durch " + p1 + " und " + p2;
    }

    protected boolean zwischenp1p2(Punkt p0) {
        return p1.abstand(p0).add(p0.abstand(p2)).equals(p1.abstand(p2));
    }

    protected boolean vorp1(Punkt p0) {
        return p0.abstand(p1).add(p1.abstand(p2)).equals(p0.abstand(p2));
    }

    protected boolean nachp2(Punkt p0) {
        return p1.abstand(p2).add(p2.abstand(p0)).equals(p1.abstand(p0));
    }

    public boolean enthaelt(Punkt p0) {
        return vorp1(p0) || zwischenp1p2(p0) || nachp2(p0);
    }

    public boolean equals(Object obj) {
        return    getClass() == obj.getClass()
               && enthaelt(((Gerade) obj).getPointA())
               && enthaelt(((Gerade) obj).getPointB());
    }
}
