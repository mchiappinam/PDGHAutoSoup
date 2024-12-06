/*    */ package me.mchiappinam.antiautosoup.listeners;
/*    */ 
/*    */ import me.mchiappinam.antiautosoup.Main;

/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ //import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ 
/*    */ public class EntityDamageListener
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onEntityDamage(EntityDamageEvent event)
/*    */   {
/* 13 */     if (!(event.getEntity() instanceof Player)) return;
/* 14 */     if (event.getCause() == EntityDamageEvent.DamageCause.SUICIDE) return;
/*    */ 
/* 16 */     Player player = (Player)event.getEntity();
/*    */ 
/* 18 */     Main.getInstance().setLastAttackTime(player.getUniqueId());
/*    */   }
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.listeners.EntityDamageListener
 * JD-Core Version:    0.6.2
 */