package designpattern.abstractFactoryPattern;

public interface AbstractFactory<T> {
    T create(String animalType) ;
}