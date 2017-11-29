package commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.impl.MessageImpl;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class cmdImgur implements Command{

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        int width = 64;
        int height = 64;
        //create buffered image object img
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //file object
        File f = null;
        //create random image pixel by pixel
        for(int y = 0; y < height; y+=4){
            for(int x = 0; x < width; x+=4){
                int a = (int)(Math.random()*256); //alpha
                int r = (int)(Math.random()*256); //red
                int g = (int)(Math.random()*256); //green
                int b = (int)(Math.random()*256); //blue

                int p = (a<<24) | (r<<16) | (g<<8) | b; //pixel

                img.setRGB(x, y, p);
                img.setRGB(x+1, y+0, p);
                img.setRGB(x+0, y+1, p);
                img.setRGB(x+1, y+1, p);
            }
        }
        //write image
        try{
            f = new File("Z:\\Image\\Output.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }




        event.getTextChannel().sendFile(f, null).queue();
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println(success?"-img wurde erfolgreich ausgeführt":"-img wurde nicht erfolgreich ausgeführt");
    }

    @Override
    public String help() {
        return "leer";
    }
}
