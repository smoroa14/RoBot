package beans;

import java.io.Serializable;
import java.util.List;

public class Pokemon extends BasePokemon implements Serializable{

    public Pokemon(String name, int level, AttackTyp typ, List<Attack> liAttacks) {
        super(name, level, typ, liAttacks);
    }

    public Pokemon(BasePokemon b) {
        super(b.name, b.level, b.typ, b.liAttacks);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
