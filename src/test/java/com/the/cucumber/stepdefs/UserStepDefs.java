package com.the.cucumber.stepdefs;

import com.the.steps.UsersSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
public class UserStepDefs {

    static int id = 12;
    static String userName = "userName12";
    static String password = "password12";
    static int userId;


    @Steps
    UsersSteps userSteps;

    @When("^user sends a GET request to the USER Endpoint ,they must get back a valid status code 200$")
    public void userSendsAGETRequestToTheUSEREndpointTheyMustGetBackAValidStatusCode() {

        userSteps.getAllUsers().statusCode( 200 );
    }

    @When("^I create a new user by providing the information id,userName and password$")
    public void iCreateANewUserByProvidingTheInformationIdUserNameAndPassword() {

    userId = userSteps.createNewUser( id,userName,password ).log().all().extract().response().body().jsonPath().getInt( "id" );

    }



    @Then("^I verify the user is created and I get a valid status code$")
    public void iVerifyTheUserIsCreatedAndIGetAValidStatusCode() {
        userSteps.getUserById( userId).log().all();
        System.out.println(userId);
    }

    @When("^I send GET request to users endpoint with Id, I should received the users information and I get valid status code 200$")
    public void iSendGETRequestToUsersEndpointWithIdIShouldReceivedTheUsersInformationAndIGetValidStatusCode() {
        userSteps.getUserById( userId).log().all().statusCode(200);


    }

    @When("^I update a created user providing the new userName \"([^\"]*)\"$")
    public void iUpdateACreatedUserProvidingTheNewUserName(String userName)  {

        userName = userName+"_Changed";
        userSteps.updateUsers( userId,userName,password ).statusCode( 200 );

    }


    @Then("^I verify the user is updated and I get valid status code$")
    public void iVerifyTheUserIsUpdatedAndIGetValidStatusCode() {

        userSteps.getUserById(userId ).body( "userName",equalTo(userName) );
    }

    @When("^I delete a created user ,I must get back a valid status code  200$")
    public void iDeleteACreatedUserIMustGetBackAValidStatusCode() {
        userSteps.deleteUserById(userId).statusCode( 200 );

    }

    @Then("^I verify the user is deleted$")
    public void iVerifyTheUserIsDeleted() {
        userSteps.getUserById( userId ).statusCode( 200 );

    }



}
