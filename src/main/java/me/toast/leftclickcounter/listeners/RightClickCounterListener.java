package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.keybinds.KeyBindings;
import me.toast.leftclickcounter.utils.RainbowUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class RightClickCounterListener
{
	private int BuildClicks = 0;
	private int BuildNumber1 = 0;
	private int BuildNumber2 = 10;

	boolean isHeld = false;

	private Minecraft mc = Minecraft.getMinecraft();

	FontRenderer fr = mc.fontRendererObj;
	
	@SubscribeEvent
	public void MouseInputEvent(InputEvent event)
	{
		if (mc.gameSettings.keyBindUseItem.isKeyDown()) 
		{
			if (isHeld == false) 
			{
				BuildClicks++;
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
				fr.drawStringWithShadow("Build Clicks: " + BuildClicks, BuildNumber1, BuildNumber2,
						RainbowUtils.effect(i * 3500000L, brightness, 165).getRGB());
			}
		}
	}
}