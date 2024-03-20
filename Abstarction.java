// Abstract class
abstract class Animal {
    // Abstract method (does not have a body)
    public abstract void makeSound();
}

// Interface
interface Edible {
    // Interface method (does not have a body)
    void eat();
}

// Dog "is a" Animal and "implements" Edible
class Dog extends Animal implements Edible {
    // Dog's implementation of makeSound
    public void makeSound() {
        System.out.println("Woof");
    }

    // Dog's implementation of eat
    public void eat() {
        System.out.println("Dog is eating");
    }
}

// Cat "is a" Animal
class Cat extends Animal {
    // Cat's implementation of makeSound
    public void makeSound() {
        System.out.println("Meow");
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.eat();

        Cat myCat = new Cat();
        myCat.makeSound();
    }
}