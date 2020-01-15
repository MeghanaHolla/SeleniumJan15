package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		
		String[][] data = GenericMethods.getData("D:\\SelJan3\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			//Making changes to the code after current release
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowserWindow();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToAUT":
				Methods.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox":
				Methods.enterTextBox(data[i][4],data[i][5], data[i][6]);
				break;

			case "clickButton":
				Methods.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMsg":
				try {
					String actualMsg = Methods.getMessage(data[i][5]);
					SoftAssert softassert = new SoftAssert();
					softassert.assertEquals(actualMsg, data[i][6]);
					break;
				}
				catch(Exception ex) {
					SoftAssert softassert = new SoftAssert();
					softassert.fail("Validation Failed");
					continue;
					
				}
				
			case "closeAUT":
				Methods.closeApplication();
				break;
				
			}
		}
	}

}
