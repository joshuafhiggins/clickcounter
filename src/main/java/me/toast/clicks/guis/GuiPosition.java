package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;

import static me.toast.clicks.Utils.GetCustomColor;
import static me.toast.clicks.Utils.RainbowEffect;

public class GuiPosition extends GuiScreen {
    private String string;
    private int xPos;
    private int yPos;
    private int calculatedX;
    private boolean isFocused;
    private GuiButton back;

    @Override
    public void initGui() {
        super.initGui();
        xPos = Clicks.SETTINGS.getLeftPos()[0];
        yPos = Clicks.SETTINGS.getLeftPos()[1];
        isFocused = false;
        string = Clicks.SETTINGS.getLeftPrefix() + Clicks.SETTINGS.getLeftClicks();
        calculatedX = string.length() * 10;
        back = new GuiButton(3, width / 2 - 100, 0, "Go back");
        buttonList.add(back);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawString(string, 0.75F);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int mouseButton, long timeSinceLastClick) {
        if (mouseButton != 0) {
            super.mouseClickMove(mouseX, mouseY, mouseButton, timeSinceLastClick);
            return;
        }

        if (!isFocused && mouseX >= xPos && mouseX <= xPos + calculatedX && mouseY >= yPos && mouseY <= yPos + 14) {
            isFocused = true;
            mc.thePlayer.addChatMessage(new ChatComponentText("Text Selected!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)));
        }

        if (isFocused) {
            xPos = mouseX;
            yPos = mouseY;
        }

        super.mouseClickMove(mouseX, mouseY, mouseButton, timeSinceLastClick);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        if (isFocused) {
            isFocused = false;
            mc.thePlayer.addChatMessage(new ChatComponentText("Saved Location!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
            Clicks.SETTINGS.setLeftPos(mouseX, mouseY);
            xPos = mouseX;
            yPos = mouseY;
        }

        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button == back)
            mc.displayGuiScreen(new GuiMain());

        super.actionPerformed(button);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    private void drawString(String string, float brightness) {
        for (int i = 0; i < string.length(); i++) {
            if (Clicks.SETTINGS.getLeftChroma()) { mc.fontRendererObj.drawStringWithShadow(string, xPos, yPos, RainbowEffect(i * 3500000L, brightness, 250).getRGB()); }
            else { mc.fontRendererObj.drawStringWithShadow(string, xPos, yPos, GetCustomColor().getRGB()); }
        }
    }
}
