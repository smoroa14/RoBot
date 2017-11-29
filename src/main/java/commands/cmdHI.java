package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdHI implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("HI").queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("-HI wurde ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
