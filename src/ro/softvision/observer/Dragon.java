package ro.softvision.observer;

import java.util.ArrayList;
import java.util.List;

public class Dragon implements Observable {
	private DragonState state;
	private String name;
	private List<Observer> observers;

	public Dragon(String name, DragonState state) {
		this.name = name;
		this.state = state;
		observers = new ArrayList<Observer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyObservers();
	}

	public DragonState getState() {
		return state;
	}

	public void setState(DragonState state) {
		this.state = state;
		notifyObservers();
	}

	public synchronized void addObserver(Observer obs) {
		if (obs == null) {
			throw new NullPointerException();
		}
		if (!observers.contains(obs)) {
			observers.add(obs);
		}
	}

	public synchronized void removeObserver(Observer obs) {
		observers.remove(obs);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}

}
