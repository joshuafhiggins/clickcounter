package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.utils.*;
import net.minecraft.command.*;

public class LcmUpdate extends CommandBase
{
    public String getCommandName() {
        return "LcmUpdate";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName();
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        UpdateDetection.checkIfURLExists();
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
