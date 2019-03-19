package ru.mrcolt.znbungeereport.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import ru.mrcolt.znbungeereport.api.ReportAPI;

public class ReportCommand extends Command {
    public ReportCommand() {
        super("report", null);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxiedPlayer player = (ProxiedPlayer) sender;

        if(args.length < 2) {
            player.sendMessage(new TextComponent("§f[§6Report§f] §c/report <ник> <причина>"));
            return;
        }

        String toPLayer = args[0];
        String fromPlayer = player.getName();
        String reason = args[1];
        long unixTime = System.currentTimeMillis() / 1000L;

        if (toPLayer.equalsIgnoreCase(fromPlayer)) {
            player.sendMessage(new TextComponent("§f[§6Report§f] §cВы не можете отпавить желобу на смого себя."));
            return;
        }

//        if (!PlayerAPI.isExist(toPLayer)) {
//            player.sendMessage(new TextComponent("§f[§6Report§f] §cИгрок не в сети."));
//            return;
//        }

        if (ReportAPI.isExist(toPLayer, fromPlayer)) {
            player.sendMessage(new TextComponent("§f[§6Report§f] §cВы уже отправили желобу на этого игрка."));
            return;
        }

        ReportAPI.setReport(toPLayer, fromPlayer, reason, unixTime);
        player.sendMessage(new TextComponent("§f[§6Report§f] §cЖалоба на игрока §a"+toPLayer+" §cотправлена."));
    }
}
