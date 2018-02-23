import java.util.*;
/**
*@qauchida
*@since 02/14/18
*Vaporeon
*/

public class Vaporeon extends Eevee implements WaterType, NullType{

   static final int ATTACK = 205;
   /**base defense power.*/
   static final int DEFENSE = 177;
   /**base stamina power.*/
   static final int STAMINA = 260;

   /***/
   protected boolean fastIsWater = true;
   /***/
   protected boolean specialIsWater = true;


   public Vaporeon() {
      super("Vaporeon", "Vaporeon", 134, 1.0, 29.0, WATER_TYPE, WATER_TYPE,
         ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack(); 
   
   }

   //constructor with name
   public Vaporeon(String name) {
      super("Vaporeon", name, 134, 1.0, 29.0, WATER_TYPE, NULL_TYPE,
         ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack();
   
   }

   protected Vaporeon(String species, String name, int num, 
       double ht, double wt,String WATER_TYPE, String NULL_TYPE, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, ht, wt, WATER_TYPE, 
         NULL_TYPE, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
   
   protected void chooseFastAttack() {
   
      Random ranNum = new Random();
      int index;
      
      fastIsWater = ranNum.nextBoolean();
      index = ranNum.nextInt(WATER_FAST_ATTACKS.length);
      fastAttack = WATER_FAST_ATTACKS[index];
      fastAttackPower = WATER_FAST_ATK_POWER[index];
   
   }
   
   protected void chooseSpecialAttack() {
      Random ranNum = new Random();
      int index;
      
      specialIsWater = ranNum.nextBoolean();
      index = ranNum.nextInt(WATER_SPECIAL_ATTACKS.length);
      specialAttack = WATER_SPECIAL_ATTACKS[index];
      specialAttackPower = WATER_SPECIAL_ATK_POWER[index];
         
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
      
      if (vType.equals("Grass") || vType.equals("Water") || vType.equals("Dragon")) {
            
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;          
      } 
      if(vType.equals("Ground") || vType.equals("Rock") || vType.equals("Fire")){
         modifier = modifier * 2.0;
         s = s + "\n It was super effective!";
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
      if (vType.equals("Grass") || vType.equals("Water") || vType.equals("Dragon") 
             ) {
             
         s = s + "\n It was not very effective.";
         modifier = modifier * .5;          
      } 
      if(vType.equals("Fire") || vType.equals("Rock") || vType.equals("Ground")){
      
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      
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
