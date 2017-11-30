package commands;

import beans.BasePokemon;
import beans.Player;
import beans.Pokemon;
import core.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.List;

public class cmdPokeStart implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getTextChannel().getName().equalsIgnoreCase("pokemon")) {
            String name = event.getMember().getNickname();
            if (name == null) name = event.getAuthor().getName();
            List<Pokemon> poks = new ArrayList<>();
            for (BasePokemon pok : Main.liPokes) {
                poks.add(new Pokemon(pok));
            }
            Player p = new Player(name, event.getAuthor().getId(), poks);
            if (!Main.liP.contains(p)) {
                Main.liP.add(p);
                event.getTextChannel().sendMessage("Account created").queue();
            } else {
                event.getTextChannel().sendMessage("Account not created").queue();
            }
            Main.save();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success ? "-start wurde erfolgreich ausgeführt" : "-start wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
