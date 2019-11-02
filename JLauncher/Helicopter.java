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
    Coordinates tmp = new Coordinates(0, 0, 0);
    switch (m_wt.getWeather(this.m_coordinates))
    {
      case ("SUN"):
        tmp = new Coordinates(m_coordinates.getLongtitude() + 10,
          m_coordinates.getLatitude(),
          m_coordinates.getHeight() + 2);
          Manager.writeMessage(INFO + ": who's the boss here.\n");
        break;
      case ("RAIN"):
        tmp = new Coordinates(m_coordinates.getLongtitude() + 5,
          m_coordinates.getLatitude(),
          m_coordinates.getHeight());
          Manager.writeMessage(INFO + ": water is not an enemy for me.\n");
        break;
      case ("FOG"):
        tmp = new Coordinates(m_coordinates.getLongtitude() + 1,
          m_coordinates.getLatitude(),
          m_coordinates.getHeight());
          Manager.writeMessage(INFO + ": walking in the shadows.\n");
        break;
      case ("SNOW"):
        tmp = new Coordinates(m_coordinates.getLongtitude(),
          m_coordinates.getLatitude(),
          m_coordinates.getHeight() - 12);
          Manager.writeMessage(INFO + ": my guns will never freeze.\n");
        break;
      default: break;
    };

    if (tmp.getHeight() <= 0) {
      this.m_wt.unregister(this);
    }
    
    this.m_coordinates = tmp;
  }

  public void registerTower(WeatherTower wt) {
    this.m_wt = wt;
    this.m_wt.register(this);
  }
}
