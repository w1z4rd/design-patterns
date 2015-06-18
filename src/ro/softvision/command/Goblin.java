package ro.softvision.command;

public class Goblin extends Target {
	private String name;

	public Goblin(String name, Size size, Visibility visibility) {
		this.name = name;
		this.setSize(size);
		this.setVisibility(visibility);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
