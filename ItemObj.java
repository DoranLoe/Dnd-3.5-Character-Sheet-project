/** 
 * Class representing a DND 3.5 item
*/
public class ItemObj{
    public final String NAME;
    public final String DESC;
    public final double WEIGHT;
    public final int COST;

    /**
     * Canonical constructor for the DND 3.5 item
     * @param name the name of the item as a string
     * @param desc a short description of the item as a string
     * @param weight the weight of the item in pounds as a double
     * @param cost the cost of the item in copper as an int
    */
    public ItemObj(String name, String desc, double weight, int cost)
    {
        if (name == null)
            name = "MissingName";
        if (desc == null)
            desc = "MissingDesc";
        NAME = name;
        DESC = desc;
        WEIGHT = weight;
        COST = cost;
    }

    /**
     * Default constructor for the DND 3.5 item.
     * Creates an item with MissingName, MissingDesc, 0 weight, medium size, and 0 cost
     */
    public ItemObj()
    {
        this(new String(),new String(),0.0,0);
    }
    
    /**
     * Constructor for items that are free
     * @param name String
     * @param desc String
     * @param weight double
     */
    public ItemObj(String name,String desc, double weight)
    {
        this(name,desc,weight,0);
    }
    /**
     * Constructor for items that are weightless
     * @param name String
     * @param desc String
     * @param cost int
     */
    public ItemObj(String name, String desc, int cost)
    {
        this(name,desc,0.0,cost);
    }
    /**
     * Constructor for items that are free and weightless
     * @param name String
     * @param desc String
     */
    public ItemObj(String name, String desc)
    {
        this(name,desc,0);
    }
    /**
     * Constructor for self explanitory items with no weight or value
     * @param name string
     */
    public ItemObj(String name)
    {
        this(name,new String());
    }

    /**
     * Constructor that copies the data of another ItemObj
     * @param copy
     */
    public ItemObj(ItemObj copy)
    {
        this(copy.NAME,copy.DESC,copy.WEIGHT,copy.COST);
    }

    /**
     * Items that are sized quadruple their weight when Enlarge Person is cast on the person that has them.
     * @return ItemObj The enlarged version of this item
     */
    public ItemObj createEnlargedItem()
    {
        return new ItemObj(NAME,DESC+"\nEnlarged one size category",WEIGHT*4,COST);
    }

    /**
     * Items that are sized quarter their weight when Reduce Person is cast on the person that has them.
     * @return ItemObj The reduced version of this item
     */
    public ItemObj createReducedItem()
    {
        return new ItemObj(NAME,DESC+"\nReduced one size category.",WEIGHT/4,COST);
    }

    /**
     * removes any size category modifications done to this item.
     * @return ItemObj An ItemObj with the same data as an object befroe getEnlargedItem() or getReducedItem() was used.
     */
    public ItemObj createOriginalSizedItem()
    {
        ItemObj rtn = new ItemObj(this);
        if (DESC.length()>27)
        {
            if (DESC.substring(DESC.length()-27,DESC.length()).equals("\nReduced one size category.")){
                rtn = new ItemObj(NAME,DESC.substring(0,DESC.length()-27),WEIGHT*4,COST);
                rtn = rtn.createOriginalSizedItem();
            }
            else if (DESC.substring(DESC.length()-27,DESC.length()).equals("\nEnlarged one size category")){
                rtn = new ItemObj(NAME,DESC.substring(0,DESC.length()-27),WEIGHT/4,COST);
                rtn = rtn.createOriginalSizedItem();
            }
        }
        return rtn;
    }

    public ItemObj duplicate()
    {
        return new ItemObj(this);
    }

    public String toString()
    {
        return NAME+": \n"+DESC+"\nWeight: "+WEIGHT+"\nCost: "+COST;
    }
}