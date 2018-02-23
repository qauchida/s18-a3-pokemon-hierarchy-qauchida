/**
*@qauchida
*@since 02/13/18
*normal type interface
*/
public interface NormalType {
   /**String for name of type.*/
   String NORMAL_TYPE = ("Normal");
   /**String for color of type.*/
   String NORMAL_COLOR = ("Brown");
   /**Array of fast attacks.*/
   String [] NORMAL_FAST_ATTACKS = {"Quick Attack", "Tackle","Scratch"};
   /**Array of special attacks.*/
   String [] NORMAL_SPECIAL_ATTACKS = {"Body Slam","Double-edge"};
   /**Array of damage values for fast attacks.*/
   int [] NORMAL_FAST_ATK_PWR = {15,5,5};
   /**Array of damage values for special attacks.*/
   int [] NORMAL_SPECIAL_ATK_PWR = {50,150};
} //close