package core;

import commands.Command;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

public class commandHandler {

    public static final commandParser parse = new commandParser();
    public static HashMap<String, Command> commands = new HashMap<>();

    public static void handlerCommand(commandParser.commandContainer cmd)
    {
        if(commands.containsKey(cmd.invoke.toLowerCase()))
        {
            boolean safe = !commands.get(cmd.invoke).called(cmd.args, cmd.event);

            if(safe)
            {
                try {
                    commands.get(cmd.invoke).action(cmd.args, cmd.event);
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }else{
                commands.get(cmd.invoke).executed(safe, cmd.event);
            }
        }
    }
}
