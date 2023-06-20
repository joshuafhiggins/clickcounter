package me.toast.lcm;

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
	private String Symbol = ": ";
	private int Red = 255;
	private int Green = 255;
	private int Blue = 255;
	private boolean isChroma = false;
	private boolean isBackground = false;

	public int getposX()
	{
		return posX;
	}
	public int getposY()
	{
		return posY;
	}
	public int getClicks()
	{
		return Clicks;
	}
	public String getPrefix()
	{
		return Prefix;
	}
	public String getSymbol() { return Symbol; }

	public int getRed()
	{
		return Red;
	}
	public int getGreen()
	{
		return Green;
	}
	public int getBlue()
	{
		return Blue;
	}
	public boolean getIsChroma() { return isChroma; }
	public boolean getIsBackground() { return isBackground; }


	//Normal Stuff
	public void setposX(int newposX) {
		posX = newposX;
		saveConfig();
	}
	public void setposY(int newposY) {
		posY = newposY;
		saveConfig();
	}
	public void addClicks() {
		Clicks++;
		saveConfig();
	}
	public void setPrefix(String newPrefix) {
		Prefix = newPrefix;
		saveConfig();
	}
	public void setSymbol(String symbol) {
		Symbol = symbol;
		saveConfig();
	}
	//Colors
	public void setRed(int newRed) {
		Red = newRed;
		saveConfig();
	}
	public void setGreen(int newGreen) {
		Green = newGreen;
		saveConfig();
	}
	public void setBlue(int newBlue) {
		Blue = newBlue;
		saveConfig();
	}
	public void setIsChroma() {
		isChroma = !isChroma;
		saveConfig();
	}
	public void setIsBackground() {
		isBackground = !isBackground;
		saveConfig();
	}

	public void saveConfig() {
		Configuration config = new Configuration(saveFile);
		this.updateConfig(config, false);
		config.save();
		if (Red > 255) { Red = 255; }
		if (Green > 255) { Green = 255; }
		if (Blue > 255) { Blue = 255; }
	}
	public void loadConfig() {
		Configuration config = new Configuration(saveFile);
		config.load();
		this.updateConfig(config, true);
		if (Red > 255) { Red = 255; }
		if (Green > 255) { Green = 255; }
		if (Blue > 255) { Blue = 255; }
	}
	
	private void updateConfig(Configuration config, boolean load) {
		Property prop = config.get("Position", "posX", 0);

		if(load) { this.posX = prop.getInt(); }
		else { prop.setValue(this.posX); }

		//Normal Stuff
		Property prop1 = config.get("Position", "posY", 0);
		if(load) { this.posY = prop1.getInt(); }
		else { prop1.setValue(this.posY); }

		Property prop2 = config.get("Global", "SHHH...", 0);
		if(load) { this.Clicks = prop2.getInt(); }
		else { prop2.setValue(this.Clicks); }
		
		Property prop3 = config.get("Text", "Prefix", "Left Clicks");
		if(load) { this.Prefix = prop3.getString(); }
		else { prop3.setValue(this.Prefix); }

		//Colors
		Property prop4 = config.get("Color", "Red", 255);
		if(load) { this.Red = prop4.getInt(); }
		else { prop4.setValue(this.Red); }

		Property prop5 = config.get("Color", "Green", 255);
		if(load) { this.Green = prop5.getInt(); }
		else { prop5.setValue(this.Green); }

		Property prop6 = config.get("Color", "Blue", 255);
		if(load) { this.Blue = prop6.getInt(); }
		else { prop6.setValue(this.Blue); }

		Property prop7 = config.get("Color", "IsChroma", false);
		if(load) { this.isChroma = prop7.getBoolean(); }
		else { prop7.setValue(this.isChroma); }

		//From Update 2.3
		Property prop8 = config.get("Text", "Symbol", ": ");
		if(load) { this.Symbol = prop8.getString(); }
		else { prop8.setValue(this.Symbol); }

		Property prop9 = config.get("Color", "Background", false);
		if(load) { this.isBackground = prop9.getBoolean(); }
		else { prop9.setValue(this.isBackground); }
	}
}
