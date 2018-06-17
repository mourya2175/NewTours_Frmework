package scripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuse.Functions;

public class TC4 extends StartBrowser{
  @Test
  public void testNewToursLogin() throws Exception {
	  
	  Functions f = new Functions();
	  f.newLogin();
	  f.newFlights();
	  f.newLogOff();
  }
}
