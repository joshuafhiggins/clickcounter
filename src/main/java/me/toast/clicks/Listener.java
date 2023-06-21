package me.toast.clicks;

import me.toast.clicks.guis.GuiMain;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import static me.toast.clicks.Utils.CheckForUpdates;

public class Listener {
    private final Minecraft mc = Minecraft.getMinecraft();
    boolean leftIsHeld = false;
    boolean rightIsHeld = false;

    @SubscribeEvent
    public void onJoin(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        CheckForUpdates();
    }

    @SubscribeEvent
    public void MouseInputEvent(InputEvent e) {
        if (mc.gameSettings.keyBindAttack.isKeyDown()) {
            if (!leftIsHeld) {
                Clicks.SETTINGS.incrementLeftClick();
                leftIsHeld = true;
            }
        } else {
            if (leftIsHeld) {
                leftIsHeld = false;
            }
        }

        if (mc.gameSettings.keyBindUseItem.isKeyDown()) {
            if (!rightIsHeld) {
                Clicks.SETTINGS.incrementRightClick();
                rightIsHeld = true;
            }
        } else {
            if (rightIsHeld) {
                rightIsHeld = false;
            }
        }
    }

    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event) {
        if (Clicks.GUI_OPEN) {
            Minecraft.getMinecraft().displayGuiScreen(new GuiMain());
            Clicks.GUI_OPEN = false;
        }
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent.Post e) {
        if (e.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)
            return;

        Utils.DrawClicks();
    }
}
