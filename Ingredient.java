public class Ingredient {
    public Ingredient() {
    }

    public Ingredient(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }
    //this is a special constructor for a pinch of salt ingredient
    public Ingredient(String name, String unit) {
        this.name = name;
        this.unit = unit.toLowerCase();
    }
    public Ingredient(String name, float amount, String unit) {
        this.name = name;
        this.unit = unit.toLowerCase();
        this.amount = amount;
    }

    private float amount;
    private String unit;
    private String name;
    private int succeededToConvert = 1;

    /*setters*/

    //in order to set the amount user needs to define the unit as well
    public void setAmount(float amount, String unit) {
        this.amount = amount;
        this.unit = unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* Getters */

    public float getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }

    // change from metric system to another basically from cup to grams or kgs
    //if succeeded returns 1 else if failed returns -1
    public int changeUnit(String newUnit) {

        //this is a basic example of common metric cooking conversions
        //that can be expanded to many more in details
        //most probably then will be needed to be handled in a different class that
        //handles all the conversions separately
        newUnit = newUnit.toLowerCase();
        switch (newUnit) {
            case "kg":
                //assuming that the only accepted units for solid ingredients kg, gm, & cup
                //convert from current unit to kg
                if (this.unit.equals("cup")) {
                    //1 c = 0.24
                    this.amount *= 0.24f;
                    unit = "kg";
                } else if (this.unit.equals("gm")) {
                    //1 cup= 240 gram
                    this.amount *=240f;
                    this.unit = "km";
                }
                return succeededToConvert;

            case "gm":
                if (this.unit.equals("cup")) {
                    //1 cup= 110 gram
                    this.amount *= 110f;
                    this.unit = "gm";
                } else if(this.unit.equals("km")) {
                   //1 kilogram = 1000 grams
                    this.amount *= 1000f;
                    this.unit = "gm";
                }
                return succeededToConvert;

            case "cup":
                if (this.unit.equals("gm")) {
                    // 1/4 of a cup is the smallest measure for cup no recipe can be done
                    // in a "cup measurement" less than 1/4 cup which is 60 grams
                    if(this.amount < 60f){
                        return succeededToConvert = -1;
                    }
                    else{
                        // 240 gm = 1 cup
                        this.amount /= 240f;
                        this.unit = "cup";
                        return succeededToConvert;
                    }
                } else if (this.unit.equals("km")) {
                    // 1kg = 4.25 cups
                    this.amount /= 4.25f;
                    this.unit = "cup";
                    return succeededToConvert;
                }
            default:
                succeededToConvert = -1;
                return succeededToConvert;
        }
    }

    public void displayIngredient(){
        System.out.println(getAmount() + " " + getUnit() + " " + getName());
    }

}
