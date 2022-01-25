package test.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutSimulacoes {
    @Test
	public void alteraCadastramento() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type","application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Fernanda");
		json.put("cpf", "777.852.897-40"); 
		json.put("email", "hakob5260@uorak.com");
		json.put("valor", "8.000");
		json.put("parcelas", "4");
		json.put("seguro", "false");
		
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:8080/api/v1/simulacoes/777.852.897-40");
		assertEquals(200, response.getStatusCode());
		System.out.println(response.asPrettyString());
		

	} 
    @Test
	public void alteraCadastramentoErro() {
		RequestSpecification request = RestAssured.given();
		request.header("content-type","application/json");
		JSONObject json = new JSONObject();
		json.put("nome", "Fernanda");
		json.put("cpf", "777.852.897-40");
		json.put("email", "hakob5260@uorak.com");
		json.put("valor", "8.000");
		json.put("parcelas", "4");
		json.put("seguro", "false");
		
		request.body(json.toJSONString());
		Response response = request.put("http://localhost:8080/api/v1/simulacoes");
		assertEquals(405, response.getStatusCode());
		System.out.println(response.asPrettyString());
		
}
}
