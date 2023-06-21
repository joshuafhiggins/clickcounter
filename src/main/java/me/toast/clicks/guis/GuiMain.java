package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;

import static me.toast.clicks.Utils.CheckForUpdates;

public class GuiMain extends GuiScreen {
    private GuiButton position;
    private GuiButton prefix;
    private GuiButton color;
    private GuiButton checkForUpdates;
    private GuiButton leftClicks;
    private GuiButton rightClicks;

    @Override
    public void initGui() {
        position = new GuiButton(0, width / 2 - 97, height / 2 - 50, "Position");
        prefix = new GuiButton(1, width / 2 - 97, height / 2 - 25, "Prefixes");
        color = new GuiButton(2, width / 2 - 97, height / 2, "Color");
        leftClicks = new GuiButton(3, width / 2 - 97, height / 2 + 25, "Show left clicks? " + Clicks.SETTINGS.getLeftEnabled());
        rightClicks = new GuiButton(4, width / 2 - 97, height / 2 + 50, "Show right clicks? " + Clicks.SETTINGS.getRightEnabled());
        checkForUpdates = new GuiButton(5, width / 2 - 97, height / 2 + 75, "Check for Updates");

        buttonList.add(position);
        buttonList.add(prefix);
        buttonList.add(color);
        buttonList.add(leftClicks);
        buttonList.add(rightClicks);
        buttonList.add(checkForUpdates);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();

        drawCenteredString(fontRendererObj, Clicks.NAME, width / 2, height / 2 - 125, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);

        if (button == position)
            mc.displayGuiScreen(new GuiPosition());
        if (button == prefix)
            mc.displayGuiScreen(new GuiPrefix());
        if (button == color)
            mc.displayGuiScreen(new GuiColor());

        if (button == leftClicks) {
            Clicks.SETTINGS.setLeftEnabled();
            leftClicks.displayString = "Show left clicks? " + Clicks.SETTINGS.getLeftEnabled();
        }

        if (button == rightClicks) {
            Clicks.SETTINGS.setRightEnabled();
            rightClicks.displayString = "Show right clicks? " + Clicks.SETTINGS.getRightEnabled();
        }

        if (button == checkForUpdates) {
            CheckForUpdates();
            mc.displayGuiScreen(null);
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
