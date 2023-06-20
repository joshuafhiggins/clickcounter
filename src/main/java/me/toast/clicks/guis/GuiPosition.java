package me.toast.clicks.guis;

import me.toast.clicks.MainMod;
import me.toast.clicks.utils.RainbowUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.awt.*;
import java.io.IOException;

public class GuiPosition extends GuiScreen {

    private String string;
    private int xPos;
    private int yPos;
    private int calculatedX;
    private boolean isFocused;

    private MainMod mod;
    public GuiPosition(MainMod mod) { this.mod = mod; }

    @Override
    public void initGui() {
        super.initGui();
        xPos = mod.getSettings().getposX();
        yPos = mod.getSettings().getposY();
        isFocused = false;
        string = mod.getSettings().getPrefix() + mod.getSettings().getSymbol() + mod.getSettings().getClicks();
        calculatedX = string.length() * 10;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        drawDefaultBackground();

        drawString(string, 0.75F);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if(mouseButton == 0 && mouseX >= xPos && mouseX <= xPos + calculatedX && mouseY >= yPos && mouseY <= yPos + 14) {
            isFocused = true;
            mc.thePlayer.addChatMessage(new ChatComponentText("Text Selected!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)));
        }

        if(isFocused && mouseButton == 1) {
            isFocused = false;
            mc.thePlayer.addChatMessage(new ChatComponentText("Saved Location!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
            mod.getSettings().setposX(mouseX);
            mod.getSettings().setposY(mouseY);
            xPos = mod.getSettings().getposX();
            yPos = mod.getSettings().getposY();
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    private void drawString(String string, float brightness) {
        for (int i = 0; i < string.length(); i++) {
            if (mod.getSettings().getIsChroma()) { mc.fontRendererObj.drawStringWithShadow(string, xPos, yPos, RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB()); }
            else { mc.fontRendererObj.drawStringWithShadow(string, xPos, yPos, CustomColor().getRGB()); }
        }
    }
    private Color CustomColor() { return new Color(mod.getSettings().getRed(), mod.getSettings().getGreen(), mod.getSettings().getBlue()); }
}
