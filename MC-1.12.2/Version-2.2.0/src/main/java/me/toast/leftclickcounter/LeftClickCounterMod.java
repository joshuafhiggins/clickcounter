package me.toast.leftclickcounter;

import me.toast.leftclickcounter.commands.LcmChroma;
import me.toast.leftclickcounter.commands.LcmColor;
import me.toast.leftclickcounter.commands.LcmPos;
import me.toast.leftclickcounter.commands.LcmPrefix;
import me.toast.leftclickcounter.commands.LcmUpdate;
import me.toast.leftclickcounter.listeners.LeftClickCounterListener;
import me.toast.leftclickcounter.listeners.UpdateOnJoin;
import me.toast.leftclickcounter.settings.Color;
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
    public static final String VERSION = "2.2.0";
    
    private Settings Settings = new Settings();
    private Color Color = new Color();
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new LcmPos(this));
        ClientCommandHandler.instance.registerCommand(new LcmPrefix(this));
        ClientCommandHandler.instance.registerCommand(new LcmColor(this));
        ClientCommandHandler.instance.registerCommand(new LcmChroma(this));
        ClientCommandHandler.instance.registerCommand(new LcmUpdate());
    	FMLCommonHandler.instance().bus().register(new LeftClickCounterListener(this));
    	FMLCommonHandler.instance().bus().register(new UpdateOnJoin());
    	Settings.loadConfig();
    	Color.loadConfig();
    	
    }
    
    public Settings getSettings() 
    {
    	return Settings;
    }
    
    public Color getColor()
    {
    	return Color;
    }
}
