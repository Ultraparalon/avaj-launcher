package JLauncher;

import java.util.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
  public static void main(String args[]) {
    try
    {
      List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);

	  for(String line: lines) {
	    System.out.println(line);
	  }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
