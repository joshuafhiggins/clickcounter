package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

import static me.toast.clicks.Utils.DrawText;
import static me.toast.clicks.Utils.TextFieldIntersect;

public class GuiColor extends GuiScreen {
    private GuiButton leftChroma;
    private GuiButton leftShadow;
    private GuiTextField leftRed;
    private GuiTextField leftGreen;
    private GuiTextField leftBlue;
    private Color leftTestColor;

    private GuiButton rightChroma;
    private GuiButton rightShadow;
    private GuiTextField rightRed;
    private GuiTextField rightGreen;
    private GuiTextField rightBlue;
    private Color rightTestColor;

    private GuiButton back;


    @Override
    public void initGui() {
        leftChroma = new GuiButton(0, width / 2 - 110, height / 2 + 25, 100, 20, "Chroma? " + Clicks.SETTINGS.getLeftChroma());
        leftShadow = new GuiButton(1, width / 2 - 110, height / 2 + 50, 100, 20, "Shadow? " + Clicks.SETTINGS.getLeftShadow());
        buttonList.add(leftChroma);
        buttonList.add(leftShadow);

        rightChroma = new GuiButton(3, width / 2 + 30, height / 2 + 25, 100, 20, "Chroma? " + Clicks.SETTINGS.getRightChroma());
        rightShadow = new GuiButton(4, width / 2 + 30, height / 2 + 50, 100, 20, "Shadow? " + Clicks.SETTINGS.getRightShadow());
        buttonList.add(rightChroma);
        buttonList.add(rightShadow);

        back = new GuiButton(6, width / 2 - 100, 0, "Go back");
        buttonList.add(back);

        leftTestColor = new Color(Clicks.SETTINGS.getLeftColor());
        leftRed = new GuiTextField(0, fontRendererObj, width / 2 - 55, (height / 2 - 70) - 50, 50, 25);
        leftRed.setText("" + leftTestColor.getRed());
        leftRed.setMaxStringLength(3);
        leftGreen = new GuiTextField(1, fontRendererObj, width / 2 - 55, (height / 2 - 35) - 50, 50, 25);
        leftGreen.setText("" + leftTestColor.getGreen());
        leftGreen.setMaxStringLength(3);
        leftBlue = new GuiTextField(2, fontRendererObj, width / 2 - 55, (height / 2) - 50, 50, 25);
        leftBlue.setText("" + leftTestColor.getBlue());
        leftBlue.setMaxStringLength(3);

        rightTestColor = new Color(Clicks.SETTINGS.getRightColor());
        rightRed = new GuiTextField(0, fontRendererObj, width / 2 + 45, (height / 2 - 70) - 50, 50, 25);
        rightRed.setText("" + rightTestColor.getRed());
        rightRed.setMaxStringLength(3);
        rightGreen = new GuiTextField(1, fontRendererObj, width / 2 + 45, (height / 2 - 35) - 50, 50, 25);
        rightGreen.setText("" + rightTestColor.getGreen());
        rightGreen.setMaxStringLength(3);
        rightBlue = new GuiTextField(2, fontRendererObj, width / 2 + 45, (height / 2) - 50, 50, 25);
        rightBlue.setText("" + rightTestColor.getBlue());
        rightBlue.setMaxStringLength(3);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        leftRed.drawTextBox();
        leftGreen.drawTextBox();
        leftBlue.drawTextBox();
        DrawText(fontRendererObj, "Test Color", width / 2 - 55, height / 2 + 75, leftTestColor.getRGB(), Clicks.SETTINGS.getLeftChroma(), Clicks.SETTINGS.getLeftShadow());
        fontRendererObj.drawString("Red:", width / 2 - 13 - 70, (height / 2 - 62) - 50, -1);
        fontRendererObj.drawString("Green:", width / 2 - 25 - 70, (height / 2 - 27) - 50, -1);
        fontRendererObj.drawString("Blue:", width / 2 - 16 - 70, (height / 2 + 10) - 50, -1);
        drawCenteredString(fontRendererObj, "Left clicks", width / 2 - 60, height / 2 - 150, -1);

        rightRed.drawTextBox();
        rightGreen.drawTextBox();
        rightBlue.drawTextBox();
        DrawText(fontRendererObj, "Test Color", width / 2 + 45, height / 2 + 75, rightTestColor.getRGB(), Clicks.SETTINGS.getRightChroma(), Clicks.SETTINGS.getRightShadow());
        fontRendererObj.drawString("Red:", width / 2 - 13 + 35, (height / 2 - 62) - 50, -1);
        fontRendererObj.drawString("Green:", width / 2 - 25 + 35, (height / 2 - 27) - 50, -1);
        fontRendererObj.drawString("Blue:", width / 2 - 16 + 35, (height / 2 + 10) - 50, -1);
        drawCenteredString(fontRendererObj, "Right clicks", width / 2 + 60, height / 2 - 150, -1);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == leftChroma) {
            Clicks.SETTINGS.setLeftChroma();
            leftChroma.displayString = "Chroma? " + Clicks.SETTINGS.getLeftChroma();
        }
        if (button == leftShadow) {
            Clicks.SETTINGS.setLeftShadow();
            leftShadow.displayString = "Shadow? " + Clicks.SETTINGS.getLeftShadow();
        }

