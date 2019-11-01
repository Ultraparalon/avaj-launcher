package JLauncher;

class Baloon extends Aircraft implements Flyable {
  private WeatherTower m_wt;

  Baloon(String name, Coordinates coords) {
  	super(name, coords);  
  }

  public void updateConditions() {
  	Coordinates tmp = new Coordinates(0, 0, 0);
  	switch (m_wt.getWeather(this.m_coordinates))
  	{
  	  case ("SUN"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude() + 2,
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() + 4);
  	    break;
  	  case ("RAIN"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 5);
  	    break;
  	  case ("FOG"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 3);
  	    break;
  	  case ("SNOW"):
  	    tmp = new Coordinates(m_coordinates.getLongtitude(),
  	    	m_coordinates.getLatitude(),
  	    	m_coordinates.getHeight() - 15);
  	    break;
  	  default: break;
  	};

  	if (tmp.getHeight() <= 0) {
  	  m_wt.unregister(this);
  	}
  	
  	this.m_coordinates = tmp;
  }

  public void registerTower(WeatherTower wt) {
  	m_wt = wt;
  	wt.register(this);
  }
}
