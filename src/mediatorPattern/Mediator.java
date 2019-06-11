package mediatorPattern;

//Mediator interface
public interface Mediator {
	public void send(String message, Colleague colleague);
}
