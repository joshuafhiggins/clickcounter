package me.toast.lcm.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateDetection 
{
	public static final String URL1 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-4-0";
    public static final String URL2 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-3-1";
    public static final String URL3 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-3-0-0";

    public static void checkIfURLExists()
    {
        HttpURLConnection httpUrlConn1;
        HttpURLConnection httpUrlConn2;
        HttpURLConnection httpUrlConn3;

        Minecraft mc = Minecraft.getMinecraft();
        try {
            httpUrlConn1 = (HttpURLConnection) new URL(URL1).openConnection();
            httpUrlConn1.setRequestMethod("HEAD");
            httpUrlConn1.setConnectTimeout(30000);
            httpUrlConn1.setReadTimeout(30000);

            httpUrlConn2 = (HttpURLConnection) new URL(URL2).openConnection();
            httpUrlConn2.setRequestMethod("HEAD");
            httpUrlConn2.setConnectTimeout(30000);
            httpUrlConn2.setReadTimeout(30000);

            httpUrlConn3 = (HttpURLConnection) new URL(URL3).openConnection();
            httpUrlConn3.setRequestMethod("HEAD");
            httpUrlConn3.setConnectTimeout(30000);
            httpUrlConn3.setReadTimeout(30000);

            if (httpUrlConn1.getResponseCode() == HttpURLConnection.HTTP_OK) {
                mc.thePlayer.addChatMessage(new ChatComponentText("§2There is an update available at Toasty Mods: " + URL1 + " !"));
            }else if (httpUrlConn1.getResponseCode() == HttpURLConnection.HTTP_OK) {
                mc.thePlayer.addChatMessage(new ChatComponentText("§2There is an update available at Toasty Mods: " + URL2 + " !"));
            }else if (httpUrlConn2.getResponseCode() == HttpURLConnection.HTTP_OK) {
                mc.thePlayer.addChatMessage(new ChatComponentText("§2There is an update available at Toasty Mods: " + URL3 + " !"));
            } else { mc.thePlayer.addChatMessage(new ChatComponentText("§4Failed to find updates!")); }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}