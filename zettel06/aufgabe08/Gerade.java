import java.math.*;

public class Gerade
{
   protected final  Punkt p1;
   protected final  Punkt p2;
   
   
   public Punkt getp1(){
    return this.p1;
    
    }
    
    public Punkt getp2(){
    return this.p2;
    
    }
    public Gerade(Punkt p1, Punkt p2){
        if (p1.equals(p2)){
            Fehler_gleichePunkte();
            this.p1 = null;
            this.p2 = null;
        }
        else{
            this.p1 = p1;
            this.p2 = p2;
        }

    
    }
    
    private void Fehler_gleichePunkte(){
    System.out.println("Fehler: ungültige Eingabe.");
    }
    
    
    public String toString(){
    return "Gerade geht durch " + p1.toString() + " und " + p2.toString();   
    }
    
    protected boolean zwischenp1p2 (Punkt p0){
        if (BigDecimalUtility.equalValues(this.p1.abstand(this.p2), p0.abstand(this.p1).add(p0.abstand(this.p2))) 
        || p0==this.p1 || p0==this.p2) {
            
            return true;
    }
        return false;
    }
    
    protected boolean vorp1(Punkt p0){
        Gerade t = new Gerade(this.p1, this.p2);
        BigDecimal a = p0.abstand(this.p1) ;
        BigDecimal b = p0.abstand(this.p2) ; 
        if(!t.zwischenp1p2(p0) && a.compareTo(b)==-1 && 
        BigDecimalUtility.equalValues(p0.abstand(this.p2), p0.abstand(this.p1).add(p1.abstand(this.p2)))
        ){
        return true;
        }
    return false;
    }
    
    protected boolean hinterp2(Punkt p0){
    Gerade t = new Gerade(this.p1, this.p2);
    BigDecimal a = p0.abstand(this.p1) ;
    BigDecimal b = p0.abstand(this.p2) ; 
    if(t.vorp1(p0)==false && t.zwischenp1p2(p0)==false  && a.compareTo(b)==1 &&
    BigDecimalUtility.equalValues(this.p1.abstand(p0), this.p1.abstand(this.p2).add(this.p2.abstand(p0))
    )){
        return true;
    }
        return false;
    }
    protected boolean enthaelt(Punkt p0){
    Gerade t = new Gerade(this.p1, this.p2);
    if (t.zwischenp1p2(p0) || t.hinterp2(p0) || t.vorp1(p0)) {
    return true;
    }
    return false;
    }
    
    protected boolean enthaelt(Object obj){
    Gerade t = new Gerade(this.p1, this.p2); 
    if(obj.getClass().equals(t.getClass())){
        Gerade d = (Gerade) obj;
        if(d.enthaelt(t.getp1()) &&
        d.enthaelt(t.getp2())    ||
        t.enthaelt(d.getp1())   &&
        t.enthaelt(d.getp2())
        ){
            return true;
        }   
    }

    return false;
    }
    
     public static void main (String [] args){
        Punkt o1 = new Punkt(1,1);
        Punkt o2 = new Punkt (2,2);
        Gerade u = new Gerade (o1,o2);
        Punkt o0= new Punkt (3,4);
        Gerade t = new Gerade (o2, o0);
        System.out.println(u.enthaelt(t));
     }
}
