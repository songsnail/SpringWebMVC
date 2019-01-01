package com.springmvc.repository.impl;

import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.domain.Freeboard;
import com.springmvc.repository.FreeboardRepository;

@Repository
public class FreeboardRepositoryImpl implements FreeboardRepository{
	

	private JdbcTemplate jdbcTemplate;		
	
	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Freeboard> getAllFreeboards() {
		 String SQL = "SELECT  num, name, passwd, subject, content, regist_day, hit, ip FROM freeboard ORDER BY num DESC ";
		
			 
		List<Freeboard> listOfFreeboards = this.jdbcTemplate.query(SQL,new FreeboardRowMapper());
		return listOfFreeboards;
	
	}

	public Freeboard getFreeboardById(int freeboardID) {
		Freeboard freeboardById = null;
		
		List<Freeboard> listOfFreeboards = getAllFreeboards();
		
		for(Freeboard freeboard : listOfFreeboards) {
			if(freeboard!=null && freeboard.getNum()==freeboardID){
				freeboardById = freeboard;
				break;
			}
		}
		
		return freeboardById;
	}
		
	public int getAllRecords() {
		 String SQL = "SELECT  count(*) FROM freeboard";
		
		int rowCount = this.jdbcTemplate.queryForObject(SQL, Integer.class);
		
		return rowCount;
	
	}
	
	
	public void addFreeboard(Freeboard freeboard) {		
					    
		
		SimpleDateFormat  date = new SimpleDateFormat("yyyy/MM/dd(a hh:mm:ss)");
		
		String SQL = "INSERT INTO freeboard (name, passwd, subject, content, regist_day, hit, ip) "
				 		+ "VALUES (?, ?, ?, ?, ?, ?,?)";
		
		
		
		this.jdbcTemplate.update(SQL, freeboard.getName(), freeboard.getPasswd(),   freeboard.getSubject(), freeboard.getContent(), date.format(new Date()), freeboard.getHit(), freeboard.getIp());
			    	
		return;
	}	
	public void deleteFreeboard(int freeboardID) {			    
		   
		
		 String SQL = "DELETE from freeboard  where num = ? "; 
	      
		 this.jdbcTemplate.update(SQL, freeboardID);
	    
	}	      
	
	
	public void updateFreeboard(Freeboard freeboard) {	   
		   
		SimpleDateFormat  date = new SimpleDateFormat("yyyy/MM/dd(a hh:mm:ss)");
		
		String SQL = "UPDATE freeboard SET name = ?, passwd =? , subject = ?, content = ?, regist_day = ?, hit = ?, ip = ? where num = ? "; 
		
		this.jdbcTemplate.update(SQL, freeboard.getName(), freeboard.getPasswd(), freeboard.getSubject(), freeboard.getContent(), date.format(new Date()),freeboard.getHit(), freeboard.getIp(), freeboard.getNum());
		  
	      
	}
	public List<Freeboard> getSearchFreeboard(String find, String search) {
		
		 String SQL = "SELECT  num, name, passwd, subject, content, regist_day, hit, ip FROM freeboard where "+find+" like '%"+search+"%' ORDER BY num DESC ";
		List<Freeboard> listOfFreeboards = this.jdbcTemplate.query(SQL,new FreeboardRowMapper());
		return listOfFreeboards;
	
	}
	
	public int getSearchRecords(String find, String search) {
		 String SQL = "SELECT  count(*) FROM freeboard where "+find+" like '%"+search+"%' ORDER BY num DESC ";
		
		int rowCount = this.jdbcTemplate.queryForObject(SQL, Integer.class);
		
		return rowCount;
	
	}
	

	public void updateHit(int freeboardID) {	   
	
		Freeboard freeboard = getFreeboardById(freeboardID);
		int hit = freeboard.getHit()+1;
				
		String SQL = "UPDATE freeboard SET hit = ? where num = ? "; 
		
		this.jdbcTemplate.update(SQL, hit, freeboardID);
		  
	      
	}
	
	
}
class FreeboardRowMapper implements RowMapper<Freeboard>{
	 public Freeboard mapRow(ResultSet rs, int rowNum) throws SQLException {
	   	Freeboard freeboard = new Freeboard();
	   	freeboard.setNum(new Integer(rs.getInt(1)));;
	   	freeboard.setName(rs.getString(2));
	   	freeboard.setPasswd(rs.getString(3));
	   	freeboard.setSubject(rs.getString(4));
	   	freeboard.setContent(rs.getString(5));
	   	freeboard.setRegist_day(rs.getString(6));
	   	freeboard.setHit(new Integer(rs.getInt(7)));;		
	   	freeboard.setIp(rs.getString(8));	
	   	return freeboard;
	}
}