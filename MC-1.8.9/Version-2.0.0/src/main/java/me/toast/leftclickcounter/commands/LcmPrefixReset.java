package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.*;
import net.minecraft.command.*;

public class LcmPrefixReset extends CommandBase
{
    private LeftClickCounterMod mod;
    
    public LcmPrefixReset(final LeftClickCounterMod mod) {
        this.mod = mod;
    }
    
    public String getCommandName() {
        return "lcmPrefixReset";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName();
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        this.mod.getSettings().setPrefix("Left Clicks");
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
