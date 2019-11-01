package JLauncher;

class Helicopter extends Aircraft implements Flyable {
  private WeatherTower m_wt;

  Helicopter(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower wt) {
  	m_wt = wt;
  	wt.register(this);
  }
}
