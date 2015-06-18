package ro.softvision.strategy;

public class DragonSlayer {

	private String name;
	private DragonSlayingStrategy strategy;

	public DragonSlayer(String name, DragonSlayingStrategy strategy) {
		this.setName(name);
		this.strategy = strategy;
	}

	public void goToBattle() {
		System.out.println(name + " fighting!");
		strategy.execute();
	}

	public void changeStrategy(DragonSlayingStrategy strategy) {
		this.strategy = strategy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
