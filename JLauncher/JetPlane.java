package JLauncher;

class JetPlane extends Aircraft implements Flyable {
  private WeatherTower m_wt;

  JetPlane(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public void updateConditions() {

  }

  public void registerTower(WeatherTower wt) {
  	m_wt = wt;
  	wt.register(this);
  }
}
