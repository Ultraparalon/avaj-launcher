package JLauncher;

import java.util.LinkedList;

public abstract class Tower {

  private LinkedList<Flyable> observers = new LinkedList<Flyable>();

  public void register(Flyable flyable) {
  	this.observers.add(flyable);
    Manager.writeMessage("Tower says: "
      + flyable.getInfo()
      + " registered to weather tower.\n");
  }

  public void unregister(Flyable flyable) {
  	this.observers.remove(flyable);
    Manager.writeMessage("Tower says: "
      + flyable.getInfo()
      + " unregistered from weather tower.\n");
  }

  protected void conditionsChanged() {
    for (int i = 0; i < observers.size();)
    {
      Flyable tmp = observers.get(i);
      tmp.updateConditions();

      if (tmp == observers.get(i)) {
        i++;
      }
    }
  }

}
