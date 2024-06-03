package helper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
    public static RequestSpecification getRequestSpec(){
          return new RequestSpecBuilder().setBaseUri("https://api.spotify.com")
                    .setBasePath("/v1")
                    .addHeader("Authorization","Bearer BQD77Nq8Kkc2j4nsFoQsotCoMuK8oNFSrFL3iWXtUJAxiK7ZLMifYg50haMuWFNtMcBiLhImcwgfog2E2mUWbIhZxWR_KCImI5GF-Ss9vTn8WCl9U_tqdm3R2Pblfe1XJrLMZSSm5rSjzVqGcbwAiCWGxCZAuqvAsN8peBueh-KSqzco2nvrmin2uCHYDRaUL617y2kJnecLRyPndxHWnzVeWuM9J0NJuumPw3VcoVbBQxiIKCszvXR-dDERyqm69zA7CSsCodowMzsk")
                  .setContentType("application/json")
                    .log(LogDetail.ALL).build();

        }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();

    }
}
