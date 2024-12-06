/*    */ package me.mchiappinam.antiautosoup.listeners;
/*    */ 
/*    */ import me.mchiappinam.antiautosoup.Main;

/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ 
/*    */ public class EntityDamageByEntityListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
/*    */   {
/* 13 */     if (!(event.getDamager() instanceof Player)) return;
/*    */ 
/* 15 */     Player player = (Player)event.getDamager();
/*    */ 
/* 17 */     Main.getInstance().setLastAttackTime(player.getUniqueId());
/*    */   }
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.listeners.EntityDamageByEntityListener
 * JD-Core Version:    0.6.2
 */