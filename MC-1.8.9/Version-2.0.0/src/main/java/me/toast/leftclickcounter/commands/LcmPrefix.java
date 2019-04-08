package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.*;
import net.minecraft.util.*;
import net.minecraft.command.*;

public class LcmPrefix extends CommandBase
{
    private LeftClickCounterMod mod;
    
    public LcmPrefix(final LeftClickCounterMod mod) {
        this.mod = mod;
    }
    
    public String getCommandName() {
        return "lcmPrefix";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName();
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        sender.addChatMessage((IChatComponent)new ChatComponentText("To change the prefix go to your Minecraft directory ( Where you put this mod ) and get to the config folder and find the file named LeftClickCounter. Open it. Find the prefix area ( Should look somthing like this: S:Prefix=Left Clicks ) and change Left Clicks to what ever you want."));
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
