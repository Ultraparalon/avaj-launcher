package JLauncher;

public abstract class Aircraft {
  protected long m_id;
  protected String m_name;
  protected Coordinates m_coordinates;
  private static long m_idCounter = 0;

  protected Aircraft(String name, Coordinates coords) {
  	m_id = nextId();
  	m_name = name;
  	m_coordinates = coords;
  }

  private long nextId() {
  	return m_idCounter++;
  }
}
