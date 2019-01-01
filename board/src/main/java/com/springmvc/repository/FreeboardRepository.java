package com.springmvc.repository;


import java.util.List;

import com.springmvc.domain.Freeboard;

public interface FreeboardRepository {

	List <Freeboard> getAllFreeboards();
	
	Freeboard getFreeboardById(int freeboardID);	
	int getAllRecords();
	
	void addFreeboard(Freeboard freeboard);		
	void deleteFreeboard(int freeboardID);	
	void updateFreeboard(Freeboard freeboard);	
	
	List<Freeboard> getSearchFreeboard(String find, String search);
	
	int getSearchRecords(String find, String search);
	
	void updateHit(int freeboardID);
}
