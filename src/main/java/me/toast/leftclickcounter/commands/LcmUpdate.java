package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.utils.UpdateDetection;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class LcmUpdate extends CommandBase
{

	@Override
	public String getCommandName() 
	{
		return "LcmUpdate";
	}

	@Override
	public String getCommandUsage(ICommandSender sender) 
	{
		return "/" + getCommandName();
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException 
	{
		UpdateDetection.checkIfURLExists("https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-1-1");
		UpdateDetection.checkIfURLExists("https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-2-2-0");
		UpdateDetection.checkIfURLExists("https://sites.google.com/view/toasty-modding/mods/left-click-counter-mod/downloads/mc-1-8-9/version-3-0-0");
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
