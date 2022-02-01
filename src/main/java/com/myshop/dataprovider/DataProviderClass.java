package com.myshop.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.myshop.utilities.XLUtils;

public class DataProviderClass {
	
	XLUtils obj = new XLUtils();

	     //Data provider for LogIn

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("LogIn Credentials");
			// Total Columns
			int column = obj.getColumnCount("LogIn Credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("LogIn Credentials", j, i + 2);
				}
			}
			return data;
		}
		
		//Data provider for Account Creation
		@DataProvider(name = "newAcountDetailsData")
		public Object[][] accountCreation() {

			// Totals rows count
			int rows = obj.getRowCount("CreateMyAccount");
			// Total Columns
			int column = obj.getColumnCount("CreateMyAccount");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<String, String>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("CreateMyAccount", j, 1),
							obj.getCellData("CreateMyAccount", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;

}
}
