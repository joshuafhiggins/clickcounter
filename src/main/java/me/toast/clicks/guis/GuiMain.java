package me.toast.clicks.guis;

import me.toast.clicks.MainMod;
import me.toast.clicks.utils.UpdateDetection;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import java.io.IOException;

public class GuiMain extends GuiScreen
{
    public GuiButton position;
    public GuiButton prefix;
    public GuiButton color;
    public GuiButton checkForUpdates;

    public MainMod mod;
    public GuiMain(MainMod mod) {
            this.mod = mod;
        }

    @Override
    public void initGui() {
        position = new GuiButton(3, width / 2 - 97, height / 2 - 50, "Position");
        prefix = new GuiButton(2, width / 2 - 97, height / 2 - 25, "Prefixes");
        color = new GuiButton(1, width / 2 - 97, height / 2, "Color");
        checkForUpdates = new GuiButton(0, width / 2 - 97, height / 2 + 25, "Check For Updates");

        buttonList.add(position);
        buttonList.add(prefix);
        buttonList.add(color);
        buttonList.add(checkForUpdates);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        drawCenteredString(fontRendererObj, "Left Click Counter Mod", width / 2, height / 2 - 125, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (button == position)
            mc.displayGuiScreen(new GuiPosition(mod));
        if (button == prefix)
            mc.displayGuiScreen(new GuiPrefix(mod));
        if (button == color)
            mc.displayGuiScreen(new GuiColor(mod));

        if (button == checkForUpdates) {
            UpdateDetection.checkIfURLExists();
            mc.displayGuiScreen(null);
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) throws IOException {
        if (keyCode == Keyboard.KEY_E || keyCode == Keyboard.KEY_ESCAPE)
            mc.displayGuiScreen(null);

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public boolean doesGuiPauseGame() { return false; }
}
