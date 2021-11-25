package com.cov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody
	@RequestMapping("/hello/{name}/{tech}")
	public String sayHello(@PathVariable String name, @PathVariable String tech) {
		System.out.println("Inside a get method");
		return "Hello " + name + " hope you are enjoying " + tech;
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String sayOtherHello(@RequestParam String name, @RequestParam String tech)

	{
		System.out.println("Inside a post method");
		return "Hello " + name + " hope you are enjoying " + tech;
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.PUT)
	public String method1() {

		return "inside a put method";
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.DELETE)
	public String method2() {

		return "inside a Delete method";
	}

	@ResponseBody
	@RequestMapping(value = "/hello", method = RequestMethod.PATCH)
	public String method3() {

		return "inside a patch method";
	}

}