package date;

import java.time.LocalDate;
import org.testng.annotations.Test;

import com.MyArchetype.utility.ConstantPaths;

public class DatePolicy {

	@Test
	public void effectiveDatePolicy() throws Exception {
		ExcelApiTest api = new ExcelApiTest(ConstantPaths.dateExcelPath);
		ExcelWriteData write = new ExcelWriteData(ConstantPaths.dateExcelPath);
		ExcelWriter xlwriter = new ExcelWriter();
		xlwriter.writeData("FinalDate", "EffectiveDate", 2);
		LocalDate today = LocalDate.now();
		System.out.println("Today is : " + today);

		String date1 = api.getCellData("EffectiveDate", "Range", 2);
		System.out.println(date1);
		int datenumber = Integer.parseInt(date1);
		LocalDate aMonthLater = LocalDate.now().plusDays(datenumber);
		System.out.println("1 month later from the current date : " + aMonthLater);
		write.setCellData("EffectiveDate", "FinalDate", 2, aMonthLater.toString());

		String date2 = api.getCellData("EffectiveDate", "Range", 3);
		System.out.println(date2);
		int datenumber1 = Integer.parseInt(date2);
		LocalDate aTenDaysLater = LocalDate.now().plusDays(datenumber1);
		System.out.println("Exactly 10 days from the current date : " + aTenDaysLater);
		write.setCellData("EffectiveDate", "FinalDate", 3, aTenDaysLater.toString());

		String date3 = api.getCellData("EffectiveDate", "Range", 4);
		System.out.println(date3);
		int datenumber2 = Integer.parseInt(date3);
		LocalDate aMonthBefore = LocalDate.now().minusDays(datenumber2);
		System.out.println("1 month earlier than the current date : " + aMonthBefore);
		write.setCellData("EffectiveDate", "FinalDate", 4, aMonthBefore.toString());

	}

}
