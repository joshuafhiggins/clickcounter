package me.toast.clicks;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Clicks.MOD_ID, name = Clicks.NAME, version = Clicks.VERSION, clientSideOnly = true)
public class Clicks {
    public static final String MOD_ID = "clicks";
    public static final String NAME = "Click Counter Mod";
    public static final String VERSION = "2.4.0";
    public static boolean GUI_OPEN = false;
    public static Settings SETTINGS = new Settings();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new Command());
        MinecraftForge.EVENT_BUS.register(new Listener());
        SETTINGS.loadConfig();
    }
}