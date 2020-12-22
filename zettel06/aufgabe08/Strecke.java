

public class Strecke extends Strahl
{
    
    public Strecke(Punkt a,Punkt b){
    super(a,b);
    
    }
    
    public String toString(){
        if (startsFromp2()){
    return "Die Strecke verläuft von Punkt " + this.a.toString() + " bis Punkt " + this.b.toString();

    }
 
    return "Die Strecke verläuft von Punkt " + this.b.toString() + " bis Punkt " + this.a.toString();

}

    protected Strahl verlaengern (boolean swap){
     if (swap== true){
        Punkt a = this.p1 ;
        Punkt b = this.p2 ;
        return new Strecke(a,b);
        }
        Punkt a = this.p2;
        Punkt b = this.p1 ;
        return new Strecke(a,b);
    }
     public static void main (String [] args){
        Punkt a = new Punkt (1,2 );
        Punkt b = new Punkt (1,3 );
        
         Strahl s1 = new Strahl (a,b);
        System.out.println(s1.toString());
        }
}