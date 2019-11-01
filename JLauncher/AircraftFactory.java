package JLauncher;

public abstract class AircraftFactory {
  public static Flyable newAircraft(String type,
  	String name, int longtitude, int latitude, int height) {
  	if (type == "Hellicopter") {
  	  return  new Helicopter(name,
  	  	new Coordinates(longtitude, latitude, height));
  	}
  	else if (type == "JetPlane") {
  	  return  new JetPlane(name,
  	  	new Coordinates(longtitude, latitude, height));
  	}
  	else if (type == "Baloon") {
  	  return  new Baloon(name,
  	  	new Coordinates(longtitude, latitude, height));
  	}
  	return null;
  }
}