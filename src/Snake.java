import java.util.Random;
import java.util.ArrayList;

public class Snake extends Animal {
    static protected int numOfThisSpecies = 0;
    
    public Snake(String name){
        numOfThisSpecies++;
        Random rand = new Random();
        energyLevel = rand.nextInt(7)+1;
        this.name = name;
        animalType = AnimalTypeEnum.SNAKE;
    }

    @Override
    public void MakeSound(){
            // print "snake sound"
        System.out.println(name + " is snake, SISSSSSS");
        super.MakeSound();
    }
    @Override
    public void EatFood(FoodTypeEnum meal){
        System.out.println(name + " will eat anything!  YUM!!!\n");
        super.EatFood(meal);
    }
    @Override
    public void GoToSleep(){
        System.out.println(name + " may have thier eyes open, but yes, they am sleeping\n");
        super.GoToSleep();
    }

    @Override
    public ArrayList<Animal> Mate(){
        ArrayList<Animal> returnList = new ArrayList<Animal>();

        if (1 < numOfThisSpecies){
            System.out.println("Let's see if we can over populate the jungle");
            Random rand = new Random();
            int randomInt = rand.nextInt(150) + 1;
            for (int i = 0; i < randomInt; ++i){
                returnList.add(new Snake("Snake " + numOfThisSpecies));
            }
            System.out.println("There are now " + numOfThisSpecies + " Snakes.\n");
        }
        else{
            System.out.println("Guess I'll slide down on myself...");
            System.out.println("There is only "+ numOfThisSpecies + " Snake\n");
        }
        return returnList;
    }
    static int GetNumOfThisSpecies(){return numOfThisSpecies;}
}