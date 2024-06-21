package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/*
	-@RestController annotation marks this class as a controller

	-a REST controller is responsible for handling HTTP requests, processing
	them, and returning appropriate HTTP responses.


	-controller methods return instances of domain classes, like Greeting.
	these domain objects are then converted into JSON and sent as the HTTP
	response body.
 */
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/*
		the @GetMapping annotation ensures that HTTP GET requests to /greeting re mapped to the
		greeting() method. There are companion annotations for other HTTP verbs like @PostMapping.
	 */

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
