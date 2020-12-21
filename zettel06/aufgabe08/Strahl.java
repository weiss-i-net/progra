class Strahl extends Gerade {
    private final boolean startsFromP1;

    public Strahl(Punkt start, Punkt dir) {
        super(start, dir);
        startsFromP1 = dir.isLexicoGreaterThen(start);
    }

    public boolean startsFromp1() {
        return startsFromP1;
    }

    public boolean startsFromp2() {
        return !startsFromP1;
    }

    public String toString() {
        return   "Strahl von " + getStart()
               + " durch "     + getDir();
    }

    public Gerade verlaengern() {
        return new Gerade(getPointA(), getPointB());
    }
    // TODO:
    // In pdf: Es ist nicht möglich die neue Grade über die Attribute von Strahl zu verändern,
    //         da die verwendeten Punkte zwar identisch sind, aber nicht veränderbar sind, da
    //         sie 'final' sind (und die BigDecimal Werte der Punkte ebenfalls final sind).

    public boolean enthaelt(Punkt p0) {
        return startsFromP1 ?
                   zwischenp1p2(p0) && nachp2(p0) :
                   vorp1(p0)        && zwischenp1p2(p0);
    }

    public boolean equals(Object obj) {
        return    getClass() == obj.getClass()
               && getStart().equals(((Strahl) obj).getStart())
               && enthaelt(((Strahl) obj).getDir());
    }

    private Punkt getStart() {
        return startsFromP1 ? getPointA() : getPointB();
    }

    private Punkt getDir() {
        return startsFromP1 ? getPointB() : getPointA();
    }
}
