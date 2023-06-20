package me.toast.clicks;

import java.awt.*;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Settings {
    private final File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/Clicks.cfg");
    private int posX = 0;
    private int posY = 0;
    private int Clicks = 0;
    private String Prefix = "Left Clicks: ";
    private int color = Color.WHITE.getRGB();
    private boolean isChroma = false;
    private boolean hasBackground = false;

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getClicks() {
        return Clicks;
    }

    public String getPrefix() {
        return Prefix;
    }

    public int getColor() {
        return color;
    }

    public boolean getIsChroma() {
        return isChroma;
    }

    public boolean getIsBackground() {
        return hasBackground;
    }

    public void setPosX(int newPosX) {
        posX = newPosX;
        saveConfig();
    }

    public void setPosY(int newPosY) {
        posY = newPosY;
        saveConfig();
    }

    public void addClicks() {
        Clicks++;
        saveConfig();
    }

    public void setPrefix(String newPrefix) {
        Prefix = newPrefix;
        saveConfig();
    }

    public void setColor(int newColor) {
        color = newColor;
        saveConfig();
    }

    public void setIsChroma() {
        isChroma = !isChroma;
        saveConfig();
    }

    public void setHasBackground() {
        hasBackground = !hasBackground;
        saveConfig();
    }

    private void saveConfig() {
        Configuration config = new Configuration(saveFile);
        this.updateConfig(config, false);
        config.save();
    }

    public void loadConfig() {
        Configuration config = new Configuration(saveFile);
        config.load();
        this.updateConfig(config, true);
    }

    private void updateConfig(Configuration config, boolean load) {
        Property prop = config.get("Position", "PosX", 0);
        if (load) {
            this.posX = prop.getInt();
        } else {
            prop.setValue(this.posX);
        }

        Property prop1 = config.get("Position", "PosY", 0);
        if (load) {
            this.posY = prop1.getInt();
        } else {
            prop1.setValue(this.posY);
        }

        Property prop2 = config.get("Global", "Left Clicks", 0);
        if (load) {
            this.Clicks = prop2.getInt();
        } else {
            prop2.setValue(this.Clicks);
        }

        Property prop3 = config.get("Text", "Prefix", "Left Clicks: ");
        if (load) {
            this.Prefix = prop3.getString();
        } else {
            prop3.setValue(this.Prefix);
        }

        Property prop4 = config.get("Color", "Color", Color.WHITE.getRGB());
        if (load) {
            this.color = prop4.getInt();
        } else {
            prop4.setValue(this.color);
        }

        Property prop7 = config.get("Color", "IsChroma", false);
        if (load) {
            this.isChroma = prop7.getBoolean();
        } else {
            prop7.setValue(this.isChroma);
        }

        Property prop9 = config.get("Color", "HasBackground", false);
        if (load) {
            this.hasBackground = prop9.getBoolean();
        } else {
            prop9.setValue(this.hasBackground);
        }
    }
}
