package JLauncher;

import java.util.LinkedList;

public abstract class Tower {
  private LinkedList<Flyable> observers;

  public void register(Flyable flyable) {
  	observers.add(flyable);
  }

  public void unregister(Flyable flyable) {
  	observers.remove(flyable);
  }

  protected void conditionsChanged() {
  	for (Flyable tmp : observers) {
  	  tmp.updateConditions();
  	}
  }
}
