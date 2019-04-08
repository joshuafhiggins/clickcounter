package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import me.toast.leftclickcounter.utils.*;

public class LeftClickCounterListener
{
    private LeftClickCounterMod mod;
    boolean isHeld;
    private Minecraft mc;
    FontRenderer fr;
    
    public LeftClickCounterListener(final LeftClickCounterMod mod) {
        this.isHeld = false;
        this.mc = Minecraft.getMinecraft();
        this.fr = this.mc.fontRendererObj;
        this.mod = mod;
    }
    
    @SubscribeEvent
    public void MouseInputEvent(final InputEvent event) {
        if (this.mc.gameSettings.keyBindAttack.isKeyDown()) {
            if (!this.isHeld) {
                this.mod.getSettings().add1Clicks();
                this.mod.getSettings().saveConfig();
                this.isHeld = true;
            }
        }
        else if (this.isHeld) {
            this.isHeld = false;
        }
    }
    
    @SubscribeEvent
    public void onRenderTick(final TickEvent.RenderTickEvent e) {
        this.drawStringRW("TestString", 2, 150, 0.75f);
    }
    
    private void drawStringRW(final String string, final int x, final int y, final float brightness) {
        for (int i = 0; i < "TestString".length(); ++i) {
            if (this.mc.theWorld != null) {
                this.fr.drawStringWithShadow(this.mod.getSettings().getPrefix() + ": " + this.mod.getSettings().getClicks(), (float)this.mod.getSettings().getposX(), (float)this.mod.getSettings().getposY(), RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB());
            }
        }
    }
}
