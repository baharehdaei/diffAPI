package com.example.DiffingAPI;

import com.example.DiffingAPI.model.DiffingOutput;
import com.example.DiffingAPI.service.impl.DiffingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;


@SpringBootApplication
@RestController
public class DiffingApiApplication {

	@Autowired
	DiffingService diffingService;

	public static void main(String[] args) {
		SpringApplication.run(DiffingApiApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/v1/diff/1")
	public DiffingOutput equalsInput() {
		DiffingOutput diffingOutput = new DiffingOutput();
		try {
		diffingOutput = diffingService.equalsInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return diffingOutput;
	}


	@PutMapping("/v1/diff/1/right")
	public String right(@RequestParam(value = "data" ) String data) {
		String result = null;
		try {
			result = diffingService.addRightInput(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


	@PutMapping("/v1/diff/1/left")
	public String left(@RequestParam(value = "data") String data) {
		String result = null;
		try {
			result = diffingService.addLeftInput(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}


}
