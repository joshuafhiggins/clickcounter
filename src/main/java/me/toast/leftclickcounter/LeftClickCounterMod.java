package me.toast.leftclickcounter;

import org.lwjgl.input.Keyboard;

import me.toast.leftclickcounter.commands.LeftClickCounterCommand;
import me.toast.leftclickcounter.keybinds.KeyBindings;
import me.toast.leftclickcounter.listeners.LeftClickCounterListener;
import me.toast.leftclickcounter.listeners.RightClickCounterListener;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = LeftClickCounterMod.MODID, version = LeftClickCounterMod.VERSION)
public class LeftClickCounterMod
{
    public static final String MODID = "leftclickcounter";
    public static final String VERSION = "1.1.0";
    
    //TODO Fix en_US lang file for keybinds.
	//TODO Make a config for storing clicks and positions for text.
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
//    	me.toast.leftclickcounter.keybinds.KeyBindings.init();
//    	me.toast.leftclickcounter.keybinds.KeyBindings.init1();
//    	me.toast.leftclickcounter.keybinds.KeyBindings.init11();
//    	me.toast.leftclickcounter.keybinds.KeyBindings.init111();
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new LeftClickCounterCommand());
    	FMLCommonHandler.instance().bus().register(new LeftClickCounterListener());
    	FMLCommonHandler.instance().bus().register(new RightClickCounterListener());

    }
}
