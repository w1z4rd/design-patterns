package ro.softvision.observer;


public class WatchTower implements Observer {

	private String name;
	OrdinalLocation location;

	public WatchTower(String name, OrdinalLocation location) {
		this.name = name;
		this.location = location;
	}

	@Override
	public void update(Observable o) {
		if (o == null)
			throw new NullPointerException();
		if (o instanceof Dragon) {
			Dragon dragon = (Dragon) o;
			System.out.println(name + " reporting: " + dragon.getName()
					+ " is " + dragon.getState());
		} else {
			throw new IllegalArgumentException("Expecting a Dragon!");
		}
	}
}
