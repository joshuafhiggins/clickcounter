package me.toast.leftclickcounter.listeners;

import java.awt.Color;

import me.toast.leftclickcounter.LeftClickCounterMod;
import me.toast.leftclickcounter.PlayersCustomColor;
import me.toast.leftclickcounter.utils.RainbowUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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
	
	public Color CustomColor() 
	{
		return new Color(mod.getColor().getRed(), mod.getColor().getGreen(), mod.getColor().getBlue());
	}
	
	//Click Counter
	@SubscribeEvent
	public void MouseInputEvent(InputEvent event)
	{
		if (mc.gameSettings.keyBindAttack.isKeyDown()) 
		{
			if (isHeld == false) 
			{
				mod.getSettings().add1Clicks();
				mod.getSettings().saveConfig();
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
			if (mc.world != null) 
			{			
				if (mod.getColor().getIsChroma()) 
				{
					fr.drawStringWithShadow(mod.getSettings().getPrefix() + ": " + mod.getSettings().getClicks(), mod.getSettings().getposX(), mod.getSettings().getposY(), RainbowUtils.effect(i * 3500000L, brightness, 250).getRGB());
				}
				else 
				{
					fr.drawStringWithShadow(mod.getSettings().getPrefix() + ": " + mod.getSettings().getClicks(), mod.getSettings().getposX(), mod.getSettings().getposY(), CustomColor().getRGB());
				}
			}
		}
	}
}
