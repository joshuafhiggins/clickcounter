package me.toast.lcm.guis;

import me.toast.lcm.MainMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;

import java.awt.*;
import java.io.IOException;

public class GuiColor extends GuiScreen
{
    private GuiButton isChroma;
    private GuiButton isBackground;
    private GuiButton TestNewColor;
    private GuiButton back;
    private GuiTextField Red;
    private GuiTextField Green;
    private GuiTextField Blue;
    private Color TestColor;
    MainMod mod;

    public GuiColor(MainMod mod) { this.mod = mod; }

    @Override
    public void initGui()
    {
        super.initGui();
        isChroma = new GuiButton(0, width / 2 - 100, height / 2 + 25, "Is Chroma Enabled: " + mod.getSettings().getIsChroma());
        isBackground = new GuiButton(1, width / 2 - 100, height / 2 + 50, "Has Background Text: " + mod.getSettings().getIsBackground());
        TestNewColor = new GuiButton(2, width / 2 - 100, height / 2 + 75, "Refresh The Test Color");
        back = new GuiButton(3, width / 2 - 100, 0, "<---");
        buttonList.add(TestNewColor);
        buttonList.add(isChroma);
        buttonList.add(isBackground);
        buttonList.add(back);

        Red = new GuiTextField(0, fontRendererObj, width / 2 + 15, (height / 2 - 70) - 50, 50, 25);
        Red.setText("" + mod.getSettings().getRed());
        Red.setMaxStringLength(3);

        Green = new GuiTextField(1, fontRendererObj, width / 2 + 15, (height / 2 - 35) - 50, 50, 25);
        Green.setText("" + mod.getSettings().getGreen());
        Green.setMaxStringLength(3);

        Blue = new GuiTextField(2, fontRendererObj, width / 2 + 15, (height / 2) - 50, 50, 25);
        Blue.setText("" + mod.getSettings().getBlue());
        Blue.setMaxStringLength(3);

        TestColor = new Color(mod.getSettings().getRed(), mod.getSettings().getGreen(), mod.getSettings().getBlue());
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();

        Red.drawTextBox();
        Green.drawTextBox();
        Blue.drawTextBox();

        //isChroma.drawButton(mc, mouseX, mouseY);

        drawCenteredString(fontRendererObj, "Test String For Color", width / 2, height / 2 + 125, TestColor.getRGB());
        drawCenteredString(fontRendererObj, "After typing in your color RBG codes close the gui by pressing E or ESC and it will save it.", width / 2, height / 2 + 150, -1);
        drawCenteredString(fontRendererObj, "Make sure when pressing the 'Refresh The Test Color' button that you have numbers in the text boxes. Same goes for closing the gui or else the game will crash.", width / 2, height / 2 + 160, -1);
        fontRendererObj.drawString("Red:", width / 2 - 13, (height / 2 - 62) - 50, -1);
        fontRendererObj.drawString("Green:", width / 2 - 25, (height / 2 - 27) - 50, -1);
        fontRendererObj.drawString("Blue:", width / 2 - 16, (height / 2 + 10) - 50, -1);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == isChroma) {
            mod.getSettings().setIsChroma();
            mod.getSettings().saveConfig();
            buttonList.remove(isChroma);
            isChroma = new GuiButton(0, width / 2 - 100, height / 2 + 25, "Is Chroma Enabled: " + mod.getSettings().getIsChroma());
            buttonList.add(isChroma);
        }
        if (button == isBackground) {
            mod.getSettings().setIsBackground();
            mod.getSettings().saveConfig();
            buttonList.remove(isBackground);
            isBackground = new GuiButton(1, width / 2 - 100, height / 2 + 50, "Has Background Text: " + mod.getSettings().getIsBackground());
            buttonList.add(isBackground);
        }

        if (button == TestNewColor) {
            int redInt = Integer.parseInt(Red.getText().replaceAll("[^0-9]", ""));
            int greenInt = Integer.parseInt(Green.getText().replaceAll("[^0-9]", ""));
            int blueInt = Integer.parseInt(Blue.getText().replaceAll("[^0-9]", ""));
            TestColor = new Color(redInt, greenInt, blueInt);
        }

