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
      WATER_TYPE, ATTACK, DEFENSE, STAMINA);
   chooseFastAttack();
   chooseSpecialAttack();
   } // close constructor
   
      /**with name constructor 
   */
   public Squirtle(String name){
      super("Squirtle","Squirtle", 7, WATER_COLOR, 0.5, 9.0, 
      WATER_TYPE, ATTACK, DEFENSE, STAMINA);
   chooseFastAttack();
   chooseSpecialAttack();
   } // close constructor
   
      protected Squirtle(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, GRASS_COLOR, ht, wt, WATER_TYPE, 
      baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      //pick Attacks
      //can happen here because all subclasses are same types as Bulbasaur
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
    protected void chooseFastAttack() {
      //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsWater = randGen.nextBoolean();
          
         index = randGen.nextInt(WATER_FAST_ATTACKS.length);
         fastAttack = WATER_FAST_ATTACKS[index];
         fastAttackPower = WATER_FAST_ATK_POWER[index];

      }
   }
   

   
} //close class