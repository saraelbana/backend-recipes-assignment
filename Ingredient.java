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

    public void changeUnit(String newUnit) {

        //this is a basic example of common metric cooking conversions
        //that can be expanded to many more in details
        //most probably then will be needed to be handled in a different class that
        //handles all the conversions separately
        newUnit = newUnit.toLowerCase();
        switch (newUnit) {
            case "kg":
                //assuming that the only accepted units for solid ingredients kg, gm, & cup
                //convert from current unit to kg
                if (unit == "cup") {
                    //1 c = 0.24
                } else if (unit == "gm") {
                    //1 cup: 240 gram
                }
                break;
            case "gm":
                if (unit == "cup") {
                    //1 cup= 110 gram
                } else if (unit == "km") {
                   //1 gram = 0.001 kilograms
                }
                break;
            case "cup":
                if (unit == "gm") {
                    //1 cup= 110 gram
                } else if (unit == "km") {
                    //1 gram = 0.001 kilograms
                }
                break;
            default:
                break;
        }
    }

}
