import java.util.*;
/**
*@qauchida
*@since 02/13/18
*Eevee
*/

public class Eevee extends Pokemon implements NormalType{

   static final int ATTACK = 104;
   static final int DEFENSE = 121;
   static final int STAMINA = 110;

   protected boolean fastIsNormal = true;

   protected boolean specialIsNormal = true;

//constructor w/o name
   public Eevee(){
      super("Eevee", "Eevee", 133, NORMAL_COLOR, 0.3, 6.5,
         NORMAL_TYPE, "",ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack(); 
   
   }

//constructor with name
   public Eevee (String name){
      super("Eevee", name, 133, NORMAL_COLOR, 0.3, 6.5,
         NORMAL_TYPE, "", ATTACK, DEFENSE, STAMINA);
   
      chooseFastAttack();
      chooseSpecialAttack();
   
   }

   protected Eevee(String species, String name, int num, 
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, NORMAL_COLOR, ht, wt, NORMAL_TYPE, 
         "", baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
   
   protected void chooseFastAttack(){
      Random ranNum = new Random();
      int index;
      fastIsNormal = ranNum.nextBoolean();
      index = ranNum.nextInt(NORMAL_FAST_ATTACKS.length);
      fastAttack = NORMAL_FAST_ATTACKS[index];
      fastAttackPower = NORMAL_FAST_ATK_PWR[index];
   
   }
   
   protected void chooseSpecialAttack(){
      Random ranNum = new Random();
      int index;
      specialIsNormal = ranNum.nextBoolean();
      index = ranNum.nextInt(NORMAL_SPECIAL_ATTACKS.length);
      specialAttack = NORMAL_SPECIAL_ATTACKS[index];
      specialAttackPower = NORMAL_SPECIAL_ATK_PWR[index];
         
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
      
      if (vType.equals("Rock") || vType.equals("Steel") ) {
            
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;          
      } else if (vType.equals("Ghost")) { 
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
   
   public String performSpecialAttack(Pokemon victim){
   
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      if (vType.equals("Rock") || vType.equals("Steel") 
             ) {
             
         s = s + "\n It was not very effective.";
         modifier = modifier * .5;          
      } else if (vType.equals("Ghost") ) { 
            
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
   
   protected void beAttacked(int damage){
   
      damage = damage/defensePower;
   
      if(hP> damage){
         hP = hP-damage;
      }else{
         hP = 0;
      }
   
   } //close beAttacked


}//close