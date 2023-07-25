package com.ActiTime.Testscripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ActiTime.GenericLibrary.Baseclass;
import com.ActiTime.GenericLibrary.FileLibrary;
import com.ActiTime.GenericLibrary.ListenerImplementation;
import com.ActiTime.ObjectRepository.Homepage;
import com.ActiTime.ObjectRepository.TaskPage;

@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void createCustomer() throws IOException, InterruptedException {
		Homepage hp=new Homepage(driver);
		hp.getTasktab().click();
		TaskPage tp=new TaskPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcustbtn().click();
		FileLibrary fl=new FileLibrary();
		String name=fl.ReadDataFromExelFile("Automation", 2,1);
		tp.getCustname().sendKeys(name);
		String discr=fl.ReadDataFromExelFile("Automation", 2,2);
		tp.getCustdescr().sendKeys(discr);
		tp.getCreatecust().click();
		Thread.sleep(5000);
	}
}
