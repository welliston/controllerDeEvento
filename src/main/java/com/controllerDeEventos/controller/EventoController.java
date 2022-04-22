package com.controllerDeEventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.controllerDeEventos.entities.Evento;
import com.controllerDeEventos.services.ServiceEvento;

@Controller
public class EventoController {
	
	@Autowired
	private ServiceEvento service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String carregaFormulario() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String salvarFormulario(Evento evento) {
		service.insert(evento);
		return "redirect:/cadastrarEvento";
	}
	@RequestMapping(value="/eventos")
	public ModelAndView listaDeEventos() {
		ModelAndView mv = new ModelAndView("index");
		List<Evento> allEventos = service.findAll();
		mv.addObject("eventos", allEventos);
		return mv;
		
	}
}
