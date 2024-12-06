/*    */ package me.mchiappinam.antiautosoup.utils;
/*    */ 
/*    */ import me.mchiappinam.antiautosoup.Main;
import net.minecraft.server.v1_8_R3.ChatComponentText;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

/*    */ //import java.io.File;
/*    */ //import java.io.FileWriter;
/*    */ //import java.io.PrintStream;
/*    */ //import java.io.PrintWriter;
/*    */ //import java.text.SimpleDateFormat;
/*    */ //import java.util.Date;
/*    */// import java.util.List;
/*    */ //import java.util.Map;
/*    */ import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
/*    */ //import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
/*    */ //import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class Utils
/*    */ {
public static void notifyStaff(Player player, int violationLevel, long time)
{
/* 18 */     Violation violation = Main.getInstance().getViolation(player.getUniqueId());
/*    */ 
/* 20 */     violation.updateNotify();
/* 21 */     Main.getInstance().violations.put(player.getUniqueId(), violation);
			 if(Main.getInstance().jogadores.containsKey(player.getName().toLowerCase())) {
				 Main.getInstance().jogadores.remove(player.getName().toLowerCase());
				 Main.getInstance().jogadores.put(player.getName().toLowerCase(), violationLevel);
			 }else{
				 Main.getInstance().jogadores.put(player.getName().toLowerCase(),violationLevel);
			 }
/*    */ 
/* 23 */     for (Player staff : Bukkit.getOnlinePlayers()) {
/* 24 */       if (staff.hasPermission("pdgh.moderador")) {
	PacketPlayOutChat packet = new PacketPlayOutChat(new ChatComponentText("[/as] §e"+player.getName()+" §cpode estar usando AutoSoup! Total: "+violationLevel+")"), (byte)2);
    ((CraftPlayer) staff).getHandle().playerConnection.sendPacket(packet);
/* 25 */         //staff.sendMessage("§f§l[PDGHSopa] §e"+player.getName()+" §cpode estar usando AutoSoup! "/*(diff="+time+")*/ +"Total: "+violationLevel+"/15");
    }
  }
/*    */ 
/* 29 */     Bukkit.getConsoleSender().sendMessage("PDGHAutoSoup > "+player.getName()+" pode estar usando AutoSoup! (diff="+time+") VL: "+violationLevel);
}
/*    */ 
public static void performAction(Player player) {
/* 33 */     int violationLevel = Main.getInstance().getViolation(player.getUniqueId()).getViolationLevel();
/* 34 */     int maxAllowedViolationLevel = 15;
/*    */ 
/* 36 */     if (maxAllowedViolationLevel == 0) return;
/* 37 */     if (violationLevel < maxAllowedViolationLevel) return;
/*    */ 
/* 39 */     //List commandsRun = ConfigUtils.getCommandsRun();
/*    */ 
/* 41 */     //if (commandsRun.isEmpty()) return;
/*    */ 
/* 43 */     //for (String command : commandsRun)
/* 44 */       //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+player.getName()+" 43200 Uso de sistema automático de sopa [AUTOBAN]");
}
/*    */ 
/**public static void performLogging(String message)
{
if (!ConfigUtils.isLoggingEnabled()) return;

Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable()
  {
    public void run() {
      try {
PrintWriter writer = new PrintWriter(new FileWriter(Main.getInstance().getDataFolder()+File.separator+"log.log", true), true);
if (message.isEmpty()) {
writer.write(System.getProperty("line.separator"));
        } else {
String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
writer.write(time+" = "+this.val$message);
writer.write(System.getProperty("line.separator"));
        }

writer.close();
      } catch (Exception ex) {
System.out.println("There was an error while logging violation levels to the file.");
ex.printStackTrace();
      }
    }
  });
}*/
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.utils.Utils
 * JD-Core Version:    0.6.2
 */