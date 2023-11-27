public class Step {
    /*constructors*/
    public Step(){}
    public Step(String category){
        this.category = category;
    }


    //what kind of recipe step is this (preparation, cooking, post cooking handling)
    private String category;

    //a string that holds a description of the recipe step
    private String stepProcess;

    /*Setters*/

    //what kind of recipe step is this (preparation, cooking, post cooking handling)
    public void setCategory(String category){
        this.category = category;
    }
    public void setStepProcess(String stepProcess){
        this.stepProcess = stepProcess;
    }

    /*Getters*/
    public String getStep(){
        return stepProcess;
    }
    public String getThisStepCategory() {
        return category;
    }

}
