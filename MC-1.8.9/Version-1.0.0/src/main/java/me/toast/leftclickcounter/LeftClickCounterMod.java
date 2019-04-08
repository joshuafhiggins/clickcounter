package me.toast.leftclickcounter;

import me.toast.leftclickcounter.keybinds.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.client.*;
import me.toast.leftclickcounter.commands.*;
import net.minecraft.command.*;
import net.minecraftforge.fml.common.*;
import me.toast.leftclickcounter.listeners.*;

@Mod(modid = "leftclickcounter", version = "1.0.0", acceptedMinecraftVersions = "[1.8.9]")
public class LeftClickCounterMod
{
    public static final String MODID = "leftclickcounter";
    public static final String VERSION = "1.0.0";
    
    @Mod.EventHandler
    public void preinit(final FMLPreInitializationEvent event) {
        KeyBindings.init();
        KeyBindings.init1();
        KeyBindings.init11();
        KeyBindings.init111();
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand((ICommand)new LeftClickCounterCommand());
        FMLCommonHandler.instance().bus().register((Object)new LeftClickCounterListener());
    }
}
