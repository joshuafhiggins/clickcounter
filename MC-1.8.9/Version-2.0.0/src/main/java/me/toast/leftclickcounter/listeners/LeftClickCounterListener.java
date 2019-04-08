package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraftforge.fml.common.network.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import me.toast.leftclickcounter.utils.*;

public class LeftClickCounterListener
{
    private LeftClickCounterMod mod;
    private int PVPClicks;
    boolean isHeld;
    private Minecraft mc;
    FontRenderer fr;
    
    public LeftClickCounterListener(final LeftClickCounterMod mod) {
        this.PVPClicks = 0;
        this.isHeld = false;
        this.mc = Minecraft.getMinecraft();
        this.fr = this.mc.fontRendererObj;
        this.mod = mod;
    }
    
    @SubscribeEvent
    public void ClientConnectedToServerEvent(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        this.PVPClicks = this.mod.getSettings().getClicks();
        this.mod.getSettings().setClicks(0);
        this.mod.getSettings().saveConfig();
    }
    
    @SubscribeEvent
    public void ClientDisconnectionFromServerEvent(final FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
        this.mod.getSettings().setClicks(this.PVPClicks);
        this.mod.getSettings().saveConfig();
        this.PVPClicks = 0;
    }
    
    @SubscribeEvent
    public void MouseInputEvent(final InputEvent event) {
        if (this.mc.gameSettings.keyBindAttack.isKeyDown()) {
            if (!this.isHeld) {
                ++this.PVPClicks;
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
                this.fr.drawStringWithShadow(this.mod.getSettings().getPrefix() + ": " + this.PVPClicks, (float)this.mod.getSettings().getposX(), (float)this.mod.getSettings().getposY(), RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB());
            }
        }
    }
}
