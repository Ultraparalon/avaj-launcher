package JLauncher;

class Coordinates {

  private static final int MAXHEIGHT = 100;

  private int m_longtitude;
  private int m_latitude;
  private int m_height;

  Coordinates(int longtitude, int latitude, int height) {
  	m_longtitude = longtitude;
  	m_latitude = latitude;
  	m_height = height > MAXHEIGHT ? MAXHEIGHT : height;
  }

  public final int getLongtitude() {
  	return m_longtitude;
  }

  public final int getLatitude() {
  	return m_latitude;
  }

  public final int getHeight() {
  	return m_height;
  }

  public void moveCoordinates(int longtitude,
    int latitude, int height) {
    m_longtitude += longtitude;
    m_latitude += latitude;
    m_height += height;
  }
  
}