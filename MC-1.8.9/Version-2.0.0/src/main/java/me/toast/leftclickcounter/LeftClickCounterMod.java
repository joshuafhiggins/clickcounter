package me.toast.leftclickcounter;

import me.toast.leftclickcounter.settings.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.*;
import net.minecraft.command.*;
import me.toast.leftclickcounter.commands.*;
import net.minecraftforge.fml.common.*;
import me.toast.leftclickcounter.listeners.*;

@Mod(modid = "leftclickcounter", version = "2.0.0", acceptedMinecraftVersions = "[1.8.9]")
public class LeftClickCounterMod
{
    public static final String MODID = "leftclickcounter";
    public static final String VERSION = "2.0.0";
    private Settings settings;
    
    public LeftClickCounterMod() {
        this.settings = new Settings();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand((ICommand)new LcmPos(this));
        ClientCommandHandler.instance.registerCommand((ICommand)new LcmPrefix(this));
        ClientCommandHandler.instance.registerCommand((ICommand)new LcmPrefixReset(this));
        FMLCommonHandler.instance().bus().register((Object)new LeftClickCounterListener(this));
        this.settings.loadConfig();
    }
    
    public Settings getSettings() {
        return this.settings;
    }
}
