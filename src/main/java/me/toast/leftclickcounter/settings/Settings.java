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
	
	public int getposX()
	{
		return posX;
	}
	
	public void setposX(int newposX)
	{
		posX = newposX;
	}
	
	public int getposY()
	{
		return posX;
	}
	
	public void setposY(int newposY)
	{
		posY = newposY;
	}
	
	
	public int getClicks()
	{
		return Clicks;
	}
	
	public void setClicks(int newClicks)
	{
		posX = newClicks;
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
		Property prop = config.get("Global", "posX", 0);
		if(load)
		{
			this.posX = prop.getInt();
		} 
		else 
		{
			prop.setValue(this.posX);
		}
		
		
		
		Property prop1 = config.get("Global", "posY", 0);
		if(load)
		{
			this.posY = prop1.getInt();
		} 
		else 
		{
			prop1.setValue(this.posY);
		}
		
		
		Property prop2 = config.get("Global", "Clicks", 0);
		if(load)
		{
			this.Clicks = prop2.getInt();
		} 
		else 
		{
			prop2.setValue(this.Clicks);
		}
	}
}