        if(button == back)
            mc.displayGuiScreen(new GuiMain(mod));
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        if (mouseButton == 0 && mouseX >= Red.xPosition && mouseX <= Red.xPosition + Red.width && mouseY >= Red.yPosition && mouseY <= Red.yPosition + Red.height) {
            Red.setFocused(true);
        } else { Red.setFocused(false); }

        if (mouseButton == 0 && mouseX >= Green.xPosition && mouseX <= Green.xPosition + Green.width && mouseY >= Green.yPosition && mouseY <= Green.yPosition + Green.height) {
            Green.setFocused(true);
        } else { Green.setFocused(false); }

        if (mouseButton == 0 && mouseX >= Blue.xPosition && mouseX <= Blue.xPosition + Blue.width && mouseY >= Blue.yPosition && mouseY <= Blue.yPosition + Blue.height) {
            Blue.setFocused(true);
        } else { Blue.setFocused(false);}

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (Red.isFocused()) {
            if (keyCode == Keyboard.KEY_0 || keyCode == Keyboard.KEY_1 || keyCode == Keyboard.KEY_2 || keyCode == Keyboard.KEY_3 || keyCode == Keyboard.KEY_4 || keyCode == Keyboard.KEY_5 || keyCode == Keyboard.KEY_6 || keyCode == Keyboard.KEY_7 || keyCode == Keyboard.KEY_8 || keyCode == Keyboard.KEY_9) {
                Red.textboxKeyTyped(typedChar, keyCode);
            } else if (keyCode == Keyboard.KEY_BACK) {
                Red.textboxKeyTyped(typedChar, keyCode);
            }
        }

        if (Green.isFocused()) {
            if (keyCode == Keyboard.KEY_0 || keyCode == Keyboard.KEY_1 || keyCode == Keyboard.KEY_2 || keyCode == Keyboard.KEY_3 || keyCode == Keyboard.KEY_4 || keyCode == Keyboard.KEY_5 || keyCode == Keyboard.KEY_6 || keyCode == Keyboard.KEY_7 || keyCode == Keyboard.KEY_8 || keyCode == Keyboard.KEY_9) {
                Green.textboxKeyTyped(typedChar, keyCode);
            } else if (keyCode == Keyboard.KEY_BACK) {
                Green.textboxKeyTyped(typedChar, keyCode);
            }
        }

        if (Blue.isFocused()) {
            if (keyCode == Keyboard.KEY_0 || keyCode == Keyboard.KEY_1 || keyCode == Keyboard.KEY_2 || keyCode == Keyboard.KEY_3 || keyCode == Keyboard.KEY_4 || keyCode == Keyboard.KEY_5 || keyCode == Keyboard.KEY_6 || keyCode == Keyboard.KEY_7 || keyCode == Keyboard.KEY_8 || keyCode == Keyboard.KEY_9) {
                Blue.textboxKeyTyped(typedChar, keyCode);
            } else if (keyCode == Keyboard.KEY_BACK) {
                Blue.textboxKeyTyped(typedChar, keyCode);
            }
        }

        if (keyCode == Keyboard.KEY_E || keyCode == Keyboard.KEY_ESCAPE) { mc.displayGuiScreen(null); }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        int redInt = Integer.parseInt(Red.getText().replaceAll("[^0-9]", ""));
        if (redInt > 255) {
            mod.getSettings().setRed(255);
            mod.getSettings().saveConfig();
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You foolish mortal have entered a invalid number for the color parameters! (Can't enter numbers that are greater than 255!)"));
        } else {
            mod.getSettings().setRed(redInt);
            mod.getSettings().saveConfig();
        }

        int greenInt = Integer.parseInt(Green.getText().replaceAll("[^0-9]", ""));
        if (greenInt > 255) {
            mod.getSettings().setGreen(255);
            mod.getSettings().saveConfig();
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You foolish mortal have entered a invalid number for the color parameters! (Can't enter numbers that are greater than 255!)"));
        } else {
            mod.getSettings().setGreen(greenInt);
            mod.getSettings().saveConfig();
        }

        int blueInt = Integer.parseInt(Blue.getText().replaceAll("[^0-9]", ""));
        if (blueInt > 255) {
            mod.getSettings().setBlue(255);
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You foolish mortal have entered a invalid number for the color parameters! (Can't enter numbers that are greater than 255!)"));
        } else {
            mod.getSettings().setBlue(blueInt);
        }

        super.onGuiClosed();
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
