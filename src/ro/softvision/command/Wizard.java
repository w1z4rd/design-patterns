package ro.softvision.command;

import java.util.Stack;

public class Wizard {
	Stack<Command> spells;
	private String name;

	public Wizard(String name) {
		this.setName(name);
		spells = new Stack<Command>();
	}

	public void castSpell(Command spell, Target target) {
		spells.push(spell);
		spell.execute(target);
	}

	public void undo() {
		if (!spells.isEmpty()) {
			Command spell = spells.pop();
			spell.undo();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
