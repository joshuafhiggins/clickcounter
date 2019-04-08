package me.toast.leftclickcounter.listeners;

import me.toast.leftclickcounter.utils.UpdateDetection;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class UpdateOnJoin 
{
	@SubscribeEvent
	public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent	event) 
	{
		UpdateDetection.checkIfURLExists();
	}
}
