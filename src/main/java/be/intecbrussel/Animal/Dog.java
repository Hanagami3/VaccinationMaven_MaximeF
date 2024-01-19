package be.intecbrussel.Animal;

public class Dog extends Animal {

    private boolean hasFoulBreath;


    public Dog() {
        super();
        hasFoulBreath = false;
    }

    public Dog(int age, String name, boolean isClean, boolean hasFoulBreath) {
        super(age, name, isClean);
        this.hasFoulBreath = hasFoulBreath;
    }


    @Override
    public void treatAnimal() {
        super.treatAnimal();
        System.out.println(hasFoulBreath ? "De hond heeft een slecht adem en we gaan het behandeld\n" :
                "De hond heeft geen slecht adem\n");
        if (hasFoulBreath)
            hasFoulBreath = false;
    }


    @Override
    public String toString() {
        return "\nDOG\n" +
                super.toString() +
                "\nHasFoulBreath= " + hasFoulBreath;

    }
}
