package com.springmvc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.domain.Freeboard;
import com.springmvc.repository.FreeboardRepository;
import com.springmvc.service.FreeboardService;

@Service
public class FreeboardServiceImpl implements FreeboardService{
	
	@Autowired
	private FreeboardRepository freeboardRepository;

	
	public List<Freeboard> getAllFreeboards() {
		return freeboardRepository.getAllFreeboards();
	}

	public Freeboard getFreeboardById(int freeboardID) {
		return freeboardRepository.getFreeboardById(freeboardID);
	}
	
	public void addFreeboard(Freeboard freeboard) {
		   freeboardRepository.addFreeboard(freeboard);
	}
	public int getAllRecords() {
		   return freeboardRepository.getAllRecords();
	}
	

	public void deleteFreeboard(int freeboardID) {
		   freeboardRepository.deleteFreeboard(freeboardID);
	}
	
	
	public void updateFreeboard(Freeboard freeboard) {
		   freeboardRepository.updateFreeboard(freeboard);
	}
	
	public List<Freeboard> getSearchFreeboard(String find, String search) {
		   return freeboardRepository.getSearchFreeboard(find,  search);
	}
	
	public int getSearchRecords(String find, String search) {
		   return freeboardRepository.getSearchRecords(find,  search);
	}
	

	public void updateHit(int freeboardID) {
		freeboardRepository.updateHit(freeboardID);
	}
}
