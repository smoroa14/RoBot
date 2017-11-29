package listeners;

import core.commandHandler;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

public class commandListener extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message m = event.getMessage();

        if(m.getContent().startsWith(STATIC.PREFIX)
                && m.getAuthor().getId() != event.getJDA().getSelfUser().getId())
        {
            commandHandler.handlerCommand(commandHandler.parse.parse(m.getContent(), event));
        }

        super.onMessageReceived(event);
    }
}
