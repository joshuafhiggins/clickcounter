package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

import java.io.IOException;

import static me.toast.clicks.Utils.DrawText;
import static me.toast.clicks.Utils.TextIntersect;

public class GuiPosition extends GuiScreen {
    private String leftText;
    private String rightText;
    private int leftXPos;
    private int leftYPos;
    private int rightXPos;
    private int rightYPos;
    private boolean leftIsFocused;
    private boolean rightIsFocused;
    private GuiButton back;

    @Override
    public void initGui() {
        leftXPos = Clicks.SETTINGS.getLeftPos()[0];
        leftYPos = Clicks.SETTINGS.getLeftPos()[1];

        rightXPos = Clicks.SETTINGS.getRightPos()[0];
        rightYPos = Clicks.SETTINGS.getRightPos()[1];

        leftIsFocused = false;
        rightIsFocused = false;

        leftText = Clicks.SETTINGS.getLeftPrefix() + Clicks.SETTINGS.getLeftClicks();
        rightText = Clicks.SETTINGS.getRightPrefix() + Clicks.SETTINGS.getRightClicks();

        back = new GuiButton(3, width / 2 - 100, 0, "Go back");
        buttonList.add(back);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);

        DrawText(fontRendererObj, leftText, leftXPos, leftYPos,
                Clicks.SETTINGS.getLeftColor(),
                Clicks.SETTINGS.getLeftChroma(),
                Clicks.SETTINGS.getLeftShadow());

        DrawText(fontRendererObj, rightText, rightXPos, rightYPos,
                Clicks.SETTINGS.getRightColor(),
                Clicks.SETTINGS.getRightChroma(),
                Clicks.SETTINGS.getRightShadow());
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int mouseButton, long timeSinceLastClick) {
        super.mouseClickMove(mouseX, mouseY, mouseButton, timeSinceLastClick);

        if (mouseButton != 0)
            return;

        if (leftIsFocused) {
            leftXPos = mouseX;
            leftYPos = mouseY;
            return;
        }

        if (rightIsFocused) {
            rightXPos = mouseX;
            rightYPos = mouseY;
            return;
        }

        if (TextIntersect(leftText, leftXPos, leftYPos, mouseX, mouseY)) {
            leftIsFocused = true;
            mc.thePlayer.addChatMessage(new ChatComponentText("Text Selected!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)));
            return;
        }

        if (TextIntersect(rightText, rightXPos, rightYPos, mouseX, mouseY)) {
            rightIsFocused = true;
            mc.thePlayer.addChatMessage(new ChatComponentText("Text Selected!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GOLD)));
            //return;
        }

    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        if (leftIsFocused) {
            leftIsFocused = false;
            mc.thePlayer.addChatMessage(new ChatComponentText("Saved Location!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
            Clicks.SETTINGS.setLeftPos(mouseX, mouseY);
            leftXPos = mouseX;
            leftYPos = mouseY;
        }

        if (rightIsFocused) {
            rightIsFocused = false;
            mc.thePlayer.addChatMessage(new ChatComponentText("Saved Location!").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.DARK_GREEN)));
            Clicks.SETTINGS.setRightPos(mouseX, mouseY);
            rightXPos = mouseX;
            rightYPos = mouseY;
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
}
