package core;

import beans.Attack;
import beans.AttackTyp;
import beans.BasePokemon;
import beans.Player;
import commands.*;
import listeners.commandListener;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.SECRETS;

import javax.security.auth.login.LoginException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static JDABuilder builder;
    public static List<Player> liP = new ArrayList<>();
    public static List<BasePokemon> liPokes = new ArrayList<>();

    public static void save()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "\\res\\obj.obj"))) {
            oos.writeObject(liP);
            oos.writeObject(liPokes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "\\res\\obj.obj")))
        {
            liP = (List<Player>) ois.readObject();
            liPokes = (List<BasePokemon>) ois.readObject();
        } catch (Exception e) {
            List<Attack> att = new ArrayList<>();
            att.add(new Attack("TestAttack1", 10, 100, 10, 1, AttackTyp.FEUER));
            att.add(new Attack("TestAttack2", 10, 100, 10, 1, AttackTyp.ERDE));
            att.add(new Attack("TestAttack3", 10, 100, 10, 1, AttackTyp.WASSER));
            liPokes.add(new BasePokemon("Test1", 1, AttackTyp.FEUER, att));
            liPokes.add(new BasePokemon("Test2", 2, AttackTyp.ERDE, att));
        }


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

        System.out.println("aaaaaaaaaaaaaaaa----------------------------");

        save();
    }

    public static void addCommands()
    {
        commandHandler.commands.put("hi", new cmdHI());
        commandHandler.commands.put("img", new cmdImgur());
        commandHandler.commands.put("attack", new cmdPokeAttack());
        commandHandler.commands.put("start", new cmdPokeStart());
        commandHandler.commands.put("showall", new cmdPokeShowAll());
        commandHandler.commands.put("info", new cmdPokeInfoPlayer());
    }

    private static void addListerners()
    {
        builder.addEventListener(new readyListener());
        builder.addEventListener(new commandListener());
    }
}
