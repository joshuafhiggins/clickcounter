package me.toast.leftclickcounter.commands;

import me.toast.leftclickcounter.*;
import net.minecraft.util.*;
import net.minecraft.command.*;

public class LcmPos extends CommandBase
{
    private LeftClickCounterMod mod;
    
    public LcmPos(final LeftClickCounterMod mod) {
        this.mod = mod;
    }
    
    public String getCommandName() {
        return "lcmPos";
    }
    
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.getCommandName() + " <new Xpos><new Ypos>";
    }
    
    public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
        if (args.length == 0) {
            sender.addChatMessage((IChatComponent)new ChatComponentText(this.getCommandUsage(sender)));
        }
        else {
            try {
                final int newposX = Integer.parseInt(args[0]);
                final int newposY = Integer.parseInt(args[1]);
                this.mod.getSettings().setposX(newposX);
                this.mod.getSettings().setposY(newposY);
                this.mod.getSettings().saveConfig();
            }
            catch (Exception ex) {
                sender.addChatMessage((IChatComponent)new ChatComponentText(this.getCommandUsage(sender)));
            }
        }
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    public boolean canCommandSenderUseCommand(final ICommandSender p_71519_1_) {
        return true;
    }
}
