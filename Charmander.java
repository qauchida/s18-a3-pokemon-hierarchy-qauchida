import java.util.*;
/**
*@qauchida
*@since 02/07/18
*makes charmander
*/

public class Charmander extends Pokemon implements FireType{

   static final int ATTACK = 94;
   static final int DEFENSE = 122;
   static final int STAMINA = 88; 
   
   protected boolean fastIsFire = true;
   protected boolean specialIsFire = true;
   
   /**no name constructor 
   */
   public Charmander(){
      super("Charmander","Charmander", 7, FIRE_COLOR, 0.5, 9.0, 
         FIRE_TYPE,"", ATTACK, DEFENSE, STAMINA);
      chooseFastAttack();
      chooseSpecialAttack();
   } // close constructor
   
      /**with name constructor 
   */
   public Charmander(String name){
      super("Charmander","Charmander", 7, FIRE_COLOR, 0.5, 9.0, 
         FIRE_TYPE, "",ATTACK, DEFENSE, STAMINA);
      chooseFastAttack();
      chooseSpecialAttack();
   } // close constructor
   
   protected Charmander(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, FIRE_COLOR, ht, wt, FIRE_TYPE,"", 
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
      fastIsFire = randGen.nextBoolean();
          
      index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   
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
      if (fastIsFire) { //if attack is grass-type
         if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Dragon") 
             || vType.equals("Ground") || vType.equals("Dragon")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
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
   * Game-play special attack simulation.
   * Creates an output String stating attack details
   * checks for weakness/strength adjustment based on 
   * victim Pokemon's type and attack type
   * (only need to check latter for dual-type)
   * uses Damage formula from here: 
   * http://bulbapedia.bulbagarden.net/wiki/Damage
   * Calls beAttacked method on attacked victim.
   * @param victim the Pokemon being attacked.
   * @return String explaining attack and effectiveness.
   */
   protected void chooseSpecialAttack() {
     //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;
      //set type choice boolean
      specialIsFire = randGen.nextBoolean();
   }

   
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
      
      //check effectiveness of attack
      if (specialIsFire) { //if attack is water-type
         if (vType.equals("Bug") || vType.equals("Grass") 
             || vType.equals("Ice")) {
             
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Water") || vType.equals("Dragon")
             || vType.equals("Ground") || vType.equals("Dragon"))
         { 
            
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //is poison attack
         if (vType.equals("Fire") || vType.equals("Fairy")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
            
         } else if (vType.equals("Rock") || vType.equals("Ghost") 
             || vType.equals("Ground") || vType.equals("Poison")) {
             
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } else if (vType.equals("Steel")) { 
            s = s + "\n It had no effect.";
            modifier = 0; //will zero whole calculation
         }
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