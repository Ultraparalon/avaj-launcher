package JLauncher;

import java.io.*;

public class Messager {
  private static final String fname = new String("simulation.txt"); 
  // private static ;

  public static void writeMessage(String str) {
  	try(FileWriter fw = new FileWriter(fname, true))
  	{
  	  fw.write(str);
  	  fw.append('\n');
    }
    catch(IOException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
