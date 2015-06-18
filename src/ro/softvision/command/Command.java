package ro.softvision.command;

public abstract class Command {

	public abstract void execute(Target taget);

	public abstract void undo();
}
