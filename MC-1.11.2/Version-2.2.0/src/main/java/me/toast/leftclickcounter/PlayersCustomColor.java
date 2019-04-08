package me.toast.leftclickcounter;

import java.awt.Color;

public class PlayersCustomColor 
{
	private LeftClickCounterMod mod;
	
	public PlayersCustomColor(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	public Color CustomColor() 
	{
		return new Color(mod.getColor().getRed(), mod.getColor().getGreen(), mod.getColor().getBlue());
	}
}
