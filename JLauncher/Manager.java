package JLauncher;

import java.io.*;

public class Manager {
  private static final String fname = new String("simulation.txt"); 
  // private static ;

  public static Flyable parser(String str) {
  	String params[] = str.split(" ", 5);

  	// for (String line: params) {
  	//   System.out.println(line);
  	// }

  	return AircraftFactory.newAircraft(
  		params[0],
  		params[1],
  		Integer.parseInt(params[2]),
  		Integer.parseInt(params[3]),
  		Integer.parseInt(params[4])
  	);
  }

  public static void writeMessage(String str) {
  	try(FileWriter fw = new FileWriter(fname, true))
  	{
  	  fw.write(str);
    }
    catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
