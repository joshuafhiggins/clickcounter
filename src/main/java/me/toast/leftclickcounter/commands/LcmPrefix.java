package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.LeftClickCounterMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class LcmPrefix extends CommandBase
{

private LeftClickCounterMod mod;
	
	public LcmPrefix(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	@Override
	public String getCommandName() 
	{
		return "lcmPrefix";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		sender.addChatMessage(new ChatComponentText("To change the prefix go to your Minecraft directory ( Where you put this mod ) and get to the config folder and find the file named LeftClickCounter. Open it. Find the prefix area ( Should look somthing like this: S:Prefix=Left Clicks ) and change Left Clicks to what ever you want."));
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