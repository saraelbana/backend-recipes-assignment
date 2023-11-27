public class Ingredient {
    public Ingredient() {
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
                    this.unit = "gm";
                }
                return succeededToConvert;
                break;
            case "gm":
                if (this.unit.equals("cup")) {
                    //1 cup= 110 gram
                    this.amount *= 110f;
                } else if(this.unit.equals("km")) {
                   //1 kilogram = 1000 grams
                    this.amount *= 1000f;
                }
                return succeededToConvert;
                break;
            case "cup":
                if (unit == "gm") {
                    // 1/4 of a cup is the smallest measure for cup no recipe can be done
                    // in a "cup measurement" less than 1/4 cup which is 60 grams
                    if(this.amount < 60f){
                        succeededToConvert = -1;
                        break;
                    }
                } else if (unit == "km") {
                    //1 gram = 0.001 kilograms
                }
                return succeededToConvert;
                break;
            default:
                return succeededToConvert;
                break;
        }
    }

}
