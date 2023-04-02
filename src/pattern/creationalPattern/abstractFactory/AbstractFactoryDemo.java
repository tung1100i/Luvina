/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern.creationalPattern.abstractFactory;

interface AbstractFactory2<T> {

    T create(String animalType);
}

interface Animal {

    String getAnimal();

    String makeSound();
}

class Duck implements Animal {

    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}

class Dog implements Animal {

    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "....";
    }
}

interface Color {

    String getColor();
}

class White implements Color {

    @Override
    public String getColor() {
        return " White";
    }
}

class Black implements Color {

    @Override
    public String getColor() {
        return " Black";
    }
}

class AnimalFactory implements AbstractFactory2<Animal> {

    @Override
    public Animal create(String animalType) {
        if ("Dog".equalsIgnoreCase(animalType)) {
            return new Dog();
        } else if ("Duck".equalsIgnoreCase(animalType)) {
            return new Duck();
        }
        return null;
    }
}

class ColorFactory implements AbstractFactory2<Color> {

    @Override
    public Color create(String colorType) {
        if ("White".equalsIgnoreCase(colorType)) {
            return new White();
        } else if ("Black".equalsIgnoreCase(colorType)) {
            return new Black();
        }
        return null;
    }
}

class FactoryProvider {

    public static AbstractFactory2 getFactory(String choice) {
        if ("Animal".equalsIgnoreCase(choice)) {
            return new AnimalFactory();
        } else if ("Color".equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }
}

/**
 *
 * @author Admin
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory2<Animal> aniF = FactoryProvider.getFactory("Animal");
        Animal dog = aniF.create("Dog");
        System.out.println(dog.getAnimal());
        AbstractFactory2<Color> colorF = FactoryProvider.getFactory("Color");
        Color white = colorF.create("White");
        System.out.println(white.getColor());
    }
}
