package org.RunnerClass;	
import org.base.BaseClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",glue="org.stepdefintion",dryRun=!true,monochrome=true,
tags="@offlnebundles",
plugin={"pretty",
		"html:src\\test\\resources\\Reports\\Htmlreport",
		"json:src\\test\\resources\\Reports\\JSONReport\\report.json",
"junit:src\\test\\resources\\Reports\\JunitReport\\junitreport.xml"}	

		)

public class TestRunner extends BaseClass {

	static long	 en;
	static long st;		

	@AfterClass
	public static void afterclass() {

		
		en	=System.currentTimeMillis();
		System.out.println("Test case Execution Time = " + (en - st) + " milliseconds");
		//driver.quit();
		 	
	}
		

}
