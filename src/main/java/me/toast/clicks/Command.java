package me.toast.clicks;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;

public class Command extends CommandBase
{
    private MainMod mod;
    public Command(MainMod mod) { this.mod = mod; }

    @Override
    public String getCommandName()
    {
        return "lcm";
    }

    @Override
    public String getCommandUsage(ICommandSender sender)
    {
        return "/" + getCommandName();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException { mod.openMainGui(); }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) { return true; }
}
