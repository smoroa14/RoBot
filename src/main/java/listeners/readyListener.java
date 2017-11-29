package listeners;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class readyListener extends ListenerAdapter{

    private static TextChannel tc;

    @Override
    public void onReady(ReadyEvent event) {

        for (Guild g : event.getJDA().getGuilds()) {
            try {
                tc = g.getTextChannelsByName("bot", false).get(0);
                //g.getTextChannelsByName("bot", false).get(0).sendMessage("-----------------------------------ONLY FOR BOTS-------------------------------------------").queue();
                tc.getMessageById(tc.getLatestMessageId()).queue();
                System.out.println("message");
            }catch (Exception e)
            {

            }
        }

        super.onReady(event);
    }
}
