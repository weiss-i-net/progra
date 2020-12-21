import java.math.*;

class Punkt {
    final private BigDecimal x, y;

    public Punkt(BigDecimal initX, BigDecimal initY) {
        x = initX;
        y = initY;
    }

    public Punkt(double initX, double initY) {
        this(new BigDecimal(initX), new BigDecimal(initY));
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public BigDecimal abstand(Punkt other) {
        return BigDecimalUtility.sqrt(     x.subtract(other.x).pow(2)
                                      .add(y.subtract(other.y).pow(2)));
    }

    public boolean equals(Object obj) {
        return getClass() == obj.getClass()
               && BigDecimalUtility.equalValues(x, ((Punkt) obj).x)
               && BigDecimalUtility.equalValues(y, ((Punkt) obj).y);
    }

    public boolean isLexicoGreaterThen(Punkt other) {
        return x.equals(other.x) ?
                   y.compareTo(other.y) == 1:
                   x.compareTo(other.x) == 1;
    }
}
