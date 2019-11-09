package JLauncher;

public class WeatherProvider {

  private static WeatherProvider m_wp;
  private static String weather[] = {
  	"RAIN", "FOG", "SUN", "SNOW"
  };

  private WeatherProvider() {}

  public static WeatherProvider getProvider() {
  	if (m_wp == null) {
  		m_wp = new WeatherProvider();
  	}
  	return m_wp;
  }

  public String getCurrentWeather(Coordinates coords) {
    int type = (coords.getLongtitude()
      + coords.getLatitude()
      + coords.getHeight()) % weather.length;

    return weather[type];
    // there should be genius weather algorythm
  }

}
