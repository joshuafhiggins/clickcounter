package me.toast.lcm;

import me.toast.lcm.guis.GuiMain;
import me.toast.lcm.guis.GuiOverlay;
import me.toast.lcm.utils.UpdateDetection;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class Listener
{
	private MainMod mod;
	public Listener(MainMod mod) { this.mod = mod; }
	
	boolean isHeld = false;
	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent	event)
	{
		UpdateDetection.checkIfURLExists();
	}

	@SubscribeEvent
	public void MouseInputEvent(InputEvent e) {
		if (mc.gameSettings.keyBindAttack.isKeyDown()) {
			if (!isHeld) {
				mod.getSettings().addClicks();
				mod.getSettings().saveConfig();
				isHeld = true;
			}
		} else {
			if (isHeld) { isHeld = false; }
		}
	}

	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) {
		if (mod.openGui) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiMain(mod));
			mod.openGui = false;
		}
	}

	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent.Post e) {
		if(e.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) return;
		new GuiOverlay(Minecraft.getMinecraft(), mod);
	}
}
