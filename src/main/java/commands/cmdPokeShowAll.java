package commands;

import beans.Player;
import core.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdPokeShowAll implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getTextChannel().getName().equalsIgnoreCase("pokemon")) {
            String out = "```\n";
            for (Player p : Main.liP) {
                out += "User: " + p.name + "\n";
            }
            out += "```";
            event.getTextChannel().sendMessage(out).queue();
        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success ? "-showall wurde erfolgreich ausgeführt" : "-showall wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
