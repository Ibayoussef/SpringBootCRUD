package ensa.web.project.controllers;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ensa.web.project.responses.HistoriqueResponse;
import ensa.web.project.services.HistoriqueService;
import ensa.web.project.shared.dto.HistoriqueDto;



@RequestMapping("/historique")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController

public class HistoriqueController {

	@Autowired
	HistoriqueService historiqueService;
	
//	@GetMapping(path="/{studentId}")
//	public ResponseEntity<HistoriqueResponse> getHistorique(@PathVariable String studentId) {
//		
//		HistoriqueDto historiqueDto = historiqueService.getHistoriqueByStudentId(studentId);
//		
//		ModelMapper modelMapper = new ModelMapper();
//		HistoriqueResponse historiqueResponse = modelMapper.map(historiqueDto, HistoriqueResponse.class);
//		
//		return new ResponseEntity<HistoriqueResponse>(historiqueResponse, HttpStatus.ACCEPTED);
//
//	}
	
	@GetMapping(path="/{studentId}")
	public List<HistoriqueResponse> getAllHistorique(@PathVariable String studentId){
		
		List<HistoriqueDto> historiquesDto = historiqueService.getHistoriquesByStudentId(studentId);
		List<HistoriqueResponse> historiquesResponse = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		
		for(HistoriqueDto historique: historiquesDto) {
			HistoriqueResponse historiqueResponse = modelMapper.map(historique, HistoriqueResponse.class);
			historiquesResponse.add(historiqueResponse);
		}
		
		return historiquesResponse;
		
	}
}
