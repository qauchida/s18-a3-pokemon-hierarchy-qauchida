import java.util.*;
/**
* @qauchida
* @since 02/22/18
* flareon
*/

public class Flareon extends Eevee implements FireType, NullType {
   /** base attack power.*/
   static final int ATTACK = 246;
   /** base defense power.*/
   static final int DEFENSE = 204;
   /** base stamina power.*/
   static final int STAMINA = 130;

   /** Boolean to choose type of fast attack.*/
   protected boolean fastIsFire = true;
   /** Boolean to choose type for special attack.*/
   protected boolean specialIsFire = true;

   /**
   * Constructor w/o name.
   */
   public Flareon() {
      super("Flareon", "Flareon", 136, 0.9, 25.0, 
            FIRE_TYPE, NULL_TYPE, ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack(); 
   
   }

   /**
   * Constructor w/ name.
   * @param name Pokemon name based on user input
   */
   public Flareon(String name) {
      super("Flareon", name, 136, 0.9, 25.0, FIRE_TYPE, NULL_TYPE,
         ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack();
   
   }
   
   /**
   * constructor.
   * @param species Pokemon's species
   * @param name Pokemon's name
   * @param num Pokemon's number
   * @param FIRE_TYPE fire type interface
   * @param NULL_TYPE null type interface
   * @param ht Pokemon's height in m
   * @param wt Pokemon's weight in kg
   * @param baseAttackPwr found on silph road
   * @param baseDefensePwr found on silph road
   * @param baseStaminaPwr found on silph road
   */
   protected Flareon(String species, String name, int num, 
       double ht, double wt, String FIRE_TYPE, String NULL_TYPE,
       int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
       
      super(species, name, num, ht, wt, FIRE_TYPE, 
         NULL_TYPE, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
   
   /**
   * Method to choose fast attack.
   */
   protected void chooseFastAttack() {
   
      Random ranNum = new Random();
      int index;
      
      fastIsFire = ranNum.nextBoolean();
      index = ranNum.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   
   }
   /**
   * Method to choose special attack.
   */
   protected void chooseSpecialAttack() {
      Random ranNum = new Random();
      int index;
      
      specialIsFire = ranNum.nextBoolean();
      index = ranNum.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
         
   }
   
   /**
   * Method to do fast attack.
   * @return String result of attack
   * @param victim Pokemon being attacked
   */
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
      
      if (vType.equals("Ground") || vType.equals("Steel")) {
            
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;          
      } 
      if (vType.equals("Water")) {
         modifier = modifier * 2.0;
         s = s + "\n It was super effective!";
      } else if (vType.equals("Rock")) { 
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
   
   /**
   * Method to do special attack.
   * @return String result of attack
   * @param victim Pokemon being attacked
   */
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
      if (vType.equals("Ground") || vType.equals("Steel")) {
             
         s = s + "\n It was not very effective.";
         modifier = modifier * .5;          
      } 
      if (vType.equals("Water")) {
      
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      
      } else if (vType.equals("Electric")) { 
            
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
   
   /**
   * Method to calculate damage.
   * @param damage amount of hp lost
   */
   protected void beAttacked(int damage) {
   
      damage = damage / defensePower;
   
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0;
      }
   
   } //close beAttacked
}
