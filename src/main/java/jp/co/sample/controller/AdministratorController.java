package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.form.InsertAdministratorForm;
import jp.co.sample.service.AsministratirService;

@Controller
@RequestMapping("/AdministratorController")
public class AdministratorController {

	@Autowired
private AsministratirService administratorService;	
	
	@ModelAttribute
	public InsertAdministratorForm setUpInsertAdministratorForm() {
		
		InsertAdministratorForm  insertAdministratorForm	 = new InsertAdministratorForm();
		
		return insertAdministratorForm;
	}
	
	@RequestMapping("/toInsert")
		public String toInsert() {
		
		return "administrator/insert.html";
		
	}
	
}
