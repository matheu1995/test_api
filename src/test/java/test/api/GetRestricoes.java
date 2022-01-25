package test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRestricoes {

	@org.junit.Test 
	public void VerificarCpf() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/api/v1/restricoes/123.555.789-45");
		assertEquals(204, response.getStatusCode());
		System.out.println(response.asPrettyString());
	} 

	@org.junit.Test
	public void verificarCpfInvalido() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/api/v1/restricoes/97093236014");
		assertEquals(200, response.getStatusCode());
	}

}
