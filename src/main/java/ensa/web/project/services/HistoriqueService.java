package ensa.web.project.services;

import java.util.List;

import ensa.web.project.shared.dto.HistoriqueDto;
import ensa.web.project.shared.dto.PostDto;

public interface HistoriqueService {
	
	void createHistorique(String studentId, PostDto postDto);
	
	HistoriqueDto getHistoriqueByStudentId(String studentId);
	List<HistoriqueDto> getHistoriquesByStudentId(String studentId);

	
}
