package com.myshop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;// creating properties object

	public Readconfig()// creating a constructor
	{
		File src = new File(
				"C:\\Users\\SHILPI\\eclipse-workspace\\E-Commerce_Project2\\Configuration\\Config.properties");// giving
																												// file
																												// path

		try {
			FileInputStream fis = new FileInputStream(src);// opening the src file in read mode
			pro = new Properties();
			pro.load(fis);// loading the file using pro object

		} catch (Exception e)// exception handling
		{
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationURL()// reading the content of the file
	{
		String url = pro.getProperty("BaseURL");
		return url;
	}

	public String getUserName() {
		String Username = pro.getProperty("username");
		return Username;
	}

	public String getPassword() {
		String Password = pro.getProperty("password");
		return Password;
	}
}
