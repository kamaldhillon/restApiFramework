package globalconstants;


import propertymanagement.ApiProperties;

public class RestAssuredConstants
{
    public static final String ContentType = "Content-Type";
    public static final String ApplicationJson = "application/json; charset=UTF-8";
    public static final String auth="Bearer "+ ApiProperties.getProperty("auth.token");
    
}
