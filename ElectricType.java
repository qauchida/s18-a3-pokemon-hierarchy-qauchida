/**
*@qauchida
*@since 02/13/18
*elecric type interface
*/

public interface ElectricType {
   /** constants **/
   /** Type name String. */
   String ELECTRIC_TYPE = new String("Electric");
   /**Type color String. */
   String ELECTRIC_COLOR = new String("Yellow");
   /**Array of type fast attacks. */
   String[] ELECTRIC_FAST_ATTACKS = {"Volt Switch", 
      "Thundershock", "Thunder Wave", "Spark"};
   /**Array of type special attacks. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Thunder", 
      "Thunderbolt", "Discharge"};
   /**Array of fast attack powers. */
   int [] ELECTRIC_FAST_ATK_POWER = {20, 5, 0, 3};
   /**Array of special attack powers. */
   int [] ELECTRIC_SPECIAL_ATK_POWER = {100, 80, 65};
}