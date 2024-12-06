/*    */ package me.mchiappinam.antiautosoup.utils;
/*    */ 
/*    */ public class Violation
/*    */ {
/*  5 */   private int violationLevel = 0;
/*  6 */   private long lastNotified = 0L;
/*    */ 
/*    */   public void raiseViolationLevel() {
/*  9 */     this.violationLevel += 1;
/*    */   }
/*    */ 
/*    */   public int getViolationLevel() {
/* 13 */     return this.violationLevel;
/*    */   }
/*    */ 
/*    */   public void updateNotify() {
/* 17 */     this.lastNotified = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   public boolean shouldNotify() {
/* 21 */     return System.currentTimeMillis() - this.lastNotified >= 1;
/*    */   }
/*    */ }

/* Location:           C:\Users\Matheus\Desktop\AntAutoSoup\AntiAutoSoup.jar
 * Qualified Name:     com.duckzcraft.viper_monster.antiautosoup.utils.Violation
 * JD-Core Version:    0.6.2
 */