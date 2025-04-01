package com.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class Listener implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is :"+result.getName());
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test case started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :"+result.getName());
	}
	
	public void onTestFinish(ITestResult result) {
		System.out.println("The name of the testcase finish is :"+result.getName());
	}
	
}
