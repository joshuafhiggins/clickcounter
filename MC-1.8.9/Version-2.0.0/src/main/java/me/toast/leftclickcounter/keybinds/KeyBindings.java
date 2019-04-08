package me.toast.leftclickcounter.keybinds;

import net.minecraft.client.settings.*;
import net.minecraftforge.fml.client.registry.*;

public class KeyBindings
{
    public static KeyBinding increaseX;
    public static KeyBinding increaseY;
    public static KeyBinding decreaseX;
    public static KeyBinding decreaseY;
    
    public static void init() {
        ClientRegistry.registerKeyBinding(KeyBindings.increaseX = new KeyBinding("keyBinding.increaseX", 36, "key.categories.LeftClickMod"));
    }
    
    public static void init1() {
        ClientRegistry.registerKeyBinding(KeyBindings.increaseY = new KeyBinding("keyBinding.increaseY", 37, "key.categories.LeftClickMod"));
    }
    
    public static void init11() {
        ClientRegistry.registerKeyBinding(KeyBindings.decreaseX = new KeyBinding("keyBinding.decreaseX", 49, "key.categories.LeftClickMod"));
    }
    
    public static void init111() {
        ClientRegistry.registerKeyBinding(KeyBindings.decreaseY = new KeyBinding("keyBinding.decreaseY", 50, "key.categories.LeftClickMod"));
    }
}
