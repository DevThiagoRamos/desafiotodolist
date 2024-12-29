package br.com.thigas.desafiotodolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.thigas.desafiotodolist.entities.toDo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DesafiotodolistApplicationTests {

	@Autowired
	private WebTestClient WebTestClient;

	@Test
	void testCreateToDoSucess() {
		var toDo = new toDo("ToDo 1", "desc 1,", false, 1);

		WebTestClient
		.post()
		.uri("/toDos")
		.bodyValue(toDo)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$.length()").isEqualTo(1)
		.jsonPath("$[0].name").isEqualTo(toDo.getName())
		.jsonPath("$[0].description").isEqualTo(toDo.getDescription())
		.jsonPath("$[0].isCheck").isEqualTo(toDo.getIsCheck())
		.jsonPath("$[0].priority").isEqualTo(toDo.getPriority());
	}

	@Test
	void testCreateToDoFailure() {

		WebTestClient
		.post()
		.uri("/toDos")
		.bodyValue(
			new toDo("", "", false, 0))
		.exchange()
		.expectStatus().isBadRequest();
	}	
}
