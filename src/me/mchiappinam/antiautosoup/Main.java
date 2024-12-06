/*    */ package me.mchiappinam.antiautosoup;
/*    */ 
/*    */ /*    */ import java.util.HashMap;
/*    */ //import java.util.Map;
/*    */ import java.util.UUID;

import me.mchiappinam.antiautosoup.listeners.EntityDamageByEntityListener;
import me.mchiappinam.antiautosoup.listeners.EntityDamageListener;
import me.mchiappinam.antiautosoup.listeners.InventoryClickListener;
import me.mchiappinam.antiautosoup.utils.Violation;

/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ import org.bukkit.plugin.java.JavaPlugin;
/*    */ 
/*    */ public class Main extends JavaPlugin
/*    */ {
/*    */   private static Main instance;
/* 18 */   private HashMap<UUID, Long> lastAttacked = new HashMap<UUID, Long>();
/* 19 */   public HashMap<UUID, Violation> violations = new HashMap<UUID, Violation>();
		   public HashMap<String,Integer> jogadores = new HashMap<String,Integer>();
/*    */ 
/*    */   public void onEnable()
/*    */   {
/*    */ 
/* 25 */     instance = this;
/*    */ 
/* 27 */     PluginManager manager = Bukkit.getPluginManager();
			 getServer().getPluginCommand("as").setExecutor(new Comando(this));
/*    */ 
/* 29 */     manager.registerEvents(new EntityDamageByEntityListener(), this);
/* 30 */     manager.registerEvents(new EntityDamageListener(), this);
/* 31 */     manager.registerEvents(new InventoryClickListener(), this);
/*    */   }
/*    */ 
/*    */   public void onDisable()
/*    */   {
/* 36 */     instance = null;
/*    */   }
/*    */ 
/*    */   public static Main getInstance() {
/* 40 */     return instance;
/*    */   }
/*    */ 
/*    */   public long getLastAttackTime(UUID uuid) {
/* 44 */     if (!this.lastAttacked.containsKey(uuid)) this.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
/*    */ 
/* 46 */     return ((Long)this.lastAttacked.get(uuid)).longValue();
/*    */   }
/*    */ 
/*    */   public void setLastAttackTime(UUID uuid) {
/* 50 */     this.lastAttacked.put(uuid, Long.valueOf(System.currentTimeMillis()));
/*    */   }
/*    */ 
/*    */   public int raiseViolationLevel(UUID uuid) {
/* 54 */     Violation violation = getViolation(uuid);
/*    */ 
/* 56 */     violation.raiseViolationLevel();
/* 57 */     this.violations.put(uuid, violation);
/*    */ 
/* 59 */     return violation.getViolationLevel();
/*    */   }
/*    */ 
/*    */   public Violation getViolation(UUID uuid) {
/* 63 */     if (!this.violations.containsKey(uuid)) this.violations.put(uuid, new Violation());
/*    */ 
/* 65 */     return (Violation)this.violations.get(uuid);
/*    */   }
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.Main
 * JD-Core Version:    0.6.2
 */