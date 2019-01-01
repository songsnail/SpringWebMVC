package com.springmvc.service;

import java.util.List;


import com.springmvc.domain.Freeboard;

public interface FreeboardService {

	List<Freeboard> getAllFreeboards();

	Freeboard getFreeboardById(int freeboardID);
	
	int getAllRecords();
	
	void addFreeboard(Freeboard freeboard);
	
	
	
	void deleteFreeboard(int freeboardID);
	
	void updateFreeboard(Freeboard freeboard);
	
	List<Freeboard> getSearchFreeboard(String find, String search);
	
	int getSearchRecords(String find, String search);
	
	void updateHit(int freeboardID);	
	
}
