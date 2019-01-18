package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.LeftClickCounterMod;
import me.toast.leftclickcounter.settings.Settings;
import me.toast.leftclickcounter.utils.RainbowUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeftClickCounterListener 
{
	private LeftClickCounterMod mod;
	
	public LeftClickCounterListener(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	private int PVPClicks = 0;
	private int PVPNumber1 = 0;
	private int PVPNumber2 = 0;

	boolean isHeld = false;

	private Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = mc.fontRendererObj;
	
	@SubscribeEvent
	public void onClientTick(ClientTickEvent e)
	{
//		PVPNumber1 = (mod.getSettings().getposX());
//		PVPNumber2 = (mod.getSettings().getposY());
	}
	
	@SubscribeEvent
	public void MouseInputEvent(InputEvent event)
	{
		if (mc.gameSettings.keyBindAttack.isKeyDown()) 
		{
			if (isHeld == false) 
			{
				PVPClicks++;
//				mod.getSettings().setClicks(+1);
				isHeld = true;
			} 
			else 
				{
					// do nothing
				}
		} 
			else 
		{
			if (isHeld) 
			{
				isHeld = false;
			}
		}
	  
	}
	
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent e) 
	{
		drawStringRW("TestString", 2, 150, 0.75F);

	}

	private void drawStringRW(String string, int x, int y, float brightness) 
	{
		for (int i = 0; i < "TestString".length(); i++) 
		{
			if (mc.theWorld != null) {
				fr.drawStringWithShadow("PvP Clicks: " + PVPClicks, mod.getSettings().getposX(), mod.getSettings().getposY(),
						RainbowUtils.effect(i * 3500000L, brightness, 165).getRGB());
			}
		}
	}
}
