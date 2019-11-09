package JLauncher;

class JetPlane extends Aircraft implements Flyable {

  final private String INFO = new String("JetPlane#"
    + this.m_name + '(' + this.m_id + ')');

  private WeatherTower m_wt;

  JetPlane(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public String getInfo() {
    return INFO;
  }

  public void updateConditions() {
    switch (m_wt.getWeather(this.m_coordinates))
    {
      case ("SUN"):
        this.m_coordinates.moveCoordinates(0, 10, 2);
        Manager.writeMessage(INFO + ": I see god rays.\n");
        break;
      case ("RAIN"):
        this.m_coordinates.moveCoordinates(0, 5, 0);
        Manager.writeMessage(INFO + ": water is not an enemy for me.\n");
        break;
      case ("FOG"):
        this.m_coordinates.moveCoordinates(0, 1, 0);
        Manager.writeMessage(INFO + ": like in Vvardenfell.\n");
        break;
      case ("SNOW"):
        this.m_coordinates.moveCoordinates(0, 0, -7);
        Manager.writeMessage(INFO + ": do I look like Nord?\n");
        break;
      default: break;
    };

    if (this.m_coordinates.getHeight() <= 0) {
      this.m_wt.unregister(this);
    }
  }

  public void registerTower(WeatherTower wt) {
    this.m_wt = wt;
    this.m_wt.register(this);
  }
  
}
