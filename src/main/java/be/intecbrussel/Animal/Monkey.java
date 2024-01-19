package be.intecbrussel.Animal;

public class Monkey extends Animal {

    private boolean isHyperActive;

    public Monkey() {
        super();
        isHyperActive = false;
    }

    public Monkey(int age, String name, boolean isClean, boolean isHyperActive) {
        super(age, name, isClean);
        this.isHyperActive = isHyperActive;
    }


    @Override
    public void treatAnimal() {
        super.treatAnimal();
        System.out.println(isHyperActive ? "De aap is hyper actief en we gaan het behandeld\n" :
                "De aap is niet hyper actief\n");
        if (isHyperActive)
            isHyperActive = false;
    }


    @Override
    public String toString() {
        return "\nMONKEY\n" +
                super.toString() +
                "\nIsHyperActive= " + isHyperActive;

    }

}
