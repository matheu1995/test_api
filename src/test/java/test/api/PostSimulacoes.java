package test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class PostSimulacoes {
 
	@Test
	public void cadastramentoValido() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Fernanda"); 
		json.put("cpf", "777.852.897-40");
		json.put("email", "hakob5260@uorak.com");
		json.put("valor", "4.000");
		json.put("parcelas", "3");
		json.put("seguro", "true");

		request.body(json.toJSONString());
		Response response = request.post("http://localhost:8080/api/v1/simulacoes");
		assertEquals(201, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}

	@Test
	public void cadastramentoInvalido() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "jeane");
		json.put("cpf", "456.888.789-87");
		json.put("email", "hakob5260@uorak.com");
		json.put("valor", "");
		json.put("parcelas", "2");
		json.put("seguro", "true");

		request.body(json.toJSONString());
		Response response = request.post("http://localhost:8080/api/v1/simulacoes");
		assertEquals(400, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}

	@Test
	public void cadastramentoDenovo() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type", "application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Fernanda");
		json.put("cpf", "777.852.897-40");
		json.put("email", "hakob5260@uorak.com");
		json.put("valor", "4.000");
		json.put("parcelas", "3");
		json.put("seguro", "true");

		request.body(json.toJSONString());
		Response response = request.post("http://localhost:8080/api/v1/simulacoes/777.852.897-40");
		assertEquals(405, response.getStatusCode());
		System.out.println(response.asPrettyString());
	}
}
