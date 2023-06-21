package me.toast.clicks;

import java.awt.*;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

public class Settings {
    private final File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/Clicks.cfg");

    private boolean leftEnabled = true;
    private int[] leftPos = { 0, 0 };
    private int leftClicks = 0;
    private String leftPrefix = "Left Clicks: ";
    private int leftColor = Color.WHITE.getRGB();
    private boolean leftChroma = false;
    private boolean leftShadow = true;

    private boolean rightEnabled = true;
    private int[] rightPos = { 0, 50 };
    private int rightClicks = 0;
    private String rightPrefix = "Right Clicks: ";
    private int rightColor = Color.WHITE.getRGB();
    private boolean rightChroma = false;
    private boolean rightShadow = true;

    public boolean getLeftEnabled() {
        return leftEnabled;
    }

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

    public void setLeftEnabled() {
        leftEnabled = !leftEnabled;
        saveConfig();
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

    public boolean getRightEnabled() {
        return rightEnabled;
    }

    public int[] getRightPos() {
        return rightPos;
    }

    public int getRightClicks() {
        return rightClicks;
    }

    public String getRightPrefix() {
        return rightPrefix;
    }

    public int getRightColor() {
        return rightColor;
    }

    public boolean getRightChroma() {
        return rightChroma;
    }

    public boolean getRightShadow() {
        return rightShadow;
    }

    public void setRightEnabled() {
        rightEnabled = !rightEnabled;
        saveConfig();
    }

    public void setRightPos(int newPosX, int newPosY) {
        rightPos[0] = newPosX;
        rightPos[1] = newPosY;
        saveConfig();
    }

    public void incrementRightClick() {
        rightClicks++;
        saveConfig();
    }

    public void setRightPrefix(String newPrefix) {
        rightPrefix = newPrefix;
        saveConfig();
    }

    public void setRightColor(int newColor) {
        rightColor = newColor;
        saveConfig();
    }

    public void setRightChroma() {
        rightChroma = !rightChroma;
        saveConfig();
    }

    public void setRightShadow() {
        rightShadow = !rightShadow;
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
            leftEnabled = config.get("Left", "Enabled", true).getBoolean();
            leftPos = config.get("Left", "Position", new int[]{ 0, 0 }).getIntList();
            leftClicks = config.get("Left", "Clicks", 0).getInt();
            leftPrefix = config.get("Left", "Prefix", "Left Clicks: ").getString();
            leftColor = config.get("Left", "Color", Color.WHITE.getRGB()).getInt();
            leftChroma = config.get("Left", "Chroma", false).getBoolean();
            leftShadow = config.get("Left", "Shadow", true).getBoolean();

            rightEnabled = config.get("Right", "Enabled", true).getBoolean();
            rightPos = config.get("Right", "Position", new int[]{ 0, 50 }).getIntList();
            rightClicks = config.get("Right", "Clicks", 0).getInt();
            rightPrefix = config.get("Right", "Prefix", "Right Clicks: ").getString();
            rightColor = config.get("Right", "Color", Color.WHITE.getRGB()).getInt();
            rightChroma = config.get("Right", "Chroma", false).getBoolean();
            rightShadow = config.get("Right", "Shadow", true).getBoolean();
        } else {
            config.get("Left", "Enabled", true).setValue(leftEnabled);
            config.get("Left", "Position", new int[]{ 0, 0 }).setValues(leftPos);
            config.get("Left", "Clicks", 0).setValue(leftClicks);
            config.get("Left", "Prefix", "Left Clicks: ").setValue(leftPrefix);
            config.get("Left", "Color", Color.WHITE.getRGB()).setValue(leftColor);
            config.get("Left", "Chroma", false).setValue(leftChroma);
            config.get("Left", "Shadow", true).setValue(leftShadow);

            config.get("Right", "Enabled", true).setValue(rightEnabled);
            config.get("Right", "Position", new int[]{ 0, 50 }).setValues(rightPos);
            config.get("Right", "Clicks", 0).setValue(rightClicks);
            config.get("Right", "Prefix", "Right Clicks: ").setValue(rightPrefix);
            config.get("Right", "Color", Color.WHITE.getRGB()).setValue(rightColor);
            config.get("Right", "Chroma", false).setValue(rightChroma);
            config.get("Right", "Shadow", true).setValue(rightShadow);
        }
    }
}
