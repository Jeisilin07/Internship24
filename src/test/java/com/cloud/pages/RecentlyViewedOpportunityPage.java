package com.cloud.pages;


import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class RecentlyViewedOpportunityPage extends BaseMethods{
	
	public RecentlyViewedOpportunityPage enterOpportunityName() {
		
		clearAndType(locateElement(Locators.NAME,"Opportunity-search-input"), "Testleaf-");
		return this;
		
	}
	
	public opportunitySelectPage clickOpportunityMatch() {
		
		click(locateElement(Locators.XPATH,"//a[@title='Testleaf-']"));
		return new opportunitySelectPage();
	}

}
