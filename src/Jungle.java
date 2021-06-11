import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Jungle {
    private HashMap<Animal.AnimalTypeEnum, ArrayList<Animal>> animalMap = new HashMap<Animal.AnimalTypeEnum, ArrayList<Animal>>();

    public Jungle(){
        Random rand = new Random();
        int upperBound = 21;
        int randNumToGenerate = rand.nextInt(upperBound);
        for (int i = 0; i < randNumToGenerate; ++i) {
            Animal.AnimalTypeEnum randAnimal = Animal.AnimalTypeEnum.FromInteger(rand.nextInt(Animal.AnimalTypeEnum.NUM_ANIMALS.ordinal()));
            switch (randAnimal) {
                case MONKEY: {
                    if (!animalMap.containsKey(randAnimal)) {
                        animalMap.put(randAnimal, new ArrayList<Animal>());
                    }
                    animalMap.get(randAnimal).add(new Monkey("Monkey " + i));
                    break;
                }
                case SNAKE: {
                    if (!animalMap.containsKey(randAnimal)) {
                        animalMap.put(randAnimal, new ArrayList<Animal>());
                    }
                    animalMap.get(randAnimal).add(new Snake("Snake " + i));
                    break;
                }
                case TIGER: {
                    if (!animalMap.containsKey(randAnimal)) {
                        animalMap.put(randAnimal, new ArrayList<Animal>());
                    }
                    animalMap.get(randAnimal).add(new Tiger("Tiger " + i));
                    break;
                }
                default: {

                }
            }
        }
    }

    public void SoundOff() {
        // call each animal's MakeSound method
        // and print out their energyLevel
        ArrayList<Animal> allAnimals = new ArrayList<Animal>();
        for (Animal.AnimalTypeEnum animalType : animalMap.keySet()){
            allAnimals.addAll(animalMap.get(animalType));
        }
        for (Animal ani : allAnimals){
            ani.MakeSound();
            System.out.println("Energy level is at: " + ani.GetEnergyLevel() + " energy\n");
        }

    }

    public void DoRandomAction() {
        ArrayList<Animal> allAnimals = new ArrayList<Animal>();

        for (Animal.AnimalTypeEnum animalType : animalMap.keySet()){
            allAnimals.addAll(animalMap.get(animalType));
        }

        Random rand = new Random();
        
        for (Animal ani : allAnimals){
            Animal.AnimalActionEnum randAction = Animal.AnimalActionEnum.FromInteger(rand.nextInt(Animal.AnimalActionEnum.NUM_ACTIONS.ordinal()));
            if (Animal.AnimalTypeEnum.MONKEY == ani.GetAnimalType()){
                switch (randAction){
                    case EAT_FOOD:{
                        Animal.FoodTypeEnum randMeal = Animal.FoodTypeEnum.FromInteger(rand.nextInt(Animal.FoodTypeEnum.NUM_FOOD_TYPE.ordinal()));
                        ani.EatFood(randMeal);
                        break;
                    }
                    case MAKE_SOUND:{
                        ani.MakeSound();
                        break;
                    }
                    case GO_TO_SLEEP:{
                        ani.GoToSleep();
                        break;
                    }
                    case MATE:{
                        animalMap.get(Animal.AnimalTypeEnum.MONKEY).addAll(ani.Mate());
                        break;
                    }
                    case PLAY:{
                        ((Monkey)ani).Play();
                        break;
                    }
                    default:{
    
                    }
                }      
            }
            else{
                switch (randAction){
                    case EAT_FOOD:{
                        Animal.FoodTypeEnum randMeal = Animal.FoodTypeEnum.FromInteger(rand.nextInt(Animal.FoodTypeEnum.NUM_FOOD_TYPE.ordinal()));
                        ani.EatFood(randMeal);
                        break;
                    }
                    case MAKE_SOUND:{
                        ani.MakeSound();
                        break;
                    }
                    case PLAY:{
                        ani.MakeSound();
                        break;
                    }
                    case GO_TO_SLEEP:{
                        ani.GoToSleep();
                        break;
                    }
                    case MATE:{
                        switch(ani.GetAnimalType()){
                            case SNAKE:{
                                animalMap.get(Animal.AnimalTypeEnum.SNAKE).addAll(ani.Mate());
                                break;
                            }
                            case TIGER:{
                                animalMap.get(Animal.AnimalTypeEnum.TIGER).addAll(ani.Mate());
                                break;
                            }
                            default:{

                            }
                        }
                        break;
                    }
                    default:{
    
                    }
                }
            }
        }
    }
}