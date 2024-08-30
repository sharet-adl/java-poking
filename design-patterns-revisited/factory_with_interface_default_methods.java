import java.util.*;

interface Pet {}
class Dog implements Pet {}
class Cat implements Pet {}

interface Person {
    Pet getPet();
    default void play() {
        System.out.println("Playing with " + getPet());
    }    
}

class DogLover implements Person {
    public Dog getPet() {return new Dog();}
}

class CatPerson implements Person {
    public Cat getPet() { return new Cat();}
}

// Factory methods - using Interface with default methods; vs older abstract classes
public class factory_with_interface_default_methods {

    public static void main(String[] args) {
        Person p1 = new DogLover();
        Person p2 = new CatPerson();

        p1.play();
        p2.play();
    }
}