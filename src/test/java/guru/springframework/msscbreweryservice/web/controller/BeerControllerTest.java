package guru.springframework.msscbreweryservice.web.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import guru.springframework.msscbreweryservice.web.model.BeerDto;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	void testGetBeerById() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/"+UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
		
	}

	@Test
	void testSaveNewBeer() throws Exception {
		
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJason = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/beer/")
				.accept(MediaType.APPLICATION_JSON)
				.content(beerDtoJason)).andExpect(MockMvcResultMatchers.status().isCreated());
		
	}

	@Test
	void testUpdateBeerById() throws Exception {
		BeerDto beerDto = BeerDto.builder().build();
		String beerDtoJason = objectMapper.writeValueAsString(beerDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/beer/"+UUID.randomUUID().toString())
				.accept(MediaType.APPLICATION_JSON)
				.content(beerDtoJason)).andExpect(MockMvcResultMatchers.status().isNoContent());	}

}
