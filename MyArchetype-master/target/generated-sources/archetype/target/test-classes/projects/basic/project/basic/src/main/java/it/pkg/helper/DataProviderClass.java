package it.pkg.helper;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import it.pkg.utility.Constants;



/**
 * 
 * @author kishor.joshi
 *
 */

public class DataProviderClass {
	
	@DataProvider(name="userData")
	public  String[][] getdata() throws IOException {

	   return ExcelReader.getUserData(Constants.detailsExcelPath);
	}
	
	
	
}
