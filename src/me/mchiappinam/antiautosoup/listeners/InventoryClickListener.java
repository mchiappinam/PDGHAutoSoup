/*    */ package me.mchiappinam.antiautosoup.listeners;
/*    */ 
/*    */ /*    */ import me.mchiappinam.antiautosoup.Main;
import me.mchiappinam.antiautosoup.utils.Utils;

/*    */ //import com.duckzcraft.viper_monster.antiautosoup.utils.Violation;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryAction;
/*    */ import org.bukkit.event.inventory.InventoryClickEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ //import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ public class InventoryClickListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInventoryInteract(InventoryClickEvent event)
/*    */   {
/* 18 */     if (!(event.getWhoClicked() instanceof Player)) return;
/* 19 */     if (event.isCancelled()) return;
/* 20 */     if (event.getAction() == InventoryAction.HOTBAR_SWAP) return;
/*    */ 
/* 22 */     Player player = (Player)event.getWhoClicked();
/*    */ 
/* 24 */     if (player.hasPermission("pdgh.op")) return;
/*    */ 
/* 26 */     if (event.getSlot() == -1) return;
/*    */ 
/* 28 */     long calculatedTime = System.currentTimeMillis() - Main.getInstance().getLastAttackTime(player.getUniqueId());
/*    */ 
/* 30 */     int bowls = 0;
/*    */ 
/* 32 */     for (ItemStack itemStack : player.getInventory().getContents()) {
/* 33 */       if (itemStack != null)
/*    */       {
/* 35 */         if (itemStack.getType() == Material.BOWL) bowls += itemStack.getAmount();
/*    */       }
/*    */     }
/* 38 */     if (calculatedTime > 999) return;
/* 39 */     if (bowls < 5) return;
/*    */ 
/* 41 */     int level = Main.getInstance().raiseViolationLevel(player.getUniqueId());
/*    */ 
/* 43 */     if (Main.getInstance().getViolation(player.getUniqueId()).shouldNotify()) {
/* 44 */       Utils.notifyStaff(player, level, calculatedTime);
/*    */     }
/*    */ 
/* 47 */     Utils.performAction(player);
/*    */ 
/* 49 */    // if (!ConfigUtils.isLoggingEnabled()) return;
/*    */ 
/* 51 */    // if (ConfigUtils.shouldLogAlways()) {
/* 52 */     //  if (level % ConfigUtils.getDividingNumber() == 0) {
/* 53 */     //    Utils.performLogging(player.getName() + " reached level " + level + ", diff=" + calculatedTime);
/*    */    //   }
/*    */     //}
/* 56 */    // else if (level == ConfigUtils.getLogLevel())
/* 57 */    //   Utils.performLogging(player.getName() + " reached level " + level + ", diff=" + calculatedTime);
/*    */   }
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.listeners.InventoryClickListener
 * JD-Core Version:    0.6.2
 */