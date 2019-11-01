package JLauncher;

public class WeatherTower extends Tower {
  public String getWeather(Coordinates coords) {
  	return WeatherProvider.getProvider().getCurrentWeather(coords);
  }

  void changeWeather() {
  	super.conditionsChanged();
  }
}
