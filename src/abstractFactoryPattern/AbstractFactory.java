package abstractFactoryPattern;

public interface AbstractFactory<T> {
    T create(String animalType) ;
}