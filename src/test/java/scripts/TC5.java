package scripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reuse.Functions;
import util.Xls_Reader;

public class TC5 extends StartBrowser{
  @Test
  public void testNewToursLoginExcel() throws Exception {
	  Xls_Reader reader = new Xls_Reader("TestData/data.xlsx");
	  String uName=reader.getCellData("Sheet1", "UserName", 2);
	  String password=reader.getCellData("Sheet1", "Password", 2);
	  System.out.println("I added this");
	  Functions f = new Functions();
	  f.newLogin(uName, password);
	  f.newFlights();
	  f.newLogOff();
	  System.out.println("This is for testing");
  }
}
