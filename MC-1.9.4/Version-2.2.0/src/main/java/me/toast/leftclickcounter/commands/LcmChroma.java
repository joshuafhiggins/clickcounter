package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.LeftClickCounterMod;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class LcmChroma extends CommandBase
{

	private LeftClickCounterMod mod;
	
	public LcmChroma(LeftClickCounterMod mod)
	{
		this.mod = mod;
	}
	
	@Override
	public String getCommandName() 
	{
		return "LcmChroma";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName();
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		mod.getColor().setIsChroma();
		mod.getColor().saveConfig();
	}
	
	@Override
	public int getRequiredPermissionLevel() 
	{
        return 0;
    }
    
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return sender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }

}
