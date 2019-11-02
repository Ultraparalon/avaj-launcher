package JLauncher;

public interface Flyable {
  
  public String getInfo();
  public void updateConditions();
  public void registerTower(WeatherTower wt);
}
