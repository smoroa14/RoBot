package beans;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable, Comparable<Player>{
    public String name;
    public String id;
    public List<Pokemon> liPok;

    public Player(String name, String id, List<Pokemon> liPok) {
        this.name = name;
        this.id = id;
        this.liPok = liPok;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (id != null ? !id.equals(player.id) : player.id != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (liPok != null ? liPok.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Player o) {
        return id.compareTo(o.id);
    }
}
