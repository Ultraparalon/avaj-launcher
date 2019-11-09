package JLauncher;

class Baloon extends Aircraft implements Flyable {

  final private String INFO = new String("Baloon#"
    + this.m_name + '(' + this.m_id + ')');

  private WeatherTower m_wt;

  Baloon(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public String getInfo() {
    return INFO;
  }

  public void updateConditions() {    
  	switch (m_wt.getWeather(this.m_coordinates))
  	{
  	  case ("SUN"):
        this.m_coordinates.moveCoordinates(2, 0, 4);
        Manager.writeMessage(INFO + ": there is only weed, no water.\n");
  	    break;
  	  case ("RAIN"):
        this.m_coordinates.moveCoordinates(0, 0, -5);
        Manager.writeMessage(INFO + ": it's raining man.\n");
  	    break;
  	  case ("FOG"):
        this.m_coordinates.moveCoordinates(0, 0, -3);
        Manager.writeMessage(INFO + ": smoke weed every day.\n");
  	    break;
  	  case ("SNOW"):
        this.m_coordinates.moveCoordinates(0, 0, -15);
        Manager.writeMessage(INFO + ": I think I froze my finger.\n");
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
