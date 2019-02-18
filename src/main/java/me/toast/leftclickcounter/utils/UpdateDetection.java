package me.toast.leftclickcounter.utils;

import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class UpdateDetection 
{
    
	public static void Detection(String[] args) 
    {
        System.out.println(UpdateDetection.checkIfURLExists("https://minecraft.net/en-us/article/new-realms-spirit-strategy-and-shep/"));
    }
 
    public static boolean checkIfURLExists(String targetUrl) 
    {
        HttpURLConnection httpUrlConn;
        try 
        {
            httpUrlConn = (HttpURLConnection) new URL(targetUrl).openConnection();
 
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
 
            // Print HTTP status code/message for your information.
            Minecraft.getMinecraft().thePlayer.sendChatMessage("Response Code: " + httpUrlConn.getResponseCode());
            Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Response Message: " + httpUrlConn.getResponseMessage()));
 
            return (httpUrlConn.getResponseCode() == HttpURLConnection.HTTP_OK);
        } 
        
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
 
}