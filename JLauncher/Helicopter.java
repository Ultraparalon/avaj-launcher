package JLauncher;

class Helicopter extends Aircraft implements Flyable {

  final private String INFO = new String("Helicopter#"
    + this.m_name + '(' + this.m_id + ')');

  private WeatherTower m_wt;

  Helicopter(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public String getInfo() {
    return INFO;
  }

  public void updateConditions() {
    switch (m_wt.getWeather(this.m_coordinates))
    {
      case ("SUN"):
        this.m_coordinates.moveCoordinates(10, 0, 2);
        Manager.writeMessage(INFO + ": who's the boss here.\n");
        break;
      case ("RAIN"):
        this.m_coordinates.moveCoordinates(5, 0, 0);
        Manager.writeMessage(INFO + ": water is not an enemy for me.\n");
        break;
      case ("FOG"):
        this.m_coordinates.moveCoordinates(1, 0, 0);
        Manager.writeMessage(INFO + ": walking in the shadows.\n");
        break;
      case ("SNOW"):
        this.m_coordinates.moveCoordinates(0, 0, -12);
        Manager.writeMessage(INFO + ": my guns will never freeze.\n");
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
