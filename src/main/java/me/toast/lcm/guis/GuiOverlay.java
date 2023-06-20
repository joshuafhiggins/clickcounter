package me.toast.lcm.guis;

import me.toast.lcm.MainMod;
import me.toast.lcm.utils.RainbowUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;

public class GuiOverlay extends Gui {

    private MainMod mod;
    private Minecraft mc;
    FontRenderer fr;

    public GuiOverlay(Minecraft mc, MainMod mod) {
        this.mod = mod;
        this.mc = mc;
        fr = mc.fontRendererObj;

        drawString(mod.getSettings().getPrefix() + mod.getSettings().getSymbol() + mod.getSettings().getClicks(), 0.75F);
    }

    private void drawString(String string, float brightness) {
        for (int i = 0; i < string.length(); i++) {
            if (mc.theWorld != null && mc.currentScreen == null) {
                if (mod.getSettings().getIsChroma()) { fr.drawString(string, mod.getSettings().getposX(), mod.getSettings().getposY(), RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB(), mod.getSettings().getIsBackground()); }
                else { fr.drawString(string, mod.getSettings().getposX(), mod.getSettings().getposY(), CustomColor().getRGB(), mod.getSettings().getIsBackground()); }
            }
        }
    }

    private Color CustomColor() { return new Color(mod.getSettings().getRed(), mod.getSettings().getGreen(), mod.getSettings().getBlue()); }
}
