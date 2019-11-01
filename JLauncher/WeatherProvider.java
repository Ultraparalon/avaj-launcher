package JLauncher;

public class WeatherProvider {
  private static WeatherProvider wp;
  private static String weather[] = {
  	"RAIN", "FOG", "SUN", "SNOW"
  };

  private WeatherProvider() {}

  public static WeatherProvider getProvider() {
  	if (wp == null) {
  		wp = new WeatherProvider();
  	}
  	return wp;
  }

  public String getCurrentWeather(Coordinates coords) {
    int type = (coords.getLongtitude()
      + coords.getLatitude()
      + coords.getHeight()) % weather.length;

    return weather[type];
    // there should be weather algorythm
  }
}
