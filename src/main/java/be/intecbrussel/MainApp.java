package be.intecbrussel;

import be.intecbrussel.Animal.Animal;
import be.intecbrussel.Animal.Cat;
import be.intecbrussel.Animal.Dog;
import be.intecbrussel.Animal.Monkey;
import be.intecbrussel.Care.Disease;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws InterruptedException{

        Animal cat1 = new Cat(16,"Sam", true, true);
        Animal dog1 = new Dog(23,"Voltaire", false, true);
        Animal monkey1 = new Monkey(111,"Chichi", true, false);
        Animal monkey2 = new Monkey(-2,"Alex", false, false);
        Animal dog2 = new Dog(5,"Cinnamon", true, true);
        Animal dog3 = new Dog(10, "Gipsy", false, false);
        Animal monkey3 = new Monkey(32, "Blue", true, true);
        Animal cat2 = new Cat(12, "Petra", false, false);
        Animal cat3 = new Cat(3, "Jude", false, true);
        Animal cat4 = new Cat(27, "Praline", true, false);

       AnimalShelter animalShelter = new AnimalShelter();
       animalShelter.addAnimal(cat1);
       animalShelter.addAnimal(dog1);
       animalShelter.addAnimal(monkey1);
       animalShelter.addAnimal(monkey2);
       animalShelter.addAnimal(dog2);
       animalShelter.addAnimal(dog3);
       animalShelter.addAnimal(monkey3);
       animalShelter.addAnimal(cat2);
       animalShelter.addAnimal(cat3);
       animalShelter.addAnimal(cat4);



       System.out.println("----------------------- Gesorteerd volgens de naam volgorde ---------------------------");
       animalShelter.sortAnimalsByName();
       animalShelter.printAnimals();

       System.out.println("\n--Vaccination period--");
       cat1.vaccinateAnimal(Disease.POLIO);
       cat2.vaccinateAnimal(Disease.POLIO);
       cat3.vaccinateAnimal(Disease.POLIO);
       cat4.vaccinateAnimal(Disease.POLIO);


       System.out.println("\n----------------------- Gesorteerd volgens hun natuurlijke volgorde -----------------------");
       animalShelter.sortAnimals();
       animalShelter.printAnimals();

       System.out.println("\n--Vaccination period--");
       monkey1.vaccinateAnimal(Disease.FLUE);
       monkey2.vaccinateAnimal(Disease.FLUE);
       monkey3.vaccinateAnimal(Disease.FLUE);


        System.out.println("\n----------------------- Dieren die niet gevaccineerd is tegen Flue-----------------------");
        animalShelter.printAnimalNotVaccinated(Disease.FLUE);

        System.out.println("\n----------------------- Een dier vinden met zijn dierennummer ----------------------- ");
        System.out.println(animalShelter.findAnimal(12) + "\n");
        System.out.println(animalShelter.findAnimal(5));

        System.out.println("\n------------------------Een dier vinden met zijn dierennaam-----------------------");
        System.out.println(animalShelter.findAnimal("Ada") + "\n");
        System.out.println(animalShelter.findAnimal("Petra"));

        System.out.println("\n-----------------------Een dier zoeken en behandelen met zijn dierennummer-----------------------");
        animalShelter.treatAnimal(22);
        animalShelter.treatAnimal(13);

        System.out.println("\n-----------------------Een dier zoeken en behandelen met zijn dierennaam-----------------------");
        animalShelter.treatAnimal("Voltaire");
        animalShelter.treatAnimal("Bibi");

        System.out.println("\n----------------------- Alle dieren behandelen -----------------------");
        animalShelter.treatAllAnimal();

        System.out.println("\n-----------------------Gesorteerd volgens de age volgorde -----------------------");
        animalShelter.sortAnimalsByAge();
        animalShelter.printAnimals();

        System.out.println("\n----------------------- Welke dier is het oudste ?-----------------------");
        System.out.println(animalShelter.findOldestAnimal());

        System.out.print("\nHoeveel dieren hebben we in de opvanghuis: ");
        System.out.println(animalShelter.countAnimals());






        System.out.println("\n\n\n-----------------------Bonus-----------------------");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int input;

        try {
            System.out.print("als je een van deze dieren mee naar huis wilt nemen, voer dan het dierennummer in: ");
            input = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Je voert niet een nummer.\nEr wordt een willekeurig nummer gekozen");
            input = random.nextInt(10,20);
        }

        System.out.println("je voert de nummer " + input + " in... Een momentje...");
        for (int i = 0; i < 5; i++){
            Thread.sleep(1000);
            System.out.println("...");
        }
        if (animalShelter.findAnimal(input).get().getName().equals("UNKNOWN"))
            System.out.println("Deze nummer past niet aan een dier");
        else
            System.out.println("je kan verlaten met " + animalShelter.findAnimal(input).get().getName() + "\n" +
                    "Zorg goed voor dit dier! Tot ziens");





    }
}
