package com.juaracoding.utils;

public enum ScenarioTest {

    T1("Successful login with valid credentials"),
    T2("Unsuccessful login with invalid username"),
    T3("Unsuccessful login with invalid password"),
    T4("Unsuccessful login with empty username and valid password"),
    T5("Unsuccessful login with valid username and empty password"),
    T6("Unsuccessful login with both username and password fields empty"),
    T7("Add two products to the cart"),
    T8("Successful checkout with valid information"),
    T9("Unsuccessful checkout with empty information");



    private String scenarioTestName;

    ScenarioTest(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }

}
