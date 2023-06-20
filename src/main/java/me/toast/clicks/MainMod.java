package me.toast.clicks;

import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MainMod.MODID, name = MainMod.NAME, version = MainMod.VERSION, clientSideOnly = true)
public class MainMod {

    public static final String MODID = "lcm";
    public static final String NAME = "Left Click Counter Mod";
    public static final String VERSION = "2.3.0";

    private Settings Settings = new Settings();
    public Settings getSettings() {
        return Settings;
    }

    public void openMainGui() {
        openGui = true;
    }
    public boolean openGui;

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new Command(this));
        FMLCommonHandler.instance().bus().register(new Listener(this));
        Settings.loadConfig();
    }
}