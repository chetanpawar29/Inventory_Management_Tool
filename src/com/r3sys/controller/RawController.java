package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.dao.IssueRawDao;
import com.r3sys.dao.MangerDao;
import com.r3sys.dao.RawMaterialDao;
import com.r3sys.model.IssueRaw;
import com.r3sys.model.RawMaterial;


@Controller
public class RawController {

	@Autowired
	RawMaterial raw;
	
	@Autowired
	RawMaterialDao rawDao;
	
	@Autowired
	IssueRaw iraw;
	
	@Autowired
	IssueRawDao issueDao;
	
	
	
	
	@RequestMapping("/")
	public String openIndexPage()
	{
		return "index";
	}
	@RequestMapping(path="/loginAdmin",method=RequestMethod.POST)
	public String loginAdmin(HttpServletRequest request)
	{
		String aemail = request.getParameter("email");
		String apass = request.getParameter("password");
	
		if(aemail.equals("admin@gmail.com") && apass.equals("admin"))
		{
			return "HomePage";
		}else
		{
			return "index";
		}
	}
	
	@RequestMapping("/HomePage")
	public String openHomePage()
	{
		return "HomePage";
	}
	@RequestMapping("/changePassword")
	public String openChangePassPage()
	{
		return "changePassword";
	}
	@RequestMapping("/RawHome")
	public String openRawHomePage()
	{
		return "RawHome";
	}
	
	
	@RequestMapping("/AddRawMaterial")
	public String openAddRawMaterialPage()
	{
		return "AddRawMaterial";
	}
	
	@RequestMapping(path="/AddRawMaterial",method=RequestMethod.POST)
	public String addRawMaterialPage(@ModelAttribute RawMaterial raw ,HttpServletRequest request)
	{
		int i = rawDao.insert(raw);
		
		if(i>0)
		{
			return "HomePage";
		}
		else{
			return "AddRawMaterial";
		}
		
	}
	
	@RequestMapping("/viewRawMaterial")
	public String openViewRawMaterialPage(Model model)
	{
		List<RawMaterial> rawList = rawDao.getAllRaw(raw);
		model.addAttribute("rawList",rawList);
		return "viewRawMaterial";
	}
	@RequestMapping(path="/openUpdateRawMaterialQty",method=RequestMethod.GET)
	public String openUpdateRawMaterialQtyPage(Model model,HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("rid"));
		model.addAttribute("rid",rid);
		return "updateRawMaterialQty";
	}
	@RequestMapping(path="/updateRawMaterialQty",method=RequestMethod.POST)
	public String updateRawMaterialQtyPage(Model model,HttpServletRequest request)
	{

		int rid = Integer.parseInt(request.getParameter("rid"));
		float rQty =Float.parseFloat(request.getParameter("rQuantity"));
		if(rQty>0)
		{
			raw = rawDao.getRaw(rid);
			float tempQty= raw.getrQuantity();
			raw.setrQuantity(rQty+tempQty);
			rawDao.qtyUpdate(raw);
			return "redirect:/viewRawMaterial";
		}
		else{
			return "updateRawMaterialQty";
		}
		
	}
	

	@RequestMapping("/deleteRawMaterial")
	public String deleteRawMaterialPage(Model model,HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("rid"));
		rawDao.delete(rid);
		return "redirect:/viewRawMaterial";
	}

	@RequestMapping(path="/openIssueRawMaterial",method=RequestMethod.GET)
	public String openIssueRawMaterialPage(Model model,HttpServletRequest request)
	{
		int rid = Integer.parseInt(request.getParameter("rid"));
		String rname = request.getParameter("rname");
		model.addAttribute("rid",rid);
		model.addAttribute("rname",rname);
		return "issueRawMaterial";
	}
	@RequestMapping(path="/issueRawMaterial",method=RequestMethod.POST)
	public String issueRawMaterialPage(@ModelAttribute IssueRaw iraw,HttpServletRequest request)
	{
	
		int rid = Integer.parseInt(request.getParameter("rid"));
		raw = rawDao.getRaw(rid);
		float rQty = raw.getrQuantity();
		float iQty = Float.parseFloat(request.getParameter("rQuantity"));
		if(rQty>=iQty)
		{
			int irId = issueDao.insert(iraw);
			raw.setrQuantity(rQty-iQty);
			rawDao.qtyUpdate(raw);
			return "redirect:/viewRawMaterial";
		}
		else{
			return "issueRawMaterial";
		}
		
	}
	@RequestMapping("/viewIssueRawMaterial")
	public String openViewIssueRawMaterialPage(Model model)
	{
		List<IssueRaw> iRawList = issueDao.getAllIssueRaw(iraw);
		model.addAttribute("iRawList",iRawList);
		
		return "/viewIssueRawMaterial";
	}
	
	@RequestMapping("/showUnavailableRawMaterials")
	public String openShowUnavailableRawMaterialPage(Model model)
	{
		List<RawMaterial> rawList = rawDao.getAllRaw(raw);
	    model.addAttribute("rawList",rawList);
		
		return "showUnavailableRawMaterials";
	}
}
