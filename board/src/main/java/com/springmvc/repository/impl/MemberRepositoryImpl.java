package com.springmvc.repository.impl;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springmvc.domain.Member;
import com.springmvc.domain.Member;
import com.springmvc.domain.Member;
import com.springmvc.repository.MemberRepository;
import com.springmvc.exception.NoMemberByIdFoundException;
import com.springmvc.exception.NoMemberByIdFoundException;

@Repository
public class MemberRepositoryImpl implements MemberRepository{
	
private JdbcTemplate jdbcTemplate;		
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
	//	 this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
		
		public List<Member> getAllMembers() {
			 String SQL = "SELECT * FROM member";
		
			List<Member> listOfMembers = this.jdbcTemplate.query(SQL, new MemberRowMapper());
			return listOfMembers;
			
			/*ï¿½ë¸žï¿½ë§–
			 * String SQL = "SELECT p_boardId, p_name, p_unitPrice, p_description, p_manufacturer, p_category, p_unitsInStock, p_unitsInOrder, p_discontinued,p_condition, p_fileName FROM board";
			RowMapper<Board> mapper = new BeanPropertyRowMapper<Board>(Board.class);
			List <Board> board = this.template.query(SQL, mapper);
			 
			  return board;
			*/
		}

		public Member getMemberById(String memberId) {
			Member  memberById = null;
			List<Member> listOfMembers = getAllMembers();
			
			for(Member member : listOfMembers) {
				if(member!=null && member.getId()!=null && member.getId().equals(memberId)){
					memberById = member;
					break;
				}
			}
		
			
			
			return memberById;
		}
		
				
		public Member getMemberByIdAndPassword (String memberId, String memberPasswd) {
			Member  memberById = null;
			List<Member> listOfMembers = getAllMembers();
			
			for(Member member : listOfMembers) {
				if(member!=null && member.getId()!=null && member.getId().equals(memberId) 
						&& member.getPasswd().equals(memberPasswd)){
					memberById = member;
					break;
				}
			}
			
		
			
			
			return memberById;
		}
		public void addMember(Member member) {		
		    
			
			 String SQL = "INSERT INTO member (id, passwd, name, sex, tel, address,  role) "
			 		+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		      
			 this.jdbcTemplate.update(SQL, member.getId(),  member.getPasswd(), member.getName(),
					 member.getSex(), member.getTel(), member.getAddress(),  "ROLE_USER");
		    	
		      
		}
	
		public void updateMember(Member member) {	   
			 
					 
			String SQL = "UPDATE member SET passwd = ?, name = ?, sex = ?, tel = ?, address = ? "
					+ "where id = ? "; 
			this.jdbcTemplate.update(SQL, member.getPasswd(), member.getName(), member.getSex(), member.getTel(), 
					member.getAddress(),   member.getId());
			
		      
		}
	public void deleteMember(String memberId) {
		
		String SQL = "DELETE from member  where id = ? "; 
	      
		 this.jdbcTemplate.update(SQL, memberId);
	}
	
		
}

class MemberRowMapper implements RowMapper<Member>{
	    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
	      //ITEM Å×ÀÌºíÀÇ ·¹ÄÚµå¸¦ Item ÀÎ½ºÅÏ½º·Î ¸ÊÇÎ
	    	Member member = new Member();
	    	member.setId(rs.getString(1));
	    	member.setPasswd(rs.getString(2));
	    	member.setName(rs.getString(3));
	    	member.setSex(rs.getString(4));
	    	member.setTel(rs.getString(5));
	    	member.setAddress(rs.getString(6));		    	
	    	member.setRole(rs.getString(7));	
	    	
	    	return member;
	    }
}

