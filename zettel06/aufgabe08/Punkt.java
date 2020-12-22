import java.math.*;


public class Punkt 
{
  private final BigDecimal x;
  private final BigDecimal y;
  
  public BigDecimal getx(){
    return this.x;
  }
    
  public BigDecimal gety(){
    return this.y;
  }
    
    public Punkt (BigDecimal x,BigDecimal y){
    this.x = x;
    this.y = y;
    
    }
    
    public Punkt (double x, double y){
        
    this(new BigDecimal(x),new BigDecimal(y));  
    }
    
    public String toString(){
    return "(" + this.x + "," + this.y + ")";
    }
    
    public BigDecimal abstand(Punkt other){
       BigDecimal x1 = this.x;
       BigDecimal y1 = this.y;
       BigDecimal x2 = other.getx();
       BigDecimal y2 = other.gety();
       
       BigDecimal u = x2.subtract(x1).multiply(x2.subtract(x1));
       BigDecimal v = y2.subtract(y1).multiply(y2.subtract(y1));
       return BigDecimalUtility.sqrt(u.add(v));
  
    }
    
    public boolean equals (Object obj){
    if(obj instanceof Punkt && 
    BigDecimalUtility.equalValues(this.y,((Punkt) obj).gety()) &&
    BigDecimalUtility.equalValues(this.x, ((Punkt) obj).getx())){
        return true; 
        }
    return false;
    }
    
    
    public static void main (String [] args){
  
        Punkt z = new Punkt(-4,2);
        Punkt d = new Punkt (4,2);
        Punkt t = new Punkt (7.3,4.751);
        System.out.println(d.equals(z));
        System.out.println(d.abstand(z));
        System.out.println(d.abstand(t));
    }
    
    
}
