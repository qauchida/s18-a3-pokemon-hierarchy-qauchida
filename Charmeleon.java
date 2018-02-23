/**
*@qauchida
*@since 02/13/18
*Charmeleon
*/

public class Charmeleon extends Charmander {
/** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 158;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 129;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 116;
   
   /** Constructor with no name. */
   public Charmeleon() {
      super("Charmeleon", "Charmeleon", 5, 1.1, 19.0, FIRE_TYPE, NULL_TYPE,
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   
   /**
   * Constructor with name.
   * @param name based on user input
   */
   public Charmeleon(String name) {
      super("Charmeleon", name, 5, 1.1, 19.0,FIRE_TYPE, NULL_TYPE,
          BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }

   /**
   *constructor.
   *
   */
   protected Charmeleon(String species, String name, int num, double ht, 
       double wt, String FIRE_TYPE, String NULL_TYPE, int baseAttackPwr, 
       int baseDefensePwr, int baseStaminaPwr) {
      
      super(species, name, num, ht, wt, FIRE_TYPE, NULL_TYPE, baseAttackPwr, 
          baseDefensePwr, baseStaminaPwr);
   }
   
}