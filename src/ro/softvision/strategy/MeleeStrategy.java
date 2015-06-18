package ro.softvision.strategy;

public class MeleeStrategy implements DragonSlayingStrategy {

	@Override
	public void execute() {
		System.out.println("Hack and slash...");
	}

}
