package me.mchiappinam.antiautosoup;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Comando implements CommandExecutor {
	private Main plugin;

	public Comando(Main main) {
		plugin = main;
	}
	
  	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("as")) {
			if(!sender.hasPermission("pdgh.moderador")) {
				sender.sendMessage("§cSem permissões");
				return true;
			}
			if(args.length>0) {
				sender.sendMessage("§cUse /as");
				return true;
        	}
			if(args.length==0) {
				sender.sendMessage("§aVerificação global iniciada.");
		  		for (String p : plugin.jogadores.keySet()) {
		  			int avisos = plugin.jogadores.get(p);
		  			sender.sendMessage("§c"+p+" §etem §c"+avisos+" §eaviso(s) de uso de auto soup");
		  		}
				sender.sendMessage("§aVerificação global finalizada.");
				return true;
        	}
        }
		return false;
    }
  	
}