import java.util.*;
/**
*@qauchida
*@since 02/07/18
*Squirtle
*/

public class Squirtle extends Pokemon implements WaterType{

/**
*declare base stats as constants
*/
   static final int ATTACK = 94;
   static final int DEFENSE = 122;
   static final int STAMINA = 88; 
   
   protected boolean fastIsWater = true;
   protected boolean specialIsWater = true;
   
   /**no name constructor 
   */
   public Squirtle(){
      super("Squirtle","Squirtle", 7, WATER_COLOR, 0.5, 9.0, 
         WATER_TYPE,"", ATTACK, DEFENSE, STAMINA);
      chooseFastAttack();
      chooseSpecialAttack();
   } // close constructor
   
      /**with name constructor 
   */
   public Squirtle(String name){
      super("Squirtle",name, 7, WATER_COLOR, 0.5, 9.0, 
         WATER_TYPE, "",ATTACK, DEFENSE, STAMINA);
      chooseFastAttack();
      chooseSpecialAttack();
   } // close constructor
   
   protected Squirtle(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, WATER_COLOR, ht, wt, WATER_TYPE,"", 
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);

      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsWater = randGen.nextBoolean();
          
      index = randGen.nextInt(WATER_FAST_ATTACKS.length);
      fastAttack = WATER_FAST_ATTACKS[index];
      fastAttackPower = WATER_FAST_ATK_POWER[index];
   
   }
   //fast attack 
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
      
         if (vType.equals("Ground") || vType.equals("Rock") 
             || vType.equals("Fire")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0; 
                     
         } else if ( vType.equals("Water") || vType.equals("Dragon") ||
             vType.equals("Grass")|| vType.equals("Dragon")){ 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
       
      
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }

   protected void chooseSpecialAttack() {
    
      Random randGen = new Random();
      int index;
      //set type choice boolean
      specialIsWater = randGen.nextBoolean();
      index = randGen.nextInt(WATER_SPECIAL_ATTACKS.length);
      specialAttack = WATER_SPECIAL_ATTACKS[index];
      specialAttackPower = WATER_SPECIAL_ATK_POWER[index];

   }

   
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      String vType2 = victim.getType2();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      //check effectiveness of attack
               if (vType.equals("Fire") || vType.equals("Rock") 
             || vType.equals("Ground")) {
             
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } if (vType.equals("Water") || vType.equals("Dragon")|| vType.equals("Grass")
         ||vType2.equals("Grass") || vType2.equals("Dragon") || vType2.equals("Water"))
         
         {    
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      
     
      //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (specialAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
   
   /**
   * Reduces Pokemon's HP by damage/defensePower.
   * Doesn't allow HP to go less than 0
   * Implementation of "fainting" not done here
   * @param damage Hit points to take off HP
   */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
   }     


   
} //close class