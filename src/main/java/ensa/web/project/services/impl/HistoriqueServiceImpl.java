package ensa.web.project.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ensa.web.project.entities.HistoriqueEntity;
import ensa.web.project.repositiries.HistoriqueRepository;
import ensa.web.project.services.HistoriqueService;
import ensa.web.project.shared.dto.HistoriqueDto;
import ensa.web.project.shared.dto.PostDto;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

	@Autowired
	HistoriqueRepository historiqueRepository;

	@Override
	public void createHistorique(String studentId, PostDto postDto) {

		ModelMapper modelMapper = new ModelMapper();
		HistoriqueDto historiqueDto = modelMapper.map(postDto, HistoriqueDto.class);

		historiqueDto.setStatus(postDto.getStatus());
		historiqueDto.setStudentId(studentId);
		historiqueDto.setDateEntree(postDto.getLocation().getDateEntree());
		historiqueDto.setDureeDeLocalisation(postDto.getLocation().getDureeDeLocation());

		ModelMapper moMapper = new ModelMapper();
		HistoriqueEntity historiqueEntity = moMapper.map(historiqueDto, HistoriqueEntity.class);

		historiqueRepository.save(historiqueEntity);

	}

	@Override
	public HistoriqueDto getHistoriqueByStudentId(String studentId) {

		HistoriqueEntity historiqueEntity = historiqueRepository.findByStudentId(studentId);

		ModelMapper modelMapper = new ModelMapper();

		HistoriqueDto historiqueDto = modelMapper.map(historiqueEntity, HistoriqueDto.class);
		
		return historiqueDto;
	}
	
	@Override
	public List<HistoriqueDto> getHistoriquesByStudentId(String studentId) {
		
		List<HistoriqueEntity> historiquesEntity = historiqueRepository.findAllByStudentId(studentId);
		List<HistoriqueDto> historiquesDto = new ArrayList<>();
		
		ModelMapper modelMapper = new ModelMapper();
		for(HistoriqueEntity historique: historiquesEntity) {
			HistoriqueDto historiqueDto = modelMapper.map(historique, HistoriqueDto.class);
			historiquesDto.add(historiqueDto);
		}
		
		return historiquesDto;
	}

	

}
