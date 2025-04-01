package com.ciranet.myworkqueue.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ciranet.constants.Constants;
import com.ciranet.myworkqueue.pages.ProjectsTasksPage;
import com.ciranet.testbase.TestBase;
import com.ciranet.utilities.LoggerManager;
import com.ciranet.utilities.RequiresLogin;

@RequiresLogin
public class ProjectsTasksPageTest extends TestBase 
{
	ProjectsTasksPage projectsTasksPage = createPage(ProjectsTasksPage.class);

	@Test(priority = 0, description = "Verify Projects / Tasks navigation", groups = 
		{
			Constants.SMOKE_TESTING }, alwaysRun = true)
	public void verifyProjectsTasksNavigation() 
	{
		LoggerManager.info("Verifying Projects / Tasks navigation");
		TestBase.setExtentReportSettings("Projects / Tasks", Constants.SMOKE_TESTING,
				"Verify Projects / Tasks", "Verifying Projects / Tasks navigation");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.navigateToProjectsTasks());
	}

	@Test(priority = 1, description = "Verify tab Switching", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyTabSwitching() 
	{
		LoggerManager.info("Verifying Tab Switch");
		TestBase.setExtentReportSettings("Tab Switch", Constants.FUNCTIONAL_TESTING, "Verify Tab Switch",
				"Verifying Tab Switch");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyTabSwitching());
	}

	@Test(priority = 2, description = "Verify Refresh Button", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyRefreshButtonClick() {
		LoggerManager.info("Verifying Refresh button");
		TestBase.setExtentReportSettings("Refresh Button", Constants.FUNCTIONAL_TESTING,
				"Verify Refresh button", "Verifying Refresh button");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyRefreshButtonClick());
	}

	@Test(priority = 3, description = "Verify Notification Settings", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyNotificationSettings() {

		TestBase.setExtentReportSettings("Notification Settings", Constants.FUNCTIONAL_TESTING,
				"Verify Notification Settings", "Verifying Notification Settings");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyNotificationSettingsButton());
	}

	@Test(priority = 4, description = "Verify Expand And Collapse icon", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyExpandCollapse() {
		LoggerManager.info("Verifying Expand and Collapse icon");
		TestBase.setExtentReportSettings("Expand Collapse icon", Constants.FUNCTIONAL_TESTING, "Verify Expand Collapse icon",
				"Verifying Expand Collapse icon");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyToolbarExpandAndCollapse());
	}

	@Test(priority = 5, description = "Verify Full screen icon", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyToolbarFullScreen() {
		LoggerManager.info("Verifying Full screen");
		TestBase.setExtentReportSettings("Full Screen", Constants.FUNCTIONAL_TESTING, "Verify Full Screen icon",
				"Verifying Full Screen icon");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyToolbarFullScreen());
	}

	@Test(priority = 6, description = "Verify Normal screen icon", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyToolbarNormalScreenIcon() 
	{
		LoggerManager.info("Verifying Normal screen icon");
		TestBase.setExtentReportSettings("Normal Screen Icon", Constants.FUNCTIONAL_TESTING, "Verify Normal Screen",
				"Verifying Normal screen icon");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyToolbarNormalScreen());
	}

	@Test(priority = 7, description = "Verify Column Chooser icon", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyToolbarColumnChooserIcon() {
		LoggerManager.info("Verifying Column Chooser icon");
		TestBase.setExtentReportSettings("Column Chooser icon", Constants.FUNCTIONAL_TESTING,
				"Verify Column Chooser icon", "Verifying Column chooser icon");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyToolbarColumnChooserIcon());
	}

	@Test(priority = 8, description = "Verify Add New Project Task", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyAddNewProjectTaskButton() {
		LoggerManager.info("Verifying Add New Project Task");
		TestBase.setExtentReportSettings("Add New Project Task", Constants.FUNCTIONAL_TESTING,
				"Verify Add New Project task", "Verifying Add New Project Task");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyAddNewProjectTaskButton());
	}

	@Test(priority = 9, description = "Verify Closed within Days Textbox", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyDaysTextbox() {
		LoggerManager.info("Verifying Closed within Days Textbox");
		TestBase.setExtentReportSettings("Closed within Days Textbox", Constants.FUNCTIONAL_TESTING,
				"Verify Closed within Days Textbox", "Verifying Closed within Days Textbox");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyClosedWithinDaysTextBox());
	}

	@Test(priority = 10, description = "Verify Action View/ Edit", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyActionEdit() 
	{
		LoggerManager.info("Verifying Action View/ Edit");
		TestBase.setExtentReportSettings("Action View/ Edit", Constants.FUNCTIONAL_TESTING, "Verify Action View/ Edit",
				"Verifying Action View/ Edit");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyActionViewEdit());
	}

	@Test(priority = 11, description = "Verify Help icon", groups = { Constants.FUNCTIONAL_TESTING })
	public void verifyHelpButton() 
	{
		LoggerManager.info("Verifying Help icon");
		TestBase.setExtentReportSettings("Help icon", Constants.FUNCTIONAL_TESTING, "Verify Help icon",
				"Verifying Help icon");
		projectsTasksPage = new ProjectsTasksPage(driver);
		assertTrue(projectsTasksPage.verifyHelpIcon());
	}

}



