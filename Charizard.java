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
   
   /** Constructor with no name. */
   //need to override inherited interface NullType with FlyingType
   public Charizard() {
        super("Charizard", "Charizard", 6, 1.7, 90.5,FIRE_TYPE, 
          FLYING_TYPE, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5,FIRE_TYPE,
          FLYING_TYPE,BASE_ATTACK_POWER,
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }
   
    protected Charizard(String species, String name, int num, 
       double ht, double wt,String FIRE_TYPE, String FLYING_TYPE, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
       
      super(species, name, num, ht, wt, FIRE_TYPE, FLYING_TYPE, 
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);
      //pick Attacks
      //can happen here because all subclasses are same types as Bulbasaur
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
   
} //close class