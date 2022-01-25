package test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSimulacoes {

	@Test
	public void VerificarCadastramento() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/api/v1/simulacoes/777.852.897-40");
		assertEquals(200, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}

	@Test
	public void VerificarCadastramentoInvalido() {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/api/v1/simulacoes/24094592008");
		assertEquals(404, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}
}
