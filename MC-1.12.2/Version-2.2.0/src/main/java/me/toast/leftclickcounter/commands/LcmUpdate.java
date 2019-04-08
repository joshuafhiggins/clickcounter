package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.utils.UpdateDetection;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class LcmUpdate extends CommandBase
{

	@Override
	public String getName() 
	{
		return "LcmUpdate";
	}

	@Override
	public String getUsage(ICommandSender sender) 
	{
		return "/" + getName();
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		UpdateDetection.checkIfURLExists();
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
