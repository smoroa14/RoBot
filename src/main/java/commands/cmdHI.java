package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class cmdHI implements Command {

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String name = event.getMember().getNickname();
        if(name == null)name = event.getAuthor().getName();
        event.getTextChannel().sendMessage("Hi " + name).queue();
        for (int i = 0; i < 10; i++) {
            event.getTextChannel().sendMessage(".ping").queue();

        }
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success?"-HI wurde erfolgreich ausgeführt":"-HI wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
