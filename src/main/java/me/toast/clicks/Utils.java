package me.toast.clicks;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiTextField;

import java.awt.*;

public class Utils {

    public static void DrawClicks() {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.theWorld == null || mc.currentScreen != null)
            return;

        Settings cfg = Clicks.SETTINGS;
        FontRenderer fr = mc.fontRendererObj;
        String leftText = cfg.getLeftPrefix() + cfg.getLeftClicks();
        String rightText = cfg.getRightPrefix() + cfg.getRightClicks();

        if (cfg.getLeftEnabled()) {
            DrawText(fr, leftText,
                    cfg.getLeftPos()[0],
                    cfg.getLeftPos()[1],
                    cfg.getLeftColor(),
                    cfg.getLeftChroma(),
                    cfg.getLeftShadow());
        }

        if (cfg.getRightEnabled()) {
            DrawText(fr, rightText,
                    cfg.getRightPos()[0],
                    cfg.getRightPos()[1],
                    cfg.getRightColor(),
                    cfg.getRightChroma(),
                    cfg.getRightShadow());
        }
    }

    public static void DrawText(FontRenderer fr, String text, int x, int y, int color, boolean chroma, boolean shadow) {
        if (chroma) {
            for (int i = 0; i < text.length(); i++) {
                fr.drawString(text, x, y, RainbowEffect(i * 3500000L, 0.75F, 250).getRGB(), shadow);
            }
        } else {
            fr.drawString(text, x, y, color, shadow);
        }
    }

    public static Color RainbowEffect(long offset, float brightness, int speed) {
        float hue = (float) (System.nanoTime() + (offset * speed)) / 1.0E10F % 1.0F;
        long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, brightness, 1F)), 16);
        Color c = new Color((int) color);
        return new Color(c.getRed()/255.0F, c.getGreen()/255.0F, c.getBlue()/255.0F, c.getAlpha()/255.0F);
    }

    public static boolean TextFieldIntersect(GuiTextField field, int mouseX, int mouseY) {
        return mouseX >= field.xPosition
                && mouseX <= field.xPosition + field.width
                && mouseY >= field.yPosition
                && mouseY <= field.yPosition + field.height;
    }

    public static boolean TextIntersect(String text, int xPos, int yPos, int mouseX, int mouseY) {
        return mouseX >= xPos && mouseX <= xPos + (text.length() * 10) && mouseY >= yPos && mouseY <= yPos + 14;
    }

    public static void CheckForUpdates() {
        return; //TODO
    }
}
