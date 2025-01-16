package com.r3sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.r3sys.dao.IssueProcessedDao;
import com.r3sys.dao.ProcessedMaterialDao;
import com.r3sys.model.IssueProcessed;
import com.r3sys.model.IssueRaw;
import com.r3sys.model.ProcessedMaterial;
import com.r3sys.model.RawMaterial;

@Controller
public class ProcessedController 
{
		@Autowired
		ProcessedMaterial  processed;
		
		@Autowired
		ProcessedMaterialDao  processedDao;
		
		@Autowired
		IssueProcessed iProcessed;
		
		@Autowired
		IssueProcessedDao iProcessedDao;
	
		@RequestMapping("/addProcessedItem")
		public String openAddProcessedItemPage()
		{
			return "addProcessedItem";
		}
		@RequestMapping(path="/addProcessedItem",method=RequestMethod.POST)
		public String addProcessedItemPage(@ModelAttribute ProcessedMaterial processed ,HttpServletRequest request)
		{
			int i = processedDao.insert(processed);
			
			if(i>0)
			{
				return "ProcessedHome";
			}
			else{
				return "addProcessedItem";
			}
			
		}
		@RequestMapping("/viewProcessedItems")
		public String openViewProcessedItemsPage(Model model)
		{
			List<ProcessedMaterial> processedList = processedDao.getAllRaw(processed);
			model.addAttribute("processedList",processedList);
			return "viewProcessedItems";
		}
		@RequestMapping("/ProcessedHome")
		public String openProcessedHomePage()
		{
			return "ProcessedHome";
		}
		@RequestMapping("/openUpdateProcessedItemQty")
		public String openUpdateProcessedItemQtyPage(Model model,HttpServletRequest request)
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			model.addAttribute("pid",pid);
			
			return "updateProcessedItemQty";
		}
		
		@RequestMapping(path="/updateProcessedItemQty",method=RequestMethod.POST)
		public String updateProcessedItemQtyPage(Model model,HttpServletRequest request)
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			float pQty =Float.parseFloat(request.getParameter("pQuantity"));
			if(pQty>0)
			{
				processed = processedDao.getProcessed(pid);
				float tempQty= processed.getpQuantity();
				processed.setpQuantity(pQty+tempQty);
				processedDao.qtyUpdate(processed);
				return "redirect:/viewProcessedItems";
			}
			else{
				return "updateProcessedItemQty";
			}
			
		}
		@RequestMapping("/deleteProcessedItem")
		public String deleteProcessedItemPage(Model model,HttpServletRequest request)
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			processedDao.delete(pid);
			return "redirect:/viewProcessedItems";
			
		}
		@RequestMapping(path="/openIssueProcessedItem",method=RequestMethod.GET)
		public String openIssueProcessedItemPage(Model model,HttpServletRequest request)
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			String pname = request.getParameter("pname");
			model.addAttribute("pid",pid);
			model.addAttribute("pname",pname);
			return "issueProcessedItem";
		}
		@RequestMapping(path="/issueProcessedItem",method=RequestMethod.POST)
		public String issueProcessedItemPage(IssueProcessed iProcessed,HttpServletRequest request)
		{
			int rid = Integer.parseInt(request.getParameter("pid"));
			processed = processedDao.getProcessed(rid);
			float pQty = processed.getpQuantity();
			float iQty = Float.parseFloat(request.getParameter("pQuantity"));
			if(pQty>=iQty)
			{
				int irId = iProcessedDao.insert(iProcessed);
				processed.setpQuantity(pQty-iQty);
				processedDao.qtyUpdate(processed);
				return "redirect:/viewProcessedItems";
			}
			else{
				return "issueProcessedItem";
			}
			
		}
		
		@RequestMapping("/viewIssueProcessedItem")
		public String openViewIssueProcessedItemPage(Model model)
		{
			List<IssueProcessed> iProcessedList = iProcessedDao.getAllIssueRaw(iProcessed);
			model.addAttribute("iProcessedList",iProcessedList);
			return "/viewIssueProcessedItem";
		}
		@RequestMapping("/showUnavailableProcessedItems")
		public String openShowUnavailableProcessedItemsPage(Model model)
		{
			List<ProcessedMaterial> processedList = processedDao.getAllRaw(processed);
		    model.addAttribute("processedList",processedList);
			return "showUnavailableProcessedItems";
		}
}


