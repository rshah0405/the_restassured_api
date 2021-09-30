package com.the.steps;

import com.the.constants.EndPoints;
import com.the.pojo.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UsersSteps {

@Step ("Getting all Users with id :{0},userName : {1},password :{2}")

    public ValidatableResponse getAllUsers(){

    return SerenityRest.rest()
            .given().log().all()
            .when()
            .get( EndPoints.GET_ALL_USERS )
            .then().log().all();


}
@Step("Creating Categories with id : {0} , userName : {1},password : {2}")
public ValidatableResponse createNewUser(int id,String userName,String password){

    UserPojo userPojo = new UserPojo();
    userPojo.setId( id );
    userPojo.setUserName( userName );
    userPojo.setPassword( password );

    return SerenityRest.rest()
            .given()
            .contentType( ContentType.JSON )
            .log().all()
            .when()
            .body( userPojo )
            .post(EndPoints.CREATE_NEW_USERS)
            .then();
}
@Step("Getting the user information with id : {0}")
    public ValidatableResponse getUserById(int userid){

    return SerenityRest.rest()
            .given()
            .pathParam( "id",userid )
            .contentType( ContentType.JSON )
            .when()
            .get(EndPoints.GET_SINGLE_USER_BY_ID)
            .then();

}

@Step("Updating User information with User id ")

   public ValidatableResponse updateUsers(int userId,String userName,String password){

    UserPojo userPojo = new UserPojo();
    userPojo.setId( userId );
    userPojo.setUserName( userName );
    userPojo.setPassword( password );


    return SerenityRest.rest()
            .given()
            .contentType( ContentType.JSON )
            .pathParam( "id", userId)
            .log().all()
            .when()
            .body( userPojo )
            .put(EndPoints.UPDATE_USER_BY_ID)
            .then();



}
@Step("Deleting the users information with Id :{0}")
    public ValidatableResponse deleteUserById(int userId){

    return SerenityRest.rest()
            .given()
            .pathParam( "id",userId )
            .when()
            .delete(EndPoints.DELETE_USER_BY_ID)
            .then();




}






}
