package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.LeftClickCounterMod;
import me.toast.leftclickcounter.settings.Settings;
import me.toast.leftclickcounter.utils.RainbowUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LeftClickCounterListener 
{
	private LeftClickCounterMod mod;
	
	public LeftClickCounterListener(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	boolean isHeld = false;

	private Minecraft mc = Minecraft.getMinecraft();
	FontRenderer fr = mc.fontRendererObj;
	Settings cfg = mod.getSettings();
	
	//Click Counter
	@SubscribeEvent
	public void MouseInputEvent(InputEvent event)
	{
		if (mc.gameSettings.keyBindAttack.isKeyDown()) 
		{
			if (isHeld == false) 
			{
				cfg.add1Clicks();
				cfg.saveConfig();
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
	
	//Text Rendering
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent e) 
	{
		//Needed for Rainbow text
		drawStringRW("TestString", 2, 150, 0.75F);
	}

	private void drawStringRW(String string, int x, int y, float brightness) 
	{
		for (int i = 0; i < "TestString".length(); i++) 
		{
			if (mc.theWorld != null) 
			{			
				/* Dev Download one */
				//fr.drawStringWithShadow("§6" + cfg.getPrefix() + ": " + cfg.getClicks(), cfg.getposX(), cfg.getposY(), -1);
				/* Public Download one */
				fr.drawStringWithShadow(cfg.getPrefix() + ": " + cfg.getClicks(), cfg.getposX(), cfg.getposY(), RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB());
			}
		}
	}
}
