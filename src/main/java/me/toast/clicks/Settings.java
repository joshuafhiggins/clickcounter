package me.toast.clicks;

import java.awt.*;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

public class Settings {
    private final File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/Clicks.cfg");

    private int[] leftPos = { 0, 0 };
    private int leftClicks = 0;
    private String leftPrefix = "Left Clicks: ";
    private int leftColor = Color.WHITE.getRGB();
    private boolean leftChroma = false;
    private boolean leftShadow = false;

    public int[] getLeftPos() {
        return leftPos;
    }

    public int getLeftClicks() {
        return leftClicks;
    }

    public String getLeftPrefix() {
        return leftPrefix;
    }

    public int getLeftColor() {
        return leftColor;
    }

    public boolean getLeftChroma() {
        return leftChroma;
    }

    public boolean getLeftShadow() {
        return leftShadow;
    }

    public void setLeftPos(int newPosX, int newPosY) {
        leftPos[0] = newPosX;
        leftPos[1] = newPosY;
        saveConfig();
    }

    public void incrementLeftClick() {
        leftClicks++;
        saveConfig();
    }

    public void setLeftPrefix(String newPrefix) {
        leftPrefix = newPrefix;
        saveConfig();
    }

    public void setLeftColor(int newColor) {
        leftColor = newColor;
        saveConfig();
    }

    public void setLeftChroma() {
        leftChroma = !leftChroma;
        saveConfig();
    }

    public void setLeftShadow() {
        leftShadow = !leftShadow;
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
        if (load) {
            leftPos = config.get("Left", "Position", new int[]{ 0, 0 }).getIntList();
            leftClicks = config.get("Left", "Clicks", 0).getInt();
            leftPrefix = config.get("Left", "Prefix", "Left Clicks: ").getString();
            leftColor = config.get("Left", "Color", Color.WHITE.getRGB()).getInt();
            leftChroma = config.get("Left", "Chroma", false).getBoolean();
            leftShadow = config.get("Left", "Shadow", true).getBoolean();
        } else {
            config.get("Left", "Position", new int[]{ 0, 0 }).setValues(leftPos);
            config.get("Left", "Clicks", 0).setValue(leftClicks);
            config.get("Left", "Prefix", "Left Clicks: ").setValue(leftPrefix);
            config.get("Left", "Color", Color.WHITE.getRGB()).setValue(leftColor);
            config.get("Left", "Chroma", false).setValue(leftChroma);
            config.get("Left", "Shadow", true).setValue(leftShadow);
        }
    }
}
