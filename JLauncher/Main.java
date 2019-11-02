package JLauncher;

import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void proceed(String fname)
  {
    int cycles;

    try
    {
      WeatherTower wt = new WeatherTower();

      List<String> lines = Files.readAllLines(Paths.get(fname), StandardCharsets.UTF_8);

      cycles = Integer.parseInt(lines.get(0));
      System.out.println(cycles);
      lines.remove(0);

	  for(String line: lines) {
  	    // System.out.println(line);

  	    Flyable tmp = Manager.parser(line);

  	    if (tmp != null) {
  	      tmp.registerTower(wt);
  	    }
  	    else {
  	      System.out.println("Null");
  	    }
	  }

	  for (int i = 0; i < cycles; i++)
	  {
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
