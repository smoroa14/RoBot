package beans;

import java.io.Serializable;

public class Attack implements Serializable {
    public String name;
    public int staerke;
    public int genauigkeit;
    public int ap;
    public int minLevel;
    public AttackTyp typ;

    public Attack(String name, int staerke, int genauigkeit, int ap, int minLevel, AttackTyp typ) {
        this.name = name;
        this.staerke = staerke;
        this.genauigkeit = genauigkeit;
        this.ap = ap;
        this.minLevel = minLevel;
        this.typ = typ;
    }
}
