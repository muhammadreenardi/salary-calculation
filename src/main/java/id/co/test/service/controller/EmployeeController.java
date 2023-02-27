package id.co.test.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.test.service.model.SaveEmployeeData;
import id.co.test.service.repository.EmployeeRepository;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo;

	@RequestMapping(value = "/GetEmployeeList", method = RequestMethod.GET)
	public String doGetDocumentPendukungList(
			@RequestParam(name = "search", required = false) String search) {		
		return repo.doGetEmployeeList(search);
	}
	
	@RequestMapping(value = "/SaveEmployeeData", method = RequestMethod.POST)
	public String doSaveEmployee(@RequestBody SaveEmployeeData request) {
		return repo.doSaveEmployee(request);
	}
}
