package me.toast.leftclickcounter;

import me.toast.leftclickcounter.commands.LeftClickCounterCommand;
import me.toast.leftclickcounter.listeners.LeftClickCounterListener;
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
    public void init(FMLInitializationEvent event)
    {
        ClientCommandHandler.instance.registerCommand(new LeftClickCounterCommand());
    	FMLCommonHandler.instance().bus().register(new LeftClickCounterListener());

    }
}
