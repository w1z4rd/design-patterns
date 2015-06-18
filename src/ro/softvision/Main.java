package ro.softvision;

import ro.softvision.command.Goblin;
import ro.softvision.command.InvisibilitySpell;
import ro.softvision.command.ShrinkSpell;
import ro.softvision.command.Size;
import ro.softvision.command.Visibility;
import ro.softvision.command.Wizard;
import ro.softvision.observer.Dragon;
import ro.softvision.observer.DragonState;
import ro.softvision.observer.OrdinalLocation;
import ro.softvision.observer.WatchTower;
import ro.softvision.strategy.DragonSlayer;
import ro.softvision.strategy.MeleeStrategy;
import ro.softvision.strategy.ProjectileStrategy;
import ro.softvision.strategy.SpellStrategy;

public class Main {

	public static void main(String[] args) {
		observerPatternExample();
		strategyPatternExample();
		commandPatternExample();
	}

	private static void observerPatternExample() {
		Dragon drogo = new Dragon("Drogo", DragonState.SLEEPING);
		WatchTower northEasternTower = new WatchTower("North-Eastern Tower",
				OrdinalLocation.NORTHEAST);
		WatchTower northWesternTower = new WatchTower("South-Western Tower",
				OrdinalLocation.SOUTHWEST);
		drogo.addObserver(northEasternTower);
		drogo.addObserver(northWesternTower);
		drogo.notifyObservers();
		drogo.setState(DragonState.FLYING);
		drogo.setState(DragonState.ATTACKING);
		drogo.removeObserver(northWesternTower);
		drogo.setState(DragonState.SLEEPING);
	}

	private static void strategyPatternExample() {
		DragonSlayer j4 = new DragonSlayer("Jarvan IV", new MeleeStrategy());
		j4.goToBattle();
		j4.changeStrategy(new SpellStrategy());
		j4.goToBattle();
		j4.changeStrategy(new ProjectileStrategy());
		j4.goToBattle();

	}

	private static void commandPatternExample() {
		Wizard gandalf = new Wizard("Gandalf");
		Goblin goblin = new Goblin("Mudblaster", Size.NORMAL,
				Visibility.VISIBLE);
		gandalf.castSpell(new InvisibilitySpell(), goblin);
		System.out.println(goblin.getVisibility());
		gandalf.castSpell(new ShrinkSpell(), goblin);
		System.out.println(goblin.getSize());
		gandalf.undo();
		System.out.println(goblin.getSize());
		gandalf.undo();
		System.out.println(goblin.getVisibility());
	}
}
