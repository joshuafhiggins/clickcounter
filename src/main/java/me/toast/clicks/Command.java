package me.toast.clicks;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class Command extends CommandBase {

    @Override
    public String getCommandName() {
        return Clicks.MOD_ID;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        Clicks.GUI_OPEN = true;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }
}
