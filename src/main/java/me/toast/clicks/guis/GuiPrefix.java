package me.toast.clicks.guis;

import me.toast.clicks.Clicks;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

import java.io.IOException;

import static me.toast.clicks.Utils.TextFieldIntersect;

public class GuiPrefix extends GuiScreen {
    private GuiButton back;
    private GuiTextField leftPrefixText;
    private GuiTextField rightPrefixText;

    @Override
    public void initGui() {
        leftPrefixText = new GuiTextField(0, fontRendererObj, width / 2 - 30, height / 2 - 45, 200, 25);
        leftPrefixText.setText(Clicks.SETTINGS.getLeftPrefix());

        rightPrefixText = new GuiTextField(1, fontRendererObj, width / 2 - 30, height / 2 - 45 - 50, 200, 25);
        rightPrefixText.setText(Clicks.SETTINGS.getRightPrefix());

        back = new GuiButton(0, width / 2 - 100, 0, "Go back");

        buttonList.add(back);

        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawDefaultBackground();

        back.drawButton(mc, mouseX, mouseY);

        leftPrefixText.drawTextBox();
        rightPrefixText.drawTextBox();

        drawString(fontRendererObj, "Left clicks: ", width / 2 - 100, height / 2 - 35, -1);
        drawString(fontRendererObj, "Right clicks: ", width / 2 - 100, height / 2 - 35 - 50, -1);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button == back)
            mc.displayGuiScreen(new GuiMain());
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        leftPrefixText.setFocused(TextFieldIntersect(leftPrefixText, mouseX, mouseY));
        rightPrefixText.setFocused(TextFieldIntersect(rightPrefixText, mouseX, mouseY));

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if (leftPrefixText.isFocused()) {
            leftPrefixText.textboxKeyTyped(typedChar, keyCode);
        }

        if (rightPrefixText.isFocused()) {
            rightPrefixText.textboxKeyTyped(typedChar, keyCode);
        }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        Clicks.SETTINGS.setLeftPrefix(leftPrefixText.getText());
        Clicks.SETTINGS.setRightPrefix(rightPrefixText.getText());

        super.onGuiClosed();
    }
}
