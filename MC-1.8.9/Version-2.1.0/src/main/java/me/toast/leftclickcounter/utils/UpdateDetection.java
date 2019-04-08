package me.toast.leftclickcounter.utils;

import java.net.*;
import net.minecraft.client.*;
import net.minecraft.util.*;

public class UpdateDetection
{
    public static String targetUrl1;
    public static String targetUrl2;
    public static String targetUrl3;
    
    public static boolean checkIfURLExists() {
        try {
            HttpURLConnection httpUrlConn = (HttpURLConnection)new URL(UpdateDetection.targetUrl1).openConnection();
            httpUrlConn = (HttpURLConnection)new URL(UpdateDetection.targetUrl2).openConnection();
            httpUrlConn = (HttpURLConnection)new URL(UpdateDetection.targetUrl3).openConnection();
            httpUrlConn.setRequestMethod("HEAD");
            httpUrlConn.setConnectTimeout(30000);
            httpUrlConn.setReadTimeout(30000);
            if (httpUrlConn.getResponseCode() != 404) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("There is an update availble for Left Click Counter Mod. Go to my website to get it. Website: sites.google.com/view/toasty-modding/mods/left-click-counter-mod/  .").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
            }
            else {
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("There are no updates availble at this time for Left Click Counter Mod.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
            }
            return httpUrlConn.getResponseCode() == 200;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    static {
        UpdateDetection.targetUrl1 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-1-1";
        UpdateDetection.targetUrl2 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-2-0";
        UpdateDetection.targetUrl3 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-3-0-0";
    }
}
