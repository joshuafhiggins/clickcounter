package me.toast.lcm.guis;

import me.toast.lcm.MainMod;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import org.lwjgl.input.Keyboard;

import java.io.IOException;

public class GuiPrefix extends GuiScreen {

    private MainMod mod;

    private GuiButton back;

    private GuiTextField prefixText;
    private GuiTextField symbolText;

    public GuiPrefix(MainMod mod) { this.mod = mod; }


    @Override
    public void initGui() {
        super.initGui();

        prefixText = new GuiTextField(0, fontRendererObj, width / 2 - 30, height / 2 - 45, 200, 25);
        prefixText.setText(mod.getSettings().getPrefix());

        back = new GuiButton(3, width / 2 - 100, 0, "<---");

        symbolText = new GuiTextField(1, fontRendererObj, width / 2 - 30, height / 2, 50, 25);
        symbolText.setText(mod.getSettings().getSymbol());
        symbolText.setMaxStringLength(2);

        buttonList.add(back);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);

        drawDefaultBackground();

        back.drawButton(mc, mouseX, mouseY);

        prefixText.drawTextBox();
        symbolText.drawTextBox();

        drawString(fontRendererObj, "Prefix: ", width / 2 - 75, height / 2 - 35, -1);
        drawString(fontRendererObj, "Symbol Prefix: ", width / 2 - 110, height / 2 + 10, -1);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if(button == back)
            mc.displayGuiScreen(new GuiMain(mod));
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        if(mouseButton == 0 && mouseX >= prefixText.xPosition && mouseX <= prefixText.xPosition + prefixText.width && mouseY >= prefixText.yPosition && mouseY <= prefixText.yPosition + prefixText.height) {
            prefixText.setFocused(true);
        } else { prefixText.setFocused(false); }

        if(mouseButton == 0 && mouseX >= symbolText.xPosition && mouseX <= symbolText.xPosition + symbolText.width && mouseY >= symbolText.yPosition && mouseY <= symbolText.yPosition + symbolText.height) {
            symbolText.setFocused(true);
        } else { symbolText.setFocused(false); }

        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        if(prefixText.isFocused()) { prefixText.textboxKeyTyped(typedChar, keyCode); }
        if(symbolText.isFocused()) { symbolText.textboxKeyTyped(typedChar, keyCode); }

        if ((keyCode == Keyboard.KEY_E && !prefixText.isFocused() && !symbolText.isFocused()) || (keyCode == Keyboard.KEY_ESCAPE && !prefixText.isFocused() && !symbolText.isFocused())) { mc.displayGuiScreen(null); }

        super.keyTyped(typedChar, keyCode);
    }

    @Override
    public void onGuiClosed() {
        mod.getSettings().setPrefix(prefixText.getText());
        mod.getSettings().setSymbol(symbolText.getText());

        super.onGuiClosed();
    }
}
