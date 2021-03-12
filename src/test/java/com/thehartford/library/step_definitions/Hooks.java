package com.thehartford.library.step_definitions;
import com.thehartford.library.utilities.ConfigurationReader;
import com.thehartford.library.utilities.DBUtils;
import com.thehartford.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.util.concurrent.TimeUnit;
import io.restassured.RestAssured;


public class Hooks {

    @Before(order = 0)
    public void setUpScenario() {
        System.out.println("set up browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().fullscreen();
        RestAssured.baseURI = ConfigurationReader.getProperty("qa2_base_url");
    }

    @Before(value = "@db", order = 1)
    public void connect() {
        System.out.println("connecting to db");
        String url = "jdbc:mysql://" + ConfigurationReader.getProperty("qa2_db_host") +
                ConfigurationReader.getProperty("qa2_db_name");
        String username = ConfigurationReader.getProperty("qa2_db_username");
        String password = ConfigurationReader.getProperty("qa2_db_password");
        System.out.println(url);
        DBUtils.createConnection(url, username, password);
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.getName() = " + scenario.getName());
        scenario.write("Complete scenario: " + scenario.getName());
        if (scenario.isFailed()) {
            // take screenshot using selenium
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            // attach to report
            scenario.embed(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @After("@db")
    public void closeConnection() {
        System.out.println("closing connection to db");
        DBUtils.destroy();
    }

}