package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.LeftClickCounterMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class LcmPos extends CommandBase 
{

	private LeftClickCounterMod mod;
	
	public LcmPos(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	@Override
	public String getCommandName() 
	{
		return "lcmPos";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName() + " <new Xpos>" + "<new Ypos>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length == 0)
		{
			sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
		}
		else 
		{
			try
			{
				int newposX = Integer.parseInt(args[0]);
				int newposY = Integer.parseInt(args[1]);
				//Change the setting
				mod.getSettings().setposX(newposX);
				mod.getSettings().setposY(newposY);
				//Saving the settings
				mod.getSettings().saveConfig();
			}
			catch(Exception ex)
			{
				sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
			}
		}
	}
	
	@Override
	public int getRequiredPermissionLevel() 
	{
        return 0;
    }
    
	@Override
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) 
	{
        return true;
    }

}