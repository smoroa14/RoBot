package core;

import commands.cmdHI;
import listeners.commandListener;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {

    private static JDABuilder builder;

    public static void main(String[] args) {
        builder = new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.ONLINE);

        addListerners();
        addCommands();

        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands()
    {
        commandHandler.commands.put("hi", new cmdHI());
    }

    private static void addListerners()
    {
        builder.addEventListener(new readyListener());
        builder.addEventListener(new commandListener());
    }
}
