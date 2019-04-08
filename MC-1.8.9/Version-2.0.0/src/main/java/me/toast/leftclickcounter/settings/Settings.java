package me.toast.leftclickcounter.settings;

import java.io.*;
import net.minecraft.client.*;
import net.minecraftforge.common.config.*;

public class Settings
{
    private File saveFile;
    private int posX;
    private int posY;
    private int Clicks;
    private String Prefix;
    
    public Settings() {
        this.saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/LeftClickCounter.cfg");
        this.posX = 0;
        this.posY = 0;
        this.Clicks = 0;
        this.Prefix = "Left Clicks";
    }
    
    public int getposX() {
        return this.posX;
    }
    
    public void setposX(final int newposX) {
        this.posX = newposX;
    }
    
    public int getposY() {
        return this.posY;
    }
    
    public void setposY(final int newposY) {
        this.posY = newposY;
    }
    
    public int getClicks() {
        return this.Clicks;
    }
    
    public void setClicks(final int newClicks) {
        this.Clicks = newClicks;
    }
    
    public String getPrefix() {
        return this.Prefix;
    }
    
    public void setPrefix(final String newPrefix) {
        this.Prefix = newPrefix;
    }
    
    public void saveConfig() {
        final Configuration config = new Configuration(this.saveFile);
        this.updateConfig(config, false);
        config.save();
    }
    
    public void loadConfig() {
        final Configuration config = new Configuration(this.saveFile);
        config.load();
        this.updateConfig(config, true);
    }
    
    private void updateConfig(final Configuration config, final boolean load) {
        final Property prop = config.get("Position", "posX", 0);
        if (load) {
            this.posX = prop.getInt();
        }
        else {
            prop.setValue(this.posX);
        }
        final Property prop2 = config.get("Position", "posY", 0);
        if (load) {
            this.posY = prop2.getInt();
        }
        else {
            prop2.setValue(this.posY);
        }
        final Property prop3 = config.get("Global", "SHHH...", 0);
        if (load) {
            this.Clicks = prop3.getInt();
        }
        else {
            prop3.setValue(this.Clicks);
        }
        final Property prop4 = config.get("Global", "Prefix", "Left Clicks");
        if (load) {
            this.Prefix = prop4.getString();
        }
        else {
            prop4.setValue(this.Prefix);
        }
    }
}
