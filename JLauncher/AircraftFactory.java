package JLauncher;

public abstract class AircraftFactory {

  public static Flyable newAircraft(String type,
  	String name, int longtitude, int latitude, int height) {

    Coordinates coords = new Coordinates(longtitude, latitude, height);

    switch (type)
    {
    	case "Helicopter": return  new Helicopter(name, coords);
    	case "JetPlane": return  new JetPlane(name, coords);
    	case "Baloon": return  new Baloon(name, coords);
    	default: return null;
    }
  }
}