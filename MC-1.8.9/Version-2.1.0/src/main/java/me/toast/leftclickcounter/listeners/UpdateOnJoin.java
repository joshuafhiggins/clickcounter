package me.toast.leftclickcounter.listeners;

import net.minecraftforge.fml.common.network.*;
import me.toast.leftclickcounter.utils.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class UpdateOnJoin
{
    @SubscribeEvent
    public void onJoin(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        UpdateDetection.checkIfURLExists();
    }
}
