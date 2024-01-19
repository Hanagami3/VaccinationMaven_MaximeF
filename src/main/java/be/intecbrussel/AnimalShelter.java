package be.intecbrussel;

import be.intecbrussel.Animal.Animal;
import be.intecbrussel.Care.Disease;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AnimalShelter {

    private int animalID;

    private List<Animal> animals;



    public AnimalShelter() {
        animals = new ArrayList<>();
        animalID = 10; //better 0
    }

    public AnimalShelter(int animalID) {
        animals = new ArrayList<>();
        this.animalID = animalID;
    }


    public List<Animal> getAnimals() {
        return animals;
    }



    public void printAnimals(){
        animals.forEach(System.out::println);
    }

    public void sortAnimals(){
        animals = animals.stream()
                .sorted(Animal::compareTo)
                .toList();
    }

    public void sortAnimalsByName(){
        animals = animals.stream()
                .sorted(Comparator.comparing(a -> a.getName()))
                .toList();
    }

    public void sortAnimalsByAge(){
        animals = animals.stream()
                .sorted(Comparator.comparing(a -> a.getAge()))
                .toList();
    }

    public void  printAnimalNotVaccinated(Disease disease){
        animals.stream()
                .filter(a -> a.getIsVaccinated().get(disease).equals(false))
                .map(a -> a.getName())
                .forEach(System.out::println);
    }

    public Optional<Animal> findAnimal(int animalNumber){
        Animal unknown = new Animal() {};
        return Optional.of(
                animals.stream()
                .filter(a -> a.getAnimalNumber() == animalNumber)
                        //.findFirst
                .findAny()
                .orElse(unknown)
        );
    }

    public Optional<Animal> findAnimal(String name) {
        Animal unknown = new Animal() {};
        return Optional.of(
                animals.stream()
                .filter(a -> a.getName().equals(name))
                .findAny()
                .orElse(unknown)
        );
    }

    public void treatAnimal(int animalNumber){
        boolean isKnown = false;
        for (Animal animal : animals)
            if (animal.getAnimalNumber() == animalNumber) {
                animal.treatAnimal();
                isKnown = true;
            }
        if (!isKnown);
    }

    public void treatAnimal(String name){
        boolean isKnown = false;
        for (Animal animal : animals)
            if (animal.getName().equals(name)) {
                animal.treatAnimal();
                isKnown = true;
            }
        if (!isKnown)
            System.out.println("De dier bestaat niet\n");
    }

    public void treatAllAnimal(){
        for (Animal animal : animals)
            animal.treatAnimal();
    }

    public Animal findOldestAnimal(){
        return animals.stream()
                .max(Comparator.comparing(Animal::getAge)
                .thenComparing(Animal::getAnimalNumber))
                .get();
    }

    public int countAnimals(){
        return animals.size();
    }

    public void addAnimal(Animal animal){
        if (animal != null) {
            animal.setAnimalNumber(animalID);
            animals.add(animal);
            animalID++;
        }
    }
}
