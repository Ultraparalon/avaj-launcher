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
  	Coordinates tmp = new Coordinates(0, 0, 0);
  	switch (m_wt.getWeather(this.m_coordinates))
  	{
  	  case ("SUN"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude() + 2,
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() + 4);
          Manager.writeMessage(INFO + ": there is only weed, no water.\n");
  	    break;
  	  case ("RAIN"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 5);
          Manager.writeMessage(INFO + ": it's raining man.\n");
  	    break;
  	  case ("FOG"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 3);
          Manager.writeMessage(INFO + ": smoke weed every day.\n");
  	    break;
  	  case ("SNOW"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 15);
          Manager.writeMessage(INFO + ": I think I froze my finger.\n");
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
