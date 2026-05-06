/** 
 * A class representing damage for dnd 3.5
*/
public class dndDamage {
    private int damage;
    private damageTypeEnum type;
    private dndDamage additional;

    /**
     * default constructor. 
     * creates a 0 damage slash attack
     */
    public dndDamage()
    {
        this(0,/*add the enum type here */,null);
    }
    /**
    *Constructor for dndDamage.
    *@param givenDamage the numeral value of the damage dealt as an int.
    *@param givenType the type of damage being dealt using as a damageTypeEnum.
    */
    public dndDamage (int givenDamage, damageTypeEnum givenType)
    {
        this(givenDamage,givenType,null);
    }

    /**
    *Canonical Constructor for dndDamage.
    *@param givenDamage the numeral value of the damage dealt as an int.
    *@param givenType the type of damage being dealt using as a damageTypeEnum.
    *@param extraDamage any additional damage such as additional damage types.
    */
    public dndDamage (int givenDamage, damageTypeEnum givenType, dndDamage extraDamage)
    {
        damage = givenDamage;
        type = givenType;
        additional=extraDamage;
    }

    /**
     *gets the amount of damage dealt
     *@return int the amount of damage.
     */
    public int getDamageValue()
    {
        return damage;
    }

    /**
     *gets the type of damage dealt for the sake of resistences or weaknesses
     *@return damageTypeEnum the type of the damage
     */
    public damageTypeEnum getDamageType()
    {
        return type;
    }

    /**
    *@return boolean true if this damage has additional damage
    */
    public boolean hasAdditionalDamage()
    {
        return !(additional==null);
    }

    /**
    *@return boolean true if this damage has additional damage
    */
    public dndDamage getAdditionalDamage()
    {
        return additional;
    }
}
