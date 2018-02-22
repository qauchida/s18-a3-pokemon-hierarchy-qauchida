import java.util.*;
/**
*@qauchida
*@since 02/13/18
*Charizard
*/

public class Charizard extends Charmeleon implements FlyingType{
  /** The minimum attack power for species. */ 
   static final int BASE_ATTACK_POWER = 223;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 176;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 156;
   
   protected boolean fastIsFire = true;
   protected boolean specialIsFire = true; 
   
   /** Constructor with no name. */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5,FIRE_TYPE, 
          FLYING_TYPE, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
      chooseFastAttack();
      chooseSpecialAttack();
   }

   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5,FIRE_TYPE,
          FLYING_TYPE,BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
  
   protected Charizard(String species, String name, int num, 
       double ht, double wt,String FIRE_TYPE, String FLYING_TYPE, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, ht, wt, FIRE_TYPE, FLYING_TYPE, 
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      
      //pick Attacks
      chooseFastAttack();
      chooseSpecialAttack();
   }
   protected void chooseFastAttack(){
      Random randGen = new Random();
      int index;
      //set attack type boolean
      fastIsFire = randGen.nextBoolean();
      
      if (fastIsFire) {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { //is poison
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index]; 
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
         fastIsFire = false;  
      }
   }
   protected void chooseSpecialAttack(){
      Random randGen = new Random();
      int index;
      //set attack type boolean
      specialIsFire = randGen.nextBoolean();
      
      if (specialIsFire) {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         specialAttack = FIRE_FAST_ATTACKS[index];
         specialAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { 
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         specialAttack = FLYING_FAST_ATTACKS[index]; 
         specialAttackPower = FLYING_FAST_ATK_POWER[index];
         specialIsFire = false;  
      }
   
   }
   public String performFastAttack(Pokemon victim){
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
     
      if (fastIsFire) {
         if (vType.equals("Grass") || vType.equals("Bug") || vType.equals("Ice")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Fire") || vType.equals("Rock") || vType.equals("Dragon")||vType.equals("Water") ) { 
             
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //is flying attack 
         if (vType.equals("Fighting") || vType.equals("Bug") || vType.equals("Grass")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
            
         } else if (vType.equals("Rock") || vType.equals("Steel") 
             || vType.equals("Electric")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } 
      }
   //       //check for same types for bonus
   //       if (type1.equals(vType) && type2.equals(victim.getType2())) {
   //          modifier = modifier *  1.5;
     //  }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
      
   }
   public String performSpecialAttack(Pokemon victim){
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
      if (specialIsFire) { 
         if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug")|| vType2.equals("Grass")
             || vType2.equals("Bug") || vType2.equals("Ice")
             || vType.equals("Steel") || vType2.equals("Steel")) {
            
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if ( vType.equals("Water")||vType2.equals("Water")
             ||vType2.equals("Rock")||vType2.equals("Dragon")
             || vType.equals("Rock") || vType.equals("Dragon")
             || vType.equals("Fire") || vType2.equals("Fire")) { 
             
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
      } else { //is flying attack 
         if (vType.equals("Fighting") || vType.equals("Bug") || vType.equals("Grass")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
            
         } else if (vType.equals("Rock") || vType.equals("Steel") 
             || vType.equals("Electric")) { 
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
   
} //close class