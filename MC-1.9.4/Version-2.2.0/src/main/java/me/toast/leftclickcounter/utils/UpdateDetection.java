package me.toast.leftclickcounter.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class UpdateDetection 
{
	public static String targetUrl1 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-9-4/version-2-2-1";
	public static String targetUrl2 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-9-4/version-2-3-0";
	public static String targetUrl3 = "https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-9-4/version-3-0-0";
	
 
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
            	Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("There is an update availble for Left Click Counter Mod. Go to my website to get it. Website: sites.google.com/view/toasty-modding/mods/left-click-counter-mod/  .").setStyle(new Style().setColor(TextFormatting.GREEN)));
            }
            else 
            {
            	Minecraft.getMinecraft().thePlayer.addChatMessage(new TextComponentString("There are no updates availble at this time for Left Click Counter Mod.").setStyle(new Style().setColor(TextFormatting.RED)));
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