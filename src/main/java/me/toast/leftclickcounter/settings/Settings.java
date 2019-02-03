package me.toast.leftclickcounter.settings;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Settings 
{
	private File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/LeftClickCounter.cfg");
	private int posX = 0;
	private int posY = 0;
	private int Clicks = 0;
	private String Prefix = "Left Clicks";
	
	//POSX
	public int getposX()
	{
		return posX;
	}
	public void setposX(int newposX)
	{
		posX = newposX;
	}
	
	//POSY
	public int getposY()
	{
		return posY;
	}
	public void setposY(int newposY)
	{
		posY = newposY;
	}
	
	//CLICKS
	public int getClicks()
	{
		return Clicks;
	}
	public void setClicks(int newClicks)
	{
		Clicks = newClicks;
	}
	
	//PREFIX
	public String getPrefix()
	{
		return Prefix;
	}
	public void setPrefix(String newPrefix)
	{
		Prefix = newPrefix;
	}
	
	public void saveConfig() 
	{
		Configuration config = new Configuration(saveFile);
		this.updateConfig(config, false);
		config.save();
	}
	
	public void loadConfig() 
	{
		Configuration config = new Configuration(saveFile);
		config.load();
		this.updateConfig(config, true);
	}
	
	private void updateConfig(Configuration config, boolean load) 
	{
		Property prop = config.get("Position", "posX", 0);
		if(load)
		{
			this.posX = prop.getInt();
		} 
		else 
		{
			prop.setValue(this.posX);
		}
		
		
		
		Property prop1 = config.get("Position", "posY", 0);
		if(load)
		{
			this.posY = prop1.getInt();
		} 
		else 
		{
			prop1.setValue(this.posY);
		}
		
		
		Property prop2 = config.get("Global", "SHHH...", 0);
		if(load)
		{
			this.Clicks = prop2.getInt();
		} 
		else 
		{
			prop2.setValue(this.Clicks);
		}
		
		Property prop3 = config.get("Global", "Prefix", "Left Clicks");
		if(load)
		{
			this.Prefix = prop3.getString();
		} 
		else 
		{
			prop3.setValue(this.Prefix);
		}
	}
}
