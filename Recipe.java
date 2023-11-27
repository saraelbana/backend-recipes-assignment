import java.util.ArrayList;

public class Recipe {
    /* constructors*/
    public Recipe() {
    }

    //declare a recipe obj using the name
    public Recipe(String name) {
    }

    //declare a recipe obj using the name and category
    public Recipe(String name, String Category) {
        this.name = name;
        this.category = getCategory();

    }

    //declare a recipe obj using an array list of ingredients
    public Recipe(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    private String name; // recipe name
    private String category; // appetizer, main dish, side dish or dessert
    private ArrayList<Ingredient> recipeIngredients = new ArrayList<Ingredient>();
    private ArrayList<Step> recipeSteps = new ArrayList<Step>();
    private String servedWith;
    public String prepTime;
    public int servings; // this recipe is for how many ppl
    public String cookingTime;

    public enum FiveStarRating {
        ONE_STAR(1),
        TWO_STARS(2),
        THREE_STARS(3),
        FOUR_STARS(4),
        FIVE_STARS(5);
        private final int value;
        FiveStarRating(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }
    }
   private FiveStarRating rating;

    /* ////////////Setters//////////// */

    //set the recipe name or can be used also to chnage recipe name
    public void setName(String name) {
        this.name = name;
    }

    // set the category of this recipe dessert, main dish, etc...
    public void setCategory(String category) {
        this.category = category;
    }

    //assign a list of ingredients to this object
    public void setRecipeIngredients(ArrayList<Ingredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    //assign a list of steps to this object
    public void setRecipeSteps(ArrayList<Step> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public void betterServedWith(String servedWith) {
        this.servedWith = servedWith;
    }
    public void setRecipeRating(FiveStarRating recipeRating){
        this.rating = recipeRating;
    }

    /* ////////////Getters//////////// */

    //get recipe name
    public String getName() {
        return name;
    }

    //get recipe category as mentioned before dessert, main dish etc...
    public String getCategory() {
        return category;
    }

    public String getServedWithDish() {
        return servedWith;
    }

    // return an arraylist of objects of type Ingredient which is the list of all ingredients
    public ArrayList<Ingredient> getRecipeIngredients() {
        return recipeIngredients;
    }
    //get the recipe rating
    public FiveStarRating getRating() {
        return rating;
    }

    //return how many ingredient the recipe have
    public int recipeIngredientsCount() {
        return recipeIngredients.size();
    }


    // adding a new ingredient to the arraylist of ingredients
    public void addNewIngredient(String ingName, float ingAmount, String ingUnit) {
        Ingredient newIngredient = new Ingredient(ingName, ingAmount, ingUnit);
        this.recipeIngredients.add(newIngredient);
    }

    public void addNewIngredient(String ingName, float ingAmount) {
        Ingredient newIngredient = new Ingredient(ingName, ingAmount);
        this.recipeIngredients.add(newIngredient);
    }

    public void addNewIngredient(String ingName, String ingUnit) {
        Ingredient newIngredient = new Ingredient(ingName, ingUnit);
        this.recipeIngredients.add(newIngredient);
    }

    //add recipe steps
    public void addNewStep(String stepAdded) {
        Step newStep = new Step();
        newStep.setStepProcess(stepAdded);
        recipeSteps.add(newStep);
    }

    // returns true if ingredient found and successfully deleted
    // else return false because it's not found
    public boolean deleteIngredient(String ingName, float ingAmount, String ingUnit) {
        Ingredient searchedForIngredient = new Ingredient(ingName, ingAmount, ingUnit);
        int ingredientFoundIndex = searchForIngredient(searchedForIngredient);
        if (ingredientFoundIndex != -1) {
            recipeIngredients.remove(ingredientFoundIndex);
            return true;
        } else return false;
    }

    // returns true if step found and successfully deleted
    // else return false because it's not found
    public boolean deleteStep(String stepToBeDeleted) {
        //stepToBeDeleted
        int stepFoundIndex = searchForRecipeStep(stepToBeDeleted);
        if (stepFoundIndex != -1) {
            recipeSteps.remove(stepFoundIndex);
            return true;
        } else return false;
    }

    //search for an ingredient and returns its position in the ingredients arrayList
    // a basic sequential search
    private int searchForIngredient(Ingredient searchedForIngredient) {
        for (int i = 0; i < recipeIngredients.size(); i++) {
            if (recipeIngredients.get(i).getName().equalsIgnoreCase(searchedForIngredient.getName())) {
                if (recipeIngredients.get(i).getAmount() == searchedForIngredient.getAmount()) {
                    if (recipeIngredients.get(i).getUnit().equalsIgnoreCase(searchedForIngredient.getUnit())) {

                        return i;
                    }
                }
            }
        }
        return -1;
    }

    //search for a step and returns its position in the steps arrayList
    // a basic sequential search
    private int searchForRecipeStep(String searchedForStep) {
        for (int i = 0; i < recipeSteps.size(); i++) {
            if (recipeSteps.get(i).getStep().equalsIgnoreCase(searchedForStep)) {
                return i;
            }
        }
        return -1;
    }

    //display the recipe ingredients and steps in the terminal
    public void displayRecipe() {
        System.out.println(getName());
        System.out.println("Ingredients:");
        for (int i = 0; i < recipeIngredients.size(); i++) {
            System.out.print("* ");
            recipeIngredients.get(i).displayIngredient();
        }
        System.out.println("Steps:");
        for (int i = 0; i < recipeSteps.size(); i++) {
            System.out.print(i + 1 + " ");
            recipeSteps.get(i).displayStep();
        }

    }
    public void displayRecipeRating(){
        System.out.println("This Recipe rating is " + rating);
    }
}
