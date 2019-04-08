package me.toast.leftclickcounter.utils;

import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;

public class UpdateDetection 
{
	public static String targetUrl1 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-1-2";
	public static String targetUrl2 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-2-0";
	public static String targetUrl3 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-3-0-0";
	
 
    public static boolean checkIfURLExists() 
    {
        HttpURLConnection httpUrlConn;
        try 
        {
            httpUrlConn = (HttpURLConnection) new URL(targetUrl1).openConnection();
            httpUrlConn = (HttpURLConnection) new URL(targetUrl2).openConnection();
            httpUrlConn = (HttpURLConnection) new URL(targetUrl3).openConnection();
 
            /* A HEAD request is just like a GET request, except that it asks
            the server to return the response headers only, and not the
            actual resource (i.e. no message body).
            This is useful to check characteristics of a resource without
            actually downloading it,thus saving bandwidth. Use HEAD when
            you don't actually need a file's contents. */
            httpUrlConn.setRequestMethod("HEAD");
 
            // Set timeouts in milliseconds
            httpUrlConn.setConnectTimeout(30000);
            httpUrlConn.setReadTimeout(30000);
 
            if (httpUrlConn.getResponseCode() != 404) 
            { 
            	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("There is an update availble for Left Click Counter Mod. Go to my website to get it. Website: sites.google.com/view/toasty-modding/mods/left-click-counter-mod/  .").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.GREEN)));
            }
            else 
            {
            	Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("There are no updates availble at this time for Left Click Counter Mod.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
            }
            
 
            return (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK);
        } 
        
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
 
}
