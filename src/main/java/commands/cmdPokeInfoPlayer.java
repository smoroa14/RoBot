package commands;

import beans.Attack;
import beans.Player;
import beans.Pokemon;
import core.Main;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPokeInfoPlayer implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        System.out.println(event.getTextChannel().getName());
        if (event.getTextChannel().getName().equalsIgnoreCase("pokemon") && args.length >= 1) {
            String id = null;
            for (Member m : event.getGuild().getMembers()) {
                String name = m.getNickname();
                if (name == null) name = m.getUser().getName();
                if (name.equalsIgnoreCase(args[0])) {
                    id = m.getUser().getId();
                }
            }
            Player p = null;
            for (Player player : Main.liP) {
                if (player.id.equalsIgnoreCase(id)) {
                    p = player;
                }
            }
            if (p != null) {
                String out = "```\n";
                out += "User: " + p.name + "\n";
                for (Pokemon poke : p.liPok) {
                    out += "Name: " + poke.name + "\n";
                    out += "  Level: " + poke.level + "\n";
                    out += "  Typ: " + poke.typ + "\n";
                    for (Attack a : poke.liAttacks) {
                        out += "    Name: " + a.name + "\n";
                        out += "    --Typ: " + a.typ + "\n";
                        out += "    --Stärke: " + a.staerke + "\n";
                        out += "    --Gen: " + a.genauigkeit + "\n";
                        out += "    --Angriffspoints: " + a.ap + "\n";
                    }
                }
                out += "```";
                event.getTextChannel().sendMessage(out).queue();
            } else {
                event.getTextChannel().sendMessage("```\nFalse Player\n```").queue();
            }
        } else {
            event.getTextChannel().sendMessage("```\nFalse Channel\n```").queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success ? "-infoPlayer wurde erfolgreich ausgeführt" : "-infoPlayer wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
