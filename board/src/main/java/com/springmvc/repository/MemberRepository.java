package com.springmvc.repository;

import java.util.List;


import com.springmvc.domain.Member;


public interface MemberRepository {

	List <Member> getAllMembers();
	
	Member getMemberById(String MemberID);
	
	void addMember(Member member);
	void deleteMember(String MemberId);
	void updateMember(Member member);
	
}
