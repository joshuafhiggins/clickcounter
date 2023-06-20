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

import static me.toast.clicks.Utils.GetCustomColor;
import static me.toast.clicks.Utils.TextFieldIntersect;

public class GuiColor extends GuiScreen {
    private GuiButton isChroma;
    private GuiButton isBackground;
    private GuiButton testNewColor;
    private GuiButton back;
    private GuiTextField red;
    private GuiTextField green;
    private GuiTextField blue;
    private Color testColor;

    @Override
    public void initGui() {
        super.initGui();
        isChroma = new GuiButton(0, width / 2 - 100, height / 2 + 25, "Chroma? " + Clicks.SETTINGS.getIsChroma());
        isBackground = new GuiButton(1, width / 2 - 100, height / 2 + 50, "Shadow? " + Clicks.SETTINGS.getIsBackground());
        testNewColor = new GuiButton(2, width / 2 - 100, height / 2 + 75, "Refresh Color");
        back = new GuiButton(3, width / 2 - 100, 0, "Go back");

        buttonList.add(testNewColor);
        buttonList.add(isChroma);
        buttonList.add(isBackground);
        buttonList.add(back);

        red = new GuiTextField(0, fontRendererObj, width / 2 + 15, (height / 2 - 70) - 50, 50, 25);
        red.setText("" + GetCustomColor().getRed());
        red.setMaxStringLength(3);

        green = new GuiTextField(1, fontRendererObj, width / 2 + 15, (height / 2 - 35) - 50, 50, 25);
        green.setText("" + GetCustomColor().getGreen());
        green.setMaxStringLength(3);

        blue = new GuiTextField(2, fontRendererObj, width / 2 + 15, (height / 2) - 50, 50, 25);
        blue.setText("" + GetCustomColor().getBlue());
        blue.setMaxStringLength(3);

        testColor = new Color(Clicks.SETTINGS.getColor());
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        red.drawTextBox();
        green.drawTextBox();
        blue.drawTextBox();

        drawCenteredString(fontRendererObj, "Test Color", width / 2, height / 2 + 125, testColor.getRGB());
        fontRendererObj.drawString("Red:", width / 2 - 13, (height / 2 - 62) - 50, -1);
        fontRendererObj.drawString("Green:", width / 2 - 25, (height / 2 - 27) - 50, -1);
        fontRendererObj.drawString("Blue:", width / 2 - 16, (height / 2 + 10) - 50, -1);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == isChroma) {
            Clicks.SETTINGS.setIsChroma();
            isChroma.displayString = "Chroma? " +Clicks.SETTINGS.getIsChroma();
        }
        if (button == isBackground) {
            Clicks.SETTINGS.setHasBackground();
            isBackground.displayString = "Shadow? " + Clicks.SETTINGS.getIsBackground();
        }

        if (button == testNewColor) {
            try {
                int redInt = Integer.parseInt(red.getText().replaceAll("[^0-9]", ""));
                int greenInt = Integer.parseInt(green.getText().replaceAll("[^0-9]", ""));
                int blueInt = Integer.parseInt(blue.getText().replaceAll("[^0-9]", ""));
                testColor = new Color(redInt, greenInt, blueInt);
            } catch (NumberFormatException e) {
                return;
            }
        }

        if (button == back)
            mc.displayGuiScreen(new GuiMain());

        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0) {
            red.setFocused(TextFieldIntersect(red, mouseX, mouseY));
            green.setFocused(TextFieldIntersect(green, mouseX, mouseY));
            blue.setFocused(TextFieldIntersect(blue, mouseX, mouseY));
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        boolean validKeys = keyCode == Keyboard.KEY_ESCAPE || keyCode == Keyboard.KEY_BACK || keyCode == Keyboard.KEY_0 || keyCode == Keyboard.KEY_1 || keyCode == Keyboard.KEY_2 || keyCode == Keyboard.KEY_3 || keyCode == Keyboard.KEY_4 || keyCode == Keyboard.KEY_5 || keyCode == Keyboard.KEY_6 || keyCode == Keyboard.KEY_7 || keyCode == Keyboard.KEY_8 || keyCode == Keyboard.KEY_9;
        if (!validKeys)
            return;

        if (red.isFocused()) {
            red.textboxKeyTyped(typedChar, keyCode);
        }

        if (green.isFocused()) {
            green.textboxKeyTyped(typedChar, keyCode);
        }

        if (blue.isFocused()) {
            blue.textboxKeyTyped(typedChar, keyCode);
        }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        int redInt = Integer.parseInt(red.getText().replaceAll("[^0-9]", ""));
        int greenInt = Integer.parseInt(green.getText().replaceAll("[^0-9]", ""));
        int blueInt = Integer.parseInt(blue.getText().replaceAll("[^0-9]", ""));

        if (redInt > 255 || greenInt > 255 || blueInt > 255) {
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Invalid number for one of the color channels! (Numbers can't be greater than 255)"));
        } else {
            Color color = new Color(redInt, greenInt, blueInt);
            Clicks.SETTINGS.setColor(color.getRGB());
        }

        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
