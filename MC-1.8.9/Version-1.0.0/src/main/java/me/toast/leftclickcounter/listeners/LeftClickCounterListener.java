package me.toast.leftclickcounter.listeners;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.eventhandler.*;
import me.toast.leftclickcounter.utils.*;
import me.toast.leftclickcounter.keybinds.*;

public class LeftClickCounterListener
{
    private int Clicks;
    private int Number1;
    private int Number2;
    boolean isHeld;
    private Minecraft mc;
    FontRenderer fr;
    
    public LeftClickCounterListener() {
        this.Clicks = 0;
        this.Number1 = 0;
        this.Number2 = 0;
        this.isHeld = false;
        this.mc = Minecraft.getMinecraft();
        this.fr = this.mc.fontRendererObj;
    }
    
    @SubscribeEvent
    public void onRenderTick(final TickEvent.RenderTickEvent e) {
        this.drawStringRW("TestString", 2, 150, 0.75f);
    }
    
    private void drawStringRW(final String string, final int x, final int y, final float brightness) {
        for (int i = 0; i < "TestString".length(); ++i) {
            if (this.mc.theWorld != null) {
                this.fr.drawStringWithShadow("Left Clicks: " + this.Clicks, (float)this.Number1, (float)this.Number2, RainbowUtils.effect(i * 3500000L, brightness, 165).getRGB());
            }
        }
        if (this.mc.gameSettings.keyBindAttack.isKeyDown()) {
            if (!this.isHeld) {
                ++this.Clicks;
                this.isHeld = true;
            }
        }
        else if (this.isHeld) {
            this.isHeld = false;
        }
        if (KeyBindings.increaseX.isPressed()) {
            ++this.Number1;
        }
        if (KeyBindings.increaseY.isPressed()) {
            ++this.Number2;
        }
        if (KeyBindings.decreaseX.isPressed()) {
            --this.Number1;
        }
        if (KeyBindings.decreaseY.isPressed()) {
            --this.Number2;
        }
    }
}
