import java.util.Random;
import java.util.ArrayList;

public class Tiger extends Animal {
    static protected int numOfThisSpecies = 0;

    public Tiger(String name){
        numOfThisSpecies++;
        Random rand = new Random();
        energyLevel = rand.nextInt(15)+1;
        this.name = name;
        animalType = AnimalTypeEnum.TIGER;
    }

    @Override
    public void MakeSound(){
        System.out.println("I, " + name +  ", am tiger, ROAR");
        super.MakeSound();
    }
    @Override
    public void EatFood(FoodTypeEnum meal){
        if (FoodTypeEnum.GRAIN == meal){
            // tigers don't eat grain
        System.out.println(name + " is too majestic for grain\n");
            return;
        }
        super.EatFood(meal);
    }
    @Override
    public void GoToSleep(){
        System.out.println(name + " will bite you if you disturb my slumber\n");
        energyLevel += 5;
    }
    @Override
    public ArrayList<Animal> Mate(){
        ArrayList<Animal> returnList = new ArrayList<Animal>();

        if (1 < numOfThisSpecies){
            System.out.println("Time for a kittle cut-tle");
            Random rand = new Random();
            int randomInt = rand.nextInt(2) + 2;
            for (int i = 0; i < randomInt; ++i){
                returnList.add(new Tiger("Tiger " + numOfThisSpecies));
            }
            System.out.println("There are now " + numOfThisSpecies + " Tigers.\n");
        }
        else{
            System.out.println("I'm pawl alone :(");
            System.out.println("There is only " + numOfThisSpecies + " Tiger\n");
        }
        return returnList;
    }
    static int GetNumOfThisSpecies(){return numOfThisSpecies;}
}