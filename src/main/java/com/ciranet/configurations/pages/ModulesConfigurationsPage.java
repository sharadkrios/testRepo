package com.ciranet.configurations.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ciranet.basepage.BasePage;
import com.ciranet.navigation.Navigation;
import com.ciranet.utilities.LoggerManager;

public class ModulesConfigurationsPage extends BasePage {

	@FindBy(xpath = "//div//span[normalize-space()='Modules']")
	private WebElement modulesSideNav;

	@FindBy(xpath = "//div[@class='dx-dropdowneditor-icon']")
	private WebElement configurationDropdown;

	@FindBy(xpath = "//div//span[contains(text(),'Customer Defined Info')]")
	private WebElement customerDefinedInfo;

	@FindBy(xpath = "(//input[@class='dx-texteditor-input'])[3]")
	private WebElement contextDropdown;

	@FindBy(xpath = "//div//span[contains(text(),'Egnyte Configuration')]")
	private WebElement egnyteConfiguration;

	@FindBy(xpath = "//div//span[contains(text(),'Help')]")
	private WebElement help;

	@FindBy(xpath = "//div//span[normalize-space()='Cira Budget Recommendations and Assumptions']")
	private WebElement recommendationsandAssumptions;

	@FindBy(xpath = "//div//span[contains(text(),'Cira Budget Supplemental Information')]")
	private WebElement supplementalInformation;

	@FindBy(xpath = "//div//span[contains(text(),'Transition Document')]")
	private WebElement transitionDocument;

	@FindBy(xpath = "//div//span[contains(text(),'Transition Task Templates')]")
	private WebElement transitionTaskTemplates;

	@FindBy(xpath = "//div//span[contains(text(),'Work Order Work Areas')]")
	private WebElement workOrderWorkAreas;

	@FindBy(xpath = "//div[@class='dx-overlay-content dx-resizable dx-loadpanel-content']")
	private WebElement loaderIcon;

	@FindBy(xpath = "//div[contains(text(),'Tasks')]")
	private WebElement labelTransitionTaskTemplates;

	@FindBy(xpath = "//h2[@class='page-header']")
	private WebElement pageTitle;

	@FindBy(xpath = "(//div[@class='dx-toolbar-center']//strong[@class='cc-1rx'])[1]")
	private WebElement pageTitleText;

	@FindBy(xpath = "//div//span[@class='dx-treelist-search-text']")
	private WebElement selectedFocusedContextValue;

	@FindBy(xpath = "//div[@class='dx-switch-on']")
	private WebElement terminatedOntoggleButton;

	public ModulesConfigurationsPage(WebDriver driver) {
		super(driver);
	}

	private String contextSearchTextFromParameter = "";

	public String configurationValueText = "";

	public String contextSearchValueText = "";

	public static final int TIMEOUT = 3;

	Navigation navigationSearch = new Navigation(driver);

	public String getContextSearchTextFromParameter() {
		return contextSearchTextFromParameter;
	}

	public void setContextSearchTextFromParameter(String contextSearchTextFromParameter) {
		this.contextSearchTextFromParameter = contextSearchTextFromParameter;
	}

	public boolean navigateToModulesConfiguration() {
		try {
			navigationSearch.navigate(By.xpath("//div//span[normalize-space()='Modules']"), "Modules");
			waitForInvisibility(loaderIcon);
			scrollToElement(modulesSideNav);
			if (isElementDisplayed(modulesSideNav)) {
				boolean isPageTitle = "Modules Configurations".equals(pageTitle.getText());
				LoggerManager.info("Page title validation: " + (isPageTitle ? "Passed" : "Failed"));
				return isPageTitle;
			} else {
				LoggerManager.info("Modules Configuration is not visible");
				return false;
			}
		} catch (NoSuchElementException e) {
			LoggerManager.error("An error occurred during the navigation search process: " + e.getMessage());
			return false;
		}

	}

	public void getContextDisplayText() {
		try {
			waitForElementToBeVisible(contextDropdown);
			clickElementJS(contextDropdown);
			contextDropdown.sendKeys(contextSearchTextFromParameter);
			clickElementJS(selectedFocusedContextValue);
			contextSearchValueText = selectedFocusedContextValue.getText();
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred in getContextDisplayText: " + e.getMessage());
			throw e;
		}
	}

	public boolean validateConfigName() {
		try {
			String configurationContextTitle = configurationValueText + " - " + contextSearchValueText;
			boolean isLabelCorrect = configurationContextTitle.equals(pageTitleText.getText());
			if (!isLabelCorrect) {
				LoggerManager.error("Validation failed: The label does not match the page title.");
				return false;
			} else {
				return true;
			}
		} catch (NoSuchElementException | TimeoutException e) {
			LoggerManager.error("Error occurred in validateConfigName: " + e.getMessage());
			return false;
		}
	}

	public boolean selectCiraBudgetRecommendationsandAssumptions() {
		try {
			clickElementJS(configurationDropdown);
			clickElement(recommendationsandAssumptions);
			configurationValueText = recommendationsandAssumptions.getText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			waitForElementToBeVisible(terminatedOntoggleButton);
			clickElementJS(terminatedOntoggleButton);
			getContextDisplayText();
			waitForInvisibility(loaderIcon);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error(
					"Error occurred in selectCiraBudgetRecommendationsandAssumptionsConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public boolean selectCiraBudgetSupplementalInformation() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(supplementalInformation);
			configurationValueText = supplementalInformation.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager
					.error("Error occurred in selectCiraBudgetSupplementalInformationConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public boolean selectCustomerDefinedInfo() {
		try {
			waitForElementToBeVisible(configurationDropdown);
			clickElementJS(configurationDropdown);
			clickElementJS(customerDefinedInfo);
			configurationValueText = customerDefinedInfo.getText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error("Error occurred in selectCustomerDefinedInfoConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public boolean selectEgnyteConfiguration() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(egnyteConfiguration);
			configurationValueText = egnyteConfiguration.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error("Error occurred in selectEgnyteConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public boolean selectHelp() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(help);
			configurationValueText = help.getText();
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error("Error occurred in selectHelpConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public boolean selectTransitionDocument() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(transitionDocument);
			configurationValueText = transitionDocument.getText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error("Error occurred in selectTransitionDocumentConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}

	public String selectTransitionTaskTemplates() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(transitionTaskTemplates);
			waitForElementToBeVisible(labelTransitionTaskTemplates);
			return labelTransitionTaskTemplates.getText();
		} catch (NoSuchElementException e) {
			LoggerManager.error("Error occurred in transitionTaskTemplates: " + e.getMessage());
			throw e;
		}
	}

	public boolean selectWorkOrderWorkAreas() {
		try {
			clickElementJS(configurationDropdown);
			clickElementJS(workOrderWorkAreas);
			configurationValueText = workOrderWorkAreas.getText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			getContextDisplayText();
			TimeUnit.SECONDS.sleep(TIMEOUT);
			// Call the validation method and get the result
			return validateConfigName();
		} catch (NoSuchElementException | InterruptedException | TimeoutException e) {
			LoggerManager.error("Error occurred in selectWorkOrderWorkAreasConfiguration: " + e.getMessage());
			Thread.currentThread().interrupt();
			return false;
		}
	}
}
