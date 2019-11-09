package JLauncher;

import java.io.*;
import java.util.regex.Pattern;

public class Manager {
  private static final String fname = new String("simulation.txt");

  public static Flyable parser(String str) {
  	String params[] = str.split(" ", 5);
    // if params.size() != 5
    // throw wrong amount of parameters

  	// for (String line: params) {
  	//   System.out.println(line);
  	// }

    if (params[0].isEmpty() || params[1].isEmpty()) {
      System.out.println("Empty string");
      // throw empty string
    }

  	return AircraftFactory.newAircraft(
  		params[0],
  		params[1],
  		Manager.stoi(params[2]),
  		Manager.stoi(params[3]),
  		Manager.stoi(params[4])
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

  public static int stoi(String str) {
      if (!Pattern.matches("-?\\d+", str)) {
        System.out.println("Not a number");
        // throw not a number    
      }

      return Integer.parseInt(str);
  }

  // public static String getStr(String reg, String str) {
  //   if (!Pattern.matches(reg, str)) {
  //     // throw bad name
  //     System.out.println("bad name");
  //   }
  // }

}
