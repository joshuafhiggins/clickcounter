package me.toast.leftclickcounter.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class LeftClickCounterCommand extends CommandBase
{


	@Override
	public String getCommandName() 
	{
		return "leftclickcounter";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		sender.addChatMessage(new ChatComponentText("§cSubscribe To §6CyborgGamer21/Little_Toast"));
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
