import java.util.ArrayList;

public class Main {

    // anyway imagination here is unlimited we can for example in the future create a class of utensils used for the recipes
    // or user reviews

    public static void main(String[] args){

        //declaring an object from Recipe class
        Recipe moltenCakeRecipe = new Recipe();

        /* Adding Ingredients */
        moltenCakeRecipe.addNewIngredient("unsalted butter",1,"stick");
        moltenCakeRecipe.addNewIngredient("bittersweet chocolate",6,"ounces");
        moltenCakeRecipe.addNewIngredient("eggs",2f);
        moltenCakeRecipe.addNewIngredient("egg yolks",2f);
        moltenCakeRecipe.addNewIngredient("cup sugar",0.25f);
        moltenCakeRecipe.addNewIngredient("kosher salt","Pinch");
        moltenCakeRecipe.addNewIngredient("all-purpose flour",2f);

        /* Adding Steps */
        moltenCakeRecipe.addNewStep("Gather the ingredients.");
        moltenCakeRecipe.addNewStep("Preheat oven to 450°F. Butter and lightly flour four 6-ounce ramekins. Tap out excess flour. Set the ramekins on a baking sheet.");
        moltenCakeRecipe.addNewStep("In a double boiler, over simmering water, melt butter with chocolate.");
        moltenCakeRecipe.addNewStep("In a medium bowl, beat eggs with egg yolks, sugar, and salt at high speed until thickened and pale.");
        moltenCakeRecipe.addNewStep("Whisk melted chocolate until smooth.");
        moltenCakeRecipe.addNewStep("Quickly fold it into egg mixture, along with flour.");
        moltenCakeRecipe.addNewStep("Spoon batter into prepared ramekins and bake for 12 minutes, or until sides of cakes are firm but centers are soft.");
        moltenCakeRecipe.addNewStep("Let cakes cool in ramekins for 1 minute, then cover each with an inverted dessert plate. Carefully turn each cake over, let stand for 10 seconds, and then unmold. Serve immediately.");

        //Setting a rating for the recipe
        moltenCakeRecipe.setRecipeRating(Recipe.FiveStarRating.FIVE_STARS);

        //displaying ALL recipe description in the terminal
        moltenCakeRecipe.displayRecipe();
        moltenCakeRecipe.displayRecipeRating();
    }
}