        if (button == rightChroma) {
            Clicks.SETTINGS.setRightChroma();
            rightChroma.displayString = "Chroma? " + Clicks.SETTINGS.getRightChroma();
        }
        if (button == rightShadow) {
            Clicks.SETTINGS.setRightShadow();
            rightShadow.displayString = "Shadow? " + Clicks.SETTINGS.getRightShadow();
        }

        if (button == back)
            mc.displayGuiScreen(new GuiMain());

        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0) {
            leftRed.setFocused(TextFieldIntersect(leftRed, mouseX, mouseY));
            leftGreen.setFocused(TextFieldIntersect(leftGreen, mouseX, mouseY));
            leftBlue.setFocused(TextFieldIntersect(leftBlue, mouseX, mouseY));

            rightRed.setFocused(TextFieldIntersect(rightRed, mouseX, mouseY));
            rightGreen.setFocused(TextFieldIntersect(rightGreen, mouseX, mouseY));
            rightBlue.setFocused(TextFieldIntersect(rightBlue, mouseX, mouseY));
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        boolean validKeys = keyCode == Keyboard.KEY_ESCAPE || keyCode == Keyboard.KEY_BACK || keyCode == Keyboard.KEY_0 || keyCode == Keyboard.KEY_1 || keyCode == Keyboard.KEY_2 || keyCode == Keyboard.KEY_3 || keyCode == Keyboard.KEY_4 || keyCode == Keyboard.KEY_5 || keyCode == Keyboard.KEY_6 || keyCode == Keyboard.KEY_7 || keyCode == Keyboard.KEY_8 || keyCode == Keyboard.KEY_9;
        if (!validKeys)
            return;

        if (leftRed.isFocused())
            leftRed.textboxKeyTyped(typedChar, keyCode);
        if (leftGreen.isFocused())
            leftGreen.textboxKeyTyped(typedChar, keyCode);
        if (leftBlue.isFocused())
            leftBlue.textboxKeyTyped(typedChar, keyCode);

        if (rightRed.isFocused())
            rightRed.textboxKeyTyped(typedChar, keyCode);
        if (rightGreen.isFocused())
            rightGreen.textboxKeyTyped(typedChar, keyCode);
        if (rightBlue.isFocused())
            rightBlue.textboxKeyTyped(typedChar, keyCode);

        try {
            int redInt = Integer.parseInt(leftRed.getText());
            int greenInt = Integer.parseInt(leftGreen.getText());
            int blueInt = Integer.parseInt(leftBlue.getText());
            leftTestColor = new Color(redInt, greenInt, blueInt);
        } catch (NumberFormatException e) {
            return;
        }

        try {
            int redInt = Integer.parseInt(rightRed.getText());
            int greenInt = Integer.parseInt(rightGreen.getText());
            int blueInt = Integer.parseInt(rightBlue.getText());
            rightTestColor = new Color(redInt, greenInt, blueInt);
        } catch (NumberFormatException e) {
            return;
        }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        int leftRed = Integer.parseInt(this.leftRed.getText());
        int leftGreen = Integer.parseInt(this.leftGreen.getText());
        int leftBlue = Integer.parseInt(this.leftBlue.getText());

        int rightRed = Integer.parseInt(this.rightRed.getText());
        int rightGreen = Integer.parseInt(this.rightGreen.getText());
        int rightBlue = Integer.parseInt(this.rightBlue.getText());

        if (leftRed > 255 || leftGreen > 255 || leftBlue > 255
                || rightRed > 255 || rightGreen > 255 || rightBlue > 255) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid number for a color channel! (Numbers can't be greater than 255)"));
        } else {
            Color leftColor = new Color(leftRed, leftGreen, leftBlue);
            Clicks.SETTINGS.setLeftColor(leftColor.getRGB());
            Color rightColor = new Color(rightRed, rightGreen, rightBlue);
            Clicks.SETTINGS.setRightColor(rightColor.getRGB());
        }

        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
