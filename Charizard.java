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
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, BASE_ATTACK_POWER, 
          BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
   /** Constructor with name.
   * @param name The user-defined name.
   */
   public Charizard(String name) {
         super("Charizard", name, 6, 1.7, 90.5, BASE_ATTACK_POWER, 
            BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
   }

} //close class