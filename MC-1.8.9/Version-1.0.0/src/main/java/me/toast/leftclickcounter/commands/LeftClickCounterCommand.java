package me.toast.leftclickcounter.commands;

import net.minecraft.util.*;
import net.minecraft.command.*;

public class LeftClickCounterCommand extends CommandBase
{
    public String getCommandName() {
        return "leftclickcounter";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName();
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        sender.addChatMessage((IChatComponent)new ChatComponentText("\u00ef¿½cSubscribe To \u00ef¿½6CyborgGamer21/Little_Toast"));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
