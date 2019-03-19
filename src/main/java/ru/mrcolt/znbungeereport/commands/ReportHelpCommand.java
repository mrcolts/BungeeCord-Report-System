package ru.mrcolt.znbungeereport.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ReportHelpCommand extends Command {
    public ReportHelpCommand() {
        super("report help", null);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        if(args.length < 2) {
            player.sendMessage(new TextComponent("§f[§6Report§f] §cПомощь"));
            return;
        }
        

    }
}
