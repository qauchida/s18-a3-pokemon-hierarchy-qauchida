import java.util.*;
/**
*@qauchida
*@since 02/22/18
*flareon
*/

public class Flareon extends Eevee implements FireType, NullType{

   static final int ATTACK = 246;
   /**base defense power.*/
   static final int DEFENSE = 204;
   /**base stamina power.*/
   static final int STAMINA = 130;

   /***/
   protected boolean fastIsFire = true;
   /***/
   protected boolean specialIsFire = true;


   public Flareon() {
      super("Flareon", "Flareon", 136, 0.9, 25.0, FIRE_TYPE, NULL_TYPE,
         ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack(); 
   
   }

   //constructor with name
   public Flareon(String name) {
      super("Flareon", name, 136, 0.9, 25.0, FIRE_TYPE, NULL_TYPE,
         ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack();
   
   }

   protected Flareon(String species, String name, int num, 
       double ht, double wt,String FIRE_TYPE, String NULL_TYPE, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, ht, wt, FIRE_TYPE, 
         NULL_TYPE, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
   
   protected void chooseFastAttack() {
   
      Random ranNum = new Random();
      int index;
      
      fastIsFire = ranNum.nextBoolean();
      index = ranNum.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   
   }
   
   protected void chooseSpecialAttack() {
      Random ranNum = new Random();
      int index;
      
      specialIsFire = ranNum.nextBoolean();
      index = ranNum.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
         
   }

   public String performFastAttack(Pokemon victim) {
   
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
      //check effectiveness of attack
      
      if (vType.equals("Ground") || vType.equals("Steel") ) {
            
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;          
      } 
      if(vType.equals("Water")){
         modifier = modifier * 2.0;
         s = s + "\n It was super effective!";
      }else if (vType.equals("Rock")) { 
         s = s + "\n It had no effect...";
         modifier = modifier * 0.0;
      }
   
        //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   
   } //close performFastAttack
   
   public String performSpecialAttack(Pokemon victim) {
   
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      if (vType.equals("Ground") || vType.equals("Steel") 
             ) {
             
         s = s + "\n It was not very effective.";
         modifier = modifier * .5;          
      } 
      if(vType.equals(vType.equals("Water"))){
      
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      
      }else if (vType.equals("Electric") ) { 
            
         s = s + "\n It had no effect...";
         modifier = modifier * 0.0;
      }
      
            
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   
   } //close performSpecialAttack
   
   protected void beAttacked(int damage) {
   
      damage = damage/defensePower;
   
      if(hP> damage){
         hP = hP-damage;
      }else{
         hP = 0;
      }
   
   } //close beAttacked
}
