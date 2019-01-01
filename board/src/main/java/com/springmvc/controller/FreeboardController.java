package com.springmvc.controller;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

import com.springmvc.domain.Freeboard;
import com.springmvc.domain.Member;
import com.springmvc.service.FreeboardService;


@Controller
@RequestMapping("/freeboard")
public class FreeboardController {
	
	@Autowired
	private FreeboardService freeboardService;
	
	
	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public String allFreeboards(@RequestParam("page") String page,  Model model) {			
				   
		model.addAttribute("total_record", freeboardService.getAllRecords());		
		model.addAttribute("page", page); 				
		model.addAttribute("freeboards", freeboardService.getAllFreeboards());		
		return "freeboard/list";
	}
	
	
	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public String SearchFreeboards(@RequestParam("find") String find, @RequestParam("search") String search, Model model) {
		
		model.addAttribute("total_record", freeboardService.getSearchRecords(find,search));				
		model.addAttribute("page", 1); 				
		model.addAttribute("freeboards", freeboardService.getSearchFreeboard(find,search));
	
		return "freeboard/list";
	}
	
	
	
	@RequestMapping("/view")
	public String getFreeboardById( @RequestParam("num") int num, @RequestParam("page") int page, Model model) {
		
		freeboardService.updateHit(num);
		Freeboard freeboard = freeboardService.getFreeboardById(num);
		freeboard.setContent(freeboard.getContent().replaceAll("<br>", "\n" ));
		model.addAttribute("freeboard", freeboard);
		model.addAttribute("page", page);
		
		
		
		return "freeboard/view";
		
		
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewWriteForm(@ModelAttribute("newWrite") Freeboard freeboard,  Model model) {	
		
	
		
	   return "freeboard/writeForm";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String submitAddNewWriteForm(@Valid @ModelAttribute("newWrite")  Freeboard freeboard, BindingResult result, HttpServletRequest request) {
		
		 if(result.hasErrors()) {
	         return "freeboard/writeForm";
	      }
		
		freeboard.setIp(request.getRemoteAddr());  
		freeboardService.addFreeboard(freeboard);
		
		return "redirect:/freeboard/list?page=1";
	}
	
	
	
	
	@RequestMapping(value = "/delete")
	public String getDeleteFreeboardForm(Model model, @RequestParam("num") int num, @RequestParam("page") int page) {		
		
			
		freeboardService.deleteFreeboard(num);
		return "redirect:/freeboard/list?page=1";
			
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String getUpdateFreeboardForm(@ModelAttribute("freeboard") Freeboard updateFreeboard,  @RequestParam("num") int num,  @RequestParam("page") int page, Model model) {
		
			
			
					
				
		Freeboard freeboard = freeboardService.getFreeboardById(num);		
		freeboard.setContent(freeboard.getContent().replaceAll("<br>", "\n" ));
		model.addAttribute("page", page);	
		model.addAttribute("freeboard",freeboard);	
		
		
		return "freeboard/updateForm";		
		
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String processUpdatewFreeboardForm(@Valid Freeboard updateFreeboard, BindingResult result, HttpServletRequest request) {
		
		if(result.hasErrors()) {
			
			return "freeboard/updateForm";
		}
	
		
		updateFreeboard.setIp(request.getRemoteAddr());  		
	   	freeboardService.updateFreeboard(updateFreeboard);	   
		return "redirect:/freeboard/list?page=1";
	}

	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String getPasswdForm( @RequestParam("num") int num, @RequestParam("page") int page,  @RequestParam("category") int category, Model model) {	
		model.addAttribute("num", num);
		model.addAttribute("page", page);	
		model.addAttribute("category", category);
		
	   return "freeboard/passwdForm";
	}
	
	@RequestMapping(value = "/confirm", method = RequestMethod.POST)
	public String submitPasswdForm( @RequestParam("num") int num, @RequestParam("page") int page,  @RequestParam("category") int category, @RequestParam("passwd") String passwd, Model model) {	
		
		model.addAttribute("num", num);	
		model.addAttribute("page", page);
		model.addAttribute("category", category);
		
		if (passwd.isEmpty()) {			
			model.addAttribute("freeboard_msg", "비밀번호를 입력해 주세요");			
			return "freeboard/passwdForm";
			
		}
		Freeboard freeboard = freeboardService.getFreeboardById(num);				
		if (!passwd.equals(freeboard.getPasswd())) {
			model.addAttribute("freeboard_msg", "권한이 없습니다");			
			return "freeboard/passwdForm";
		}
		if (category==1) {
			return  "redirect:/freeboard/delete";
		}
		else {
			return  "redirect:/freeboard/update";
		}
	   
	}

}
