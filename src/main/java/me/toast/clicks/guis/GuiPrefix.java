package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import java.io.IOException;

public class GuiPrefix extends GuiScreen {
    private GuiButton back;
    private GuiTextField prefixText;

    @Override
    public void initGui() {
        super.initGui();

        prefixText = new GuiTextField(0, fontRendererObj, width / 2 - 30, height / 2 - 45, 200, 25);
        prefixText.setText(Clicks.SETTINGS.getPrefix());

        back = new GuiButton(0, width / 2 - 100, 0, "Go back");

        buttonList.add(back);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawDefaultBackground();

        back.drawButton(mc, mouseX, mouseY);

        prefixText.drawTextBox();

        drawString(fontRendererObj, "Prefix: ", width / 2 - 75, height / 2 - 35, -1);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == back)
            mc.displayGuiScreen(new GuiMain());
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if (mouseButton == 0 && mouseX >= prefixText.xPosition && mouseX <= prefixText.xPosition + prefixText.width && mouseY >= prefixText.yPosition && mouseY <= prefixText.yPosition + prefixText.height) {
            prefixText.setFocused(true);
        } else {
            prefixText.setFocused(false);
        }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (prefixText.isFocused()) {
            prefixText.textboxKeyTyped(typedChar, keyCode);
        }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        Clicks.SETTINGS.setPrefix(prefixText.getText());

        super.onGuiClosed();
    }
}
