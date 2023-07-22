package com.guimarey.sisincidencias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	@GetMapping("/")
    public String getEscritorio() {
		return "escritorio";
	}
	@GetMapping("/incidencias")
    public String getIncidencias() {
		return "incidencia";
	}
}
