package com.springmvc.service.impl;

import java.util.List;


import com.springmvc.domain.Member;
import com.springmvc.repository.MemberRepository;
import com.springmvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository memberRepository;
	

	public List<Member> getAllMembers() {
		return memberRepository.getAllMembers();
	}

	public Member getMemberById(String MemberID) {
		return memberRepository.getMemberById(MemberID);
	}		


	public void addMember(Member member) {
		memberRepository.addMember(member);
	}
	
	public void deleteMember(String MemberId)
	{
		memberRepository.deleteMember(MemberId);
	}
	public void updateMember(Member member) {
		memberRepository.updateMember(member);
	}
	
	
}
