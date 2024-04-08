package testCases;

import org.testng.annotations.DataProvider;


public class DataProviderForLogin {
	@DataProvider (name = "data-providervalid")
	public Object[][] dpMethod1(){
	return new Object[][] {{"admin","admin"}};
	}
	@DataProvider (name = "data-providerinvalid")
	public Object[][] dpMethod2(){
	return new Object[][] {{"admin","adm"},{"admin","Rose"},{"admin","Mary"}};
	}
}
