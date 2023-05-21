package com.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting  {
	
	
	public static void generateReports(String jsonfile) {
		
		File file=new File(System.getProperty("user.dir")+"\\target");
		
		
		Configuration con= new Configuration(file, "OMRBranchGroceryAPIAutomation");
		con.addClassifications("platform", "windows 10");
		con.addClassifications("sprint", "2");
		con.addClassifications("author", "Anandharaj");
		
		List<String> list=new ArrayList<>();
		
		list.add(jsonfile);
		
		ReportBuilder builder= new ReportBuilder(list, con);
		builder.generateReports();
		

	}
	
	
	
	

}
