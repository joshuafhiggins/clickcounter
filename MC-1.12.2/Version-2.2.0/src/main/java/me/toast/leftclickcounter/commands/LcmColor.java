package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.LeftClickCounterMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class LcmColor extends CommandBase
{

	private LeftClickCounterMod mod;
	
	public LcmColor(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	@Override
	public String getName() 
	{
		return "LcmColor";
	}

	@Override
	public String getUsage(ICommandSender sender) 
	{
		return "/" + getName() + "<Red>" + "<Green>" + "<Blue>";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if(args.length == 0)
		{
			sender.sendMessage(new TextComponentString(getUsage(sender)));
		}
		else 
		{
			try
			{
				int newRed = Integer.parseInt(args[0]);
				int newGreen = Integer.parseInt(args[1]);
				int newBlue = Integer.parseInt(args[2]);
				//Change the setting
				mod.getColor().setRed(newRed);
				mod.getColor().setGreen(newGreen);
				mod.getColor().setBlue(newBlue);
				//Saving the settings
				mod.getColor().saveConfig();
			}
			catch(Exception ex)
			{
				sender.sendMessage(new TextComponentString(getUsage(sender)));
			}
		}
	}
	
	@Override
	public int getRequiredPermissionLevel() 
	{
        return 0;
    }
    
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return sender.canUseCommand(this.getRequiredPermissionLevel(), this.getName());
    }

}
