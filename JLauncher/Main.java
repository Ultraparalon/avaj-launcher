package JLauncher;

import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void proceed(String fname) {
    try
    {
      int cycles;

      WeatherTower wt = new WeatherTower();

      List<String> lines = Files.readAllLines(Paths.get(fname),
        StandardCharsets.UTF_8);
      // may be empty
      // if lines.size() == 0
      // throw empty file

      cycles = Manager.stoi(lines.get(0));
      // catch: not number
      lines.remove(0);

  	  for (String line: lines) {
        Flyable tmp = Manager.parser(line);
        // may get null

  	    if (tmp != null) {
  	      tmp.registerTower(wt);
  	    }
  	    else {
  	      System.out.println("Null");
  	    }
  	  }

  	  for (int i = 0; i < cycles; i++) {
  	  	wt.changeWeather();
  	  }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void main(String args[]) {
    if (args.length == 1) {
      proceed(args[0]);
    }
    else {
      System.out.println("usage: [filename]");
    }
  }

}
