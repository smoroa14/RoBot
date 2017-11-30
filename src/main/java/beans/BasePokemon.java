package beans;

import java.io.Serializable;
import java.util.List;

public class BasePokemon implements Serializable {
    public String name;
    public int level;
    public AttackTyp typ;
    public List<Attack> liAttacks;

    public BasePokemon(String name, int level, AttackTyp typ, List<Attack> liAttacks) {
        this.name = name;
        this.level = level;
        this.typ = typ;
        this.liAttacks = liAttacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasePokemon that = (BasePokemon) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
