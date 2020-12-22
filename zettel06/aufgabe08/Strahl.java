public class Strahl extends Gerade
{
    private final Punkt f;


    public Strahl(Punkt a,Punkt b){
        super(a, b);
        this.f = a; //a.getx().compareTo(b.gety())==-1 || a.getx().compareTo(b.gety())==0 ? this.a : this.b;
    }

    public boolean startsFromp1(){
        return this.f == this.getp1();
    }

    public boolean startsFromp2(){
        return f == getp2();
    }

    public String toString(){
        return startsFromp2() ? "Der Strahl beginnt bei " +
                                getp2().toString() +
                                " und passiert " +
                                getp1().toString() :
        "Der Strahl beginnt bei " +
            getp1().toString() +
            " und passiert " +
            getp2().toString();
    }

    public Gerade verlaengern(){
        return new Gerade(getp1(), getp2());
    }

    public boolean enthaelt(Punkt p0){
        return startsFromp1() ? zwischenp1p2(p0) || hinterp2(p0) :
                                vorp1(p0) || zwischenp1p2(p0);
    }

    public boolean equals (Object obj){
        if (obj.getClass() == this.getClass()) {
            Strahl d = (Strahl) obj;
            if (verlaengern().equals(d.verlaengern()) && (d.startsFromp1() && startsFromp1() || d.startsFromp2() && startsFromp2()))
                return true;
        }
        return false;
    }

    public static void main (String [] args){
        Punkt z = new Punkt (3,6);
        Punkt u = new Punkt (4,5);
        Strahl s = new Strahl(z,u);
        System.out.println(s.toString());
    }
}
