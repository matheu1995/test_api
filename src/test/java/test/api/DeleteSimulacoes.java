package test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteSimulacoes {
	@Test
	public void DeletaCadastramento() {
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:8080/api/v1/simulacoes/57");
		assertEquals(200, response.statusCode());
		System.out.println(response.asPrettyString());
	}

	@Test
	public void DeletaCadastramentoErro() {
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("http://localhost:8080/api/v1/simulacoes");
		assertEquals(405, response.statusCode());
		System.out.println(response.asPrettyString());
	}
}
