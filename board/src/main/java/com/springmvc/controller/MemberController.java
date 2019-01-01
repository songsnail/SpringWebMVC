package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.domain.Member;
import com.springmvc.service.MemberService;
import com.springmvc.validator.MemberValidator;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.springmvc.exception.NoMemberByIdFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PathVariable;
@Controller
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;	
	
	@Autowired
	private MemberValidator memberValidator;
	
		
	/*@RequestMapping
	public String getAllMembers(Model model) {
		model.addAttribute("members", memberService.getAllMembers());
		return "member/members";
	}
	
	@RequestMapping("/member")
	public String getMemberById(@RequestParam("id") String memberId, Model model) {
		model.addAttribute("member", memberService.getMemberById(memberId));
		return "member/member";
	}
	*/
	@RequestMapping
	public ModelAndView getAllMembers() {
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("members", memberService.getAllMembers());
		modelAndView.setViewName("members");
		return modelAndView;
	}

/*	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitAllMembers() {
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("members", memberService.getAllMembers());
		modelAndView.setViewName("members");
		return modelAndView;
	}
	*/	
	@RequestMapping("/member")
	public ModelAndView getMemberById(@RequestParam("id") String memberId) {
		ModelAndView modelAndView = new ModelAndView();	
		modelAndView.addObject("member", memberService.getMemberById(memberId));
		modelAndView.setViewName("member");
		return modelAndView;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewMemberForm(@ModelAttribute("newMember") Member newMember) {
		
	   return "member/addMember";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitAddNewMemberForm( @ModelAttribute("newMember") @Valid Member member, BindingResult result) {
		if(result.hasErrors()) {
			return "member/addMember";
		}
		
		String[] suppressedFields = result.getSuppressedFields();

	      if (suppressedFields.length > 0) {
	         throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
	      }
	      
	  	MultipartFile image = member.getImage();
		
		String rootDirectory = "c:/upload/";
				
			if (image!=null && !image.isEmpty()) {
		       try {
		    	    File tempDir = new File(rootDirectory);
		           if(!tempDir.exists()) tempDir.mkdirs();
		          		           
		    	   String fname = image.getOriginalFilename(); 
		    	   image.transferTo(new File(rootDirectory + fname));		    	  
		    	   member.setFilename(fname);          
		    	 
		       } catch (Exception e) {
				throw new RuntimeException("Image saving failed", e);
		   }
		   }

				
	    memberService.addMember(member);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateMemberForm(@ModelAttribute("updateMember") Member member, @RequestParam("id") String memberId, Model model) {
		model.addAttribute("member", memberService.getMemberById(memberId));
		return "member/updateMember";
	}
	   
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String submitUpdateMemberForm(@Valid @ModelAttribute("updateMember") Member member,  BindingResult result,  Model model) {
	
	
	      
	      MultipartFile image = member.getImage();
			
			String rootDirectory = "c:/upload/";
					
				if (image!=null && !image.isEmpty()) {
			       try {
			    	   String fname = image.getOriginalFilename(); 
			    	   image.transferTo(new File("c:/upload/" + fname));
			    	   member.setFilename(fname);
			    		    	 
			       } catch (Exception e) {
					throw new RuntimeException("Image saving failed", e);
			   }
			   }
	    memberService.updateMember(member);
	   
	    	model.addAttribute("greeting", "회원정보가 수정되었습니다");
	    	return "member/updateok";
	    
	}


	@RequestMapping(value = "/delete/{id}")	
	public String delete(@PathVariable("id") String memberId) {
		
		memberService.deleteMember(memberId);
		return "redirect:/members";
	}
	
	/*@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public void delete(@PathVariable("id") String memberId) {
		
		memberService.deleteMember(memberId);
		//return "redirect:/members";
	}
	*/
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setValidator(memberValidator);
	}
	
	@ExceptionHandler(NoMemberByIdFoundException.class)
	public ModelAndView handleError(HttpServletRequest req, NoMemberByIdFoundException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("invalidMemberId", exception.getMemberId());
		 mav.addObject("exception", exception);
		 mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		 mav.setViewName("memberNotFound");
		 return mav;
	}
	


}
