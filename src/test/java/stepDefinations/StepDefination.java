package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;
import static org.hamcrest.Matchers.equalTo;

public class StepDefination {


    @Given("User is on NetBanking landing page")
    public void userIsOnNetBankingLandingPage() throws IOException {
        RestAssured.baseURI ="https://rahulshettyacademy.com";
        String response = given().log().all()
                .queryParam("key","qaclick123")
                .header("Content-Type","application/json")
//                .body(MapAPIPayload.addPlace())
                //providing json data to the body from external file
                .body(new String(readAllBytes(Paths.get("/Users/testvagrant/Desktop/newPlace.json"))))
                .when().post("/maps/api/place/add/json")
                .then()
                .assertThat()
                .statusCode(200)
                .body("scope",equalTo("APP"))
                .extract().response().asPrettyString();
        //Act
        JsonPath jsonPath = new JsonPath(response);
        String status = jsonPath.getString("status");
        //Assert
        Assert.assertEquals(status,"OK","status is not ok");
        System.out.println("landed to login page ");
    }

    @When("User login to the application with {string} and {string}")
    public void userLoginToTheApplicationWithAnd(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }

    @Then("Home page is populated")
    public void homePageIsPopulated() {
        System.out.println("landed in home page");
    }

    @And("Cards are displayed")
    public void cardsAreDisplayed() {
        System.out.println("cards are displaying");
    }

    @And("Cards are not displayed")
    public void cardsAreNotDisplayed() {
        System.out.println("Cards are not displayed");
    }
}
