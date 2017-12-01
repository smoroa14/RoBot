package commands;

import beans.AttackTyp;
import beans.BasePokemon;
import beans.Player;
import beans.Pokemon;
import core.Main;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.Random;

public class cmdPokeAttack implements Command{

    private Random rand = new Random();

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        String id = event.getAuthor().getId();
        if(event.getTextChannel().getName().contains("pokemon")
                && Main.liP.contains(new Player("", id, null)))
        {
            Player you = Main.liP.get(Main.liP.indexOf(new Player("", id, null)));
            if(args.length==0 || !you.liPok.contains(new Pokemon(args[0], 0, AttackTyp.FEUER, null)))
            {
                event.getTextChannel().sendMessage("´´´\nBitte Namen vom Pokemon angeben das du besitzt!\n´´´").queue();
                return;
            }
            Pokemon deinPokemon = you.liPok.get(you.liPok.indexOf(new Pokemon(args[0], 0, AttackTyp.FEUER, null)));
            BasePokemon gegnerPokemon = Main.liPokes.get(rand.nextInt(Main.liPokes.size()));
            event.getTextChannel().sendMessage("´´´\nDu greifst mit "+deinPokemon.name+" das Pokemon "+gegnerPokemon.name+" an.\n´´´").queue();


        }else{
            event.getTextChannel().sendMessage("´´´\nfalse channel\n´´´").queue();
        }

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success?"-attack wurde erfolgreich ausgeführt":"-attack wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
