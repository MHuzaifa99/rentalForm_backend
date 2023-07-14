package com.road_runner.rental_form;

import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.road_runner.rental_form.controller.RentalFormController;
import com.road_runner.rental_form.model.RentalForm;
import com.road_runner.rental_form.repository.IRentalForm;

// AutoConfigureJsonTesters
@AutoConfigureMockMvc
@SpringBootTest
class RentalFormApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Mock
	private IRentalForm rentalFormRepo;

	@InjectMocks
	private RentalFormController rentalFormCon;

	private JacksonTester<RentalForm> jsonRentalForm;

	@BeforeEach
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(rentalFormCon).build();
	}

	LocalDateTime d = LocalDateTime.now();

	@Test
	void addRentalForm() throws Exception {
		RentalForm form = new RentalForm(1L, "test", "dfdsfsd", "dfsdfsdf", "dfdsfsdf", 26565l,
				d, d.plusDays(2));

		when(rentalFormRepo.save(form)).thenReturn(form);

		mvc.perform(MockMvcRequestBuilders.post("/rentalform/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonRentalForm.write(form).getJson()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getRentalForm() throws Exception {
		RentalForm form = new RentalForm(1L, "test", "dfdsfsd", "dfsdfsdf", "dfdsfsdf", 26565l,
				d, d.plusDays(2));
		List<RentalForm> formArr = new ArrayList<>();
		formArr.add(form);
		when(rentalFormRepo.findAll()).thenReturn(formArr);

		mvc.perform(MockMvcRequestBuilders.get("/rentalform/get")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void getByIdRentalForm() throws Exception {

		RentalForm form = new RentalForm(1L, "test", "dfdsfsd", "dfsdfsdf", "dfdsfsdf", 26565l, d, d.plusDays(2));
		when(rentalFormRepo.findById(1L)).thenReturn(Optional.of(form));

		mvc.perform(MockMvcRequestBuilders.get("/rentalform/get/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
