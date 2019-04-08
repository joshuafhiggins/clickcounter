package me.toast.leftclickcounter;

import me.toast.leftclickcounter.commands.LcmPos;
import me.toast.leftclickcounter.commands.LcmPrefix;
import me.toast.leftclickcounter.commands.LcmUpdate;
import me.toast.leftclickcounter.listeners.LeftClickCounterListener;
import me.toast.leftclickcounter.listeners.UpdateOnJoin;
import me.toast.leftclickcounter.settings.Settings;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LeftClickCounterMod.MODID, version = LeftClickCounterMod.VERSION)
public class LeftClickCounterMod
{
    public static final String MODID = "leftclickcounter";
    public static final String VERSION = "2.1.1";
    
    private Settings Settings = new Settings();
    
    //TODO Fix the color customizbalty
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new LcmPos(this));
        ClientCommandHandler.instance.registerCommand(new LcmPrefix(this));
        ClientCommandHandler.instance.registerCommand(new LcmUpdate());
    	FMLCommonHandler.instance().bus().register(new LeftClickCounterListener(this));
    	FMLCommonHandler.instance().bus().register(new UpdateOnJoin());
    	Settings.loadConfig();
    }
    
    public Settings getSettings() 
    {
    	return Settings;
    }
}
