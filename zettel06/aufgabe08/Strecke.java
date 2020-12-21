class Strecke extends Strahl {

    public Strecke(Punkt start, Punkt end) {
        super(start, end);
    }

    public boolean startsFromp1() {
        return true;
    }

    public boolean startsFromp2() {
        return true;
    }

    public String toString() {
        return   "Strecke von " + getPointA()
               + " nach "       + getPointB();
    }

    // TODO
    // in pdf: verlängern() muss nicht überschrieben werden, da damit dann zu einer Geraden
    //         verlängert werden kann. (Die Methode wird überladen, nicht überschrieben)

    public Strahl verlaengern(boolean swap) {
        return swap ? new Strahl(getPointA(), getPointB()) :
                      new Strahl(getPointB(), getPointA());
    }

    public boolean enthaelt(Punkt p0) {
        return zwischenp1p2(p0);
    }

    public boolean equals(Object obj) {
        return    getClass() == obj.getClass()
               && getPointA().equals(((Strecke) obj).getPointA())
               && getPointB().equals(((Strecke) obj).getPointB());
    }

    // TODO
    // in pdf: getStart() und getDir() müssen nicht überschrieben werden, da sie private sind und man
    //         somit von Strecke nicht darauf zugreifen kann.
}


// TODO
// in pdf: Aufgabe 8 i)
//
//         1. Object.getClass aus Strecke.equals:34, Aufruf einer öffentlichen Methode einer Überklasse
//         2. Object.getClass aus Strecke.equals:34, Aufruf einer öffenlichen Methode der eigenen Klasse
//         3. Gerade.getPointA aus Strecke.equals:35, Aufruf einer öffentlichen Methode einer Überklasse
//         4. Point.equals aus Strecke.equals:35, Aufruf einer öffentlichen Methode der eigenen Klasse
//         5. Object.getClass aus Punkt.equals:33, Aufruf einer öffentlichen Methode einer Überklasse
//         6. Object.getClass aus Punkt.equals:33, Aufruf einer öffenlichen Methode der eigenen Klasse
//         7. BigDecimalUtility.equalValues aus Punkt.equals:32, Aufruf einer öffentlichen statischen Methode einer anderen Klasse
//         8. bigDecimal.scale aus BigDecimalUtility:8, Aufruf einer öffentlichen Methode der eigenen Klasse
