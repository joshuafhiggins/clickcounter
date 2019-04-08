package me.toast.leftclickcounter.settings;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Color 
{
	private File saveFile = new File(Minecraft.getMinecraft().mcDataDir, "config/LcmColor.cfg");
	private int Red = 255;
	private int Green = 255;
	private int Blue = 255;
	private boolean isChroma = false;
	
	//RED
	public int getRed()
	{
		return Red;
	}
	public void setRed(int newRed)
	{
		Red = newRed;
	}
	
	//GREEN
	public int getGreen()
	{
		return Green;
	}
	public void setGreen(int newGreen)
	{
		Green = newGreen;
	}
	
	//BLUE
	public int getBlue()
	{
		return Blue;
	}
	public void setBlue(int newBlue)
	{
		Blue = newBlue;
	}
	
	//isChroma
	public boolean getIsChroma()
	{
		return isChroma;
	}
	public void setIsChroma()
	{
		isChroma = !isChroma;
	}
	
	
	public void saveConfig() 
	{
		Configuration config = new Configuration(saveFile);
		this.updateConfig(config, false);
		config.save();
		if (Red > 255)
		{
			Red = 255;
		}
		
		if (Green > 255)
		{
			Green = 255;
		}
		
		if (Blue > 255)
		{
			Blue = 255;
		}
	}
	
	public void loadConfig() 
	{
		Configuration config = new Configuration(saveFile);
		config.load();
		this.updateConfig(config, true);
		if (Red > 255)
		{
			Red = 255;
		}
		
		if (Green > 255)
		{
			Green = 255;
		}
		
		if (Blue > 255)
		{
			Blue = 255;
		}
	}
	
	private void updateConfig(Configuration config, boolean load) 
	{
		Property prop = config.get("Color", "Red", 255);
		if(load)
		{
			this.Red = prop.getInt();
		} 
		else 
		{
			prop.setValue(this.Red);
		}
		
		Property prop1 = config.get("Color", "Green", 255);
		if(load)
		{
			this.Green = prop1.getInt();
		} 
		else 
		{
			prop1.setValue(this.Green);
		}
		
		Property prop2 = config.get("Color", "Blue", 255);
		if(load)
		{
			this.Blue = prop2.getInt();
		} 
		else 
		{
			prop2.setValue(this.Blue);
		}
		
		Property prop3 = config.get("Chroma", "IsChroma", false);
		if(load)
		{
			this.isChroma = prop3.getBoolean();
		} 
		else 
		{
			prop3.setValue(this.isChroma);
		}
	}
}
