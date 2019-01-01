package com.springmvc.service;

import java.util.List;


import com.springmvc.domain.Member;

public interface MemberService {

	List<Member> getAllMembers();

	Member getMemberById(String MemberID);
	
	void addMember(Member member);
	
	void deleteMember(String MemberId);
	
	void updateMember(Member member);
}
