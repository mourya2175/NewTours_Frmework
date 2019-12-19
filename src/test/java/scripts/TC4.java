package scripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuse.Functions;

public class TC4 extends StartBrowser{
  @Test
  public void testNewToursLogin() throws Exception {
	  System.out.println("This is for testing");
	  Functions f = new Functions();
	  f.newLogin();
	  f.newFlights();
	  f.newLogOff();
  }
}
