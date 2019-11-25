#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.helper;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import ${package}.utility.Constants;



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
