import java.util.ArrayList;
import java.util.Random;

public class Monkey extends Animal {
    Boolean isPlaying;
    static protected int numOfThisSpecies = 0;
    
    public Monkey(String name){
        numOfThisSpecies++;
        Random rand = new Random();
        energyLevel = rand.nextInt(10)+1;
        isPlaying = false;
        this.name = name;
        animalType = AnimalTypeEnum.MONKEY;
    }

    @Override
    public void MakeSound(){
        if (isPlaying){
            if (8 <= energyLevel){
                System.out.println("Oooo Oooo Oooo");
                energyLevel -= 8;
            }
            else{
                // print "The Monkey is too tired"
                System.out.println(name + " is too tired");
            }
        }
        else{
            System.out.println(name + " is monkey, AND THE PRINCE OF ALL SAIYANS");
            energyLevel -= 4;
        }
    }
    @Override
    public void EatFood(FoodTypeEnum meal){
        System.out.println(name.toUpperCase() + " EAT EVERYTHING!!!\n");
        energyLevel += 2;
    }
    @Override
    public void GoToSleep(){
        System.out.println(name + " go night-night\n");
        super.GoToSleep();
    }
    public void Play(){
        isPlaying = true;
        this.MakeSound();
        isPlaying = false;
    }
    @Override
    public ArrayList<Animal> Mate(){
        ArrayList<Animal> returnList = new ArrayList<Animal>();
        if (1 < numOfThisSpecies){
            System.out.println("WE WILL REPOPULATE THE SAIYAN RACE!");
            Random rand = new Random();
            int randomInt = rand.nextInt(2) + 1;
            for (int i = 0; i < randomInt; ++i){
                returnList.add(new Monkey("Monkey " + numOfThisSpecies));
            }
            System.out.println("There are now " + numOfThisSpecies + " Monkies.\n");
        }
        else{
            System.out.println("I AM THE LAST OF THE SAIYANS!");
            System.out.println("There is only "+ numOfThisSpecies + " Monkey\n");
        }
        return returnList;
    }

    static int GetNumOfThisSpecies(){return numOfThisSpecies;}
}