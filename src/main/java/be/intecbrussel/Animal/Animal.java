package be.intecbrussel.Animal;

import be.intecbrussel.Care.Disease;
import be.intecbrussel.Care.Treatable;
import be.intecbrussel.Care.Vaccinateable;

import java.util.*;

public abstract class Animal implements Vaccinateable, Treatable, Comparable<Animal> {

    private int age;
    private String name;
    private int animalNumber;

    private boolean isClean;

    private Map<Disease, Boolean> isVaccinated;



    public Animal() {
        age = 0;
        name = "UNKNOWN";
        animalNumber = 0;
        isClean = false;
        isVaccinated = new HashMap<>();
        setIsVaccinated();
    }


    public Animal(int age, String name, boolean isClean) {
        setAge(age);
        this.name = name;
        this.animalNumber = 0;
        this.isClean = isClean;
        isVaccinated = new HashMap<>();
        setIsVaccinated();

    }


    // <editor-fold desc=" 'simple' getters and setters" >
    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public Map<Disease, Boolean> getIsVaccinated() {
        return isVaccinated;
    }
    // </editor-fold>


    public void setAge(int age) {
        if (age < 0)
            age = 0;
        if (age > 100)
            age = 100;
        this.age = age;
    }

    public void setIsVaccinated() {
        isVaccinated.put(Disease.CHICKENPOCKS,false);
        isVaccinated.put(Disease.FLUE, false);
        isVaccinated.put(Disease.POLIO, false);
        isVaccinated.put(Disease.HEPATITISA, false);
    }

    @Override
    public void vaccinateAnimal(Disease disease) {
        isVaccinated.replace(disease, true);
        System.out.println(getClass().getSimpleName() + " " + name +" is gevaccineerd tegen " + disease.toString().toLowerCase() );
    }

    @Override
    public void treatAnimal() {
        System.out.println(isClean ?getClass().getSimpleName() + " '" + name +"' is proper" :
                getClass().getSimpleName() + " '" + name +"' is niet proper en we gaan het behandelen");
        if (!isClean)
            isClean = true;
    }


    @Override
    public int compareTo(Animal animal) {
        if (this.animalNumber > animal.animalNumber)
            return 1;
        else
            return -1;
    }


    @Override
    public String toString() {
        if (name.equals("UNKNOWN"))
            return "UNKNOWN ANIMAL";
        else
            return  "Age=" + age +
                    "\nName= '" + name + '\'' +
                    "\nAnimalNumber= " + animalNumber +
                    "\nIsClean= " + isClean +
                    "\nIsVaccinated= " + isVaccinated;
    }
}
