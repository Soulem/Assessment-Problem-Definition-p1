import java.util.ArrayList;

abstract class Animal {
    public enum FoodTypeEnum{
        MEAT, FISH, BUGS, GRAIN, NUM_FOOD_TYPE, INVALID;
        public static FoodTypeEnum FromInteger(int x) {
            switch (x) {
                case 0: {
                    return MEAT;
                }
                case 1: {
                    return FISH;
                }
                case 2: {
                    return BUGS;
                }
                case 3:{
                    return GRAIN;
                }
                default: {
                    return INVALID;
                }
            }
        }
    }

    public enum AnimalActionEnum {
        EAT_FOOD, MAKE_SOUND, GO_TO_SLEEP, MATE, PLAY, NUM_ACTIONS, INVALID;

        public static AnimalActionEnum FromInteger(int x) {
            switch (x) {
                case 0: {
                    return EAT_FOOD;
                }
                case 1: {
                    return MAKE_SOUND;
                }
                case 2: {
                    return GO_TO_SLEEP;
                }
                case 3:{
                    return MATE;
                }
                case 4:{
                    return PLAY;
                }
                default: {
                    return INVALID;
                }
            }
        }
    }
    
    public enum AnimalTypeEnum {
        MONKEY, SNAKE, TIGER, NUM_ANIMALS, INVALID;

        public static AnimalTypeEnum FromInteger(int x) {
            switch (x) {
                case 0: {
                        return MONKEY;
                }
                case 1: {
                    return SNAKE;
                }
                case 2: {
                    return TIGER;
                }
                default: {
                    return INVALID;
                }
            }
        }
    }
    
    protected AnimalTypeEnum animalType; 
    protected int energyLevel;
    protected String name;

    abstract ArrayList<Animal> Mate();

    public Animal(){

    }

    public void MakeSound(){
        energyLevel -= 3;
    }
    public void EatFood(FoodTypeEnum meal){
        energyLevel += 5;
    }
    public void GoToSleep(){
        energyLevel += 10;
    }

    int GetEnergyLevel() {return energyLevel;}
    AnimalTypeEnum GetAnimalType(){return animalType;}
    String GetName(){return name;}
    void SetEnergyLevel(int energyLevel){this.energyLevel = energyLevel;}
}