package com.gt.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gt.models.AjaxResponse;
import com.gt.models.Bod;
import com.gt.models.Company;
import com.gt.models.Contracts;
import com.gt.models.Diligence;
import com.gt.models.FinDoc1;
import com.gt.models.FinDoc10;
import com.gt.models.FinDoc11;
import com.gt.models.FinDoc12;
import com.gt.models.FinDoc13;
import com.gt.models.FinDoc2;
import com.gt.models.FinDoc3;
import com.gt.models.FinDoc4;
import com.gt.models.FinDoc5;
import com.gt.models.FinDoc6;
import com.gt.models.FinDoc7;
import com.gt.models.FinDoc8;
import com.gt.models.FinDoc9;
import com.gt.models.IncorporationDoc;
import com.gt.models.Ip;
import com.gt.models.IpDoc1;
import com.gt.models.IpDoc2;
import com.gt.models.It;
import com.gt.models.Legal;
import com.gt.models.Owner;
import com.gt.models.Revenue;
import com.gt.models.Technology;
import com.gt.models.Users;
import com.gt.services.BodService;
import com.gt.services.CompanyService;
import com.gt.services.ContractsService;
import com.gt.services.DiligenceService;
import com.gt.services.EmailService;
import com.gt.services.FinDoc10Service;
import com.gt.services.FinDoc11Service;
import com.gt.services.FinDoc12Service;
import com.gt.services.FinDoc13Service;
import com.gt.services.FinDoc1Service;
import com.gt.services.FinDoc2Service;
import com.gt.services.FinDoc3Service;
import com.gt.services.FinDoc4Service;
import com.gt.services.FinDoc5Service;
import com.gt.services.FinDoc6Service;
import com.gt.services.FinDoc7Service;
import com.gt.services.FinDoc8Service;
import com.gt.services.FinDoc9Service;
import com.gt.services.IncorporationDocService;
import com.gt.services.IpDoc1Service;
import com.gt.services.IpDoc2Service;
import com.gt.services.IpService;
import com.gt.services.ItService;
import com.gt.services.LegalService;
import com.gt.services.OwnerService;
import com.gt.services.RevenueService;
import com.gt.services.TechnologyService;
import com.gt.services.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;

	@Autowired
	CompanyService companyService;

	@Autowired
	LegalService legalService;

	@Autowired
	RevenueService revenueService;

	@Autowired
	TechnologyService technologyService;

	@Autowired
	IpService ipService;

	@Autowired
	ItService itService;

	@Autowired
	OwnerService ownerService;

	@Autowired
	BodService bodService;

	@Autowired
	ContractsService contractsService;

	@Autowired
	IncorporationDocService incorporationDocService;

	@Autowired
	IpDoc1Service ipDoc1Service;

	@Autowired
	IpDoc2Service ipDoc2Service;

	@Autowired
	FinDoc1Service finDoc1Service;

	@Autowired
	FinDoc2Service finDoc2Service;

	@Autowired
	FinDoc3Service finDoc3Service;

	@Autowired
	FinDoc4Service finDoc4Service;

	@Autowired
	FinDoc5Service finDoc5Service;

	@Autowired
	FinDoc6Service finDoc6Service;

	@Autowired
	FinDoc7Service finDoc7Service;

	@Autowired
	FinDoc8Service finDoc8Service;

	@Autowired
	FinDoc9Service finDoc9Service;

	@Autowired
	FinDoc10Service finDoc10Service;

	@Autowired
	FinDoc11Service finDoc11Service;

	@Autowired
	FinDoc12Service finDoc12Service;

	@Autowired
	FinDoc13Service finDoc13Service;

	@Autowired
	EmailService emailService;
	
	
	@Autowired
	DiligenceService diligenceService;
	
	public HttpSession getSession() {
		HttpServletRequest servRequest = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		HttpSession session = servRequest.getSession(true);
		return session;
	}
	
	
	public Integer createdById () {
		return Integer.parseInt(getSession().getAttribute("id").toString());
	}
	
	
	public Integer diligenceId () {
		return Integer.parseInt(getSession().getAttribute("diligenceId").toString());
	}
	
	
	public Map<String, String> getCountries(){
		String[] countryCodes = Locale.getISOCountries();
		 
        Map<String, String> mapCountries = new TreeMap<>();
 
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();
            mapCountries.put(code, name);
        }
        
        return mapCountries;
	}
	
	@GetMapping("/admin")
    public String home() {
        return "admin-view/home/admin-home";
    }
	
	@GetMapping("/activePartnersList")
    public String partnerList(Model model) {
		List<Diligence> diligenceList = diligenceService.findBystatus(1);
		
		model.addAttribute("diligenceList", diligenceList);
		
        return "admin-view/partner/partnerList";
    }
	
	
	@GetMapping("/partnerCreate")
    public String partnerCreate(Model model) {
		List<Diligence> diligenceList = diligenceService.findAll();
		
		model.addAttribute("partners", diligenceList);
        return "admin-view/partner/createPartner";
    }
    
	
	@PostMapping({"/creatOrUpdateeDiligence"})
    public ResponseEntity<?> addDiligence(@RequestBody Diligence request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			request.setCreatedBy(createdById().toString());
			request.setProfileStatus(0);
	    	
	    	String result = diligenceService.saveDiligence(request);
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping({"/deletePartner"})
    public ResponseEntity<?> deletePartner(@RequestBody Diligence request, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			
	    	String result = diligenceService.deleteDiligence(request.getId());
	    	
	    	response.setMessage(result);
	    	
	    	return ResponseEntity.ok(response);
		}
    	
		catch(Exception ex) {
			response.setMessage("Failed");
	    	
	    	return ResponseEntity.ok(response);
			
		}
    }
	
	@PostMapping("/getPartnerData")
    public String getPartnerData(@RequestParam("viewPartnerInfo") String viewPartnerInfo, Model model) {   
		String[] values = viewPartnerInfo.split(",");
		int dilId = Integer.parseInt(values[0]);
		String companyName = values[1];
		int selectedValue = Integer.parseInt(values[2]);
		
		if(selectedValue == 1) {			
			return this.viewCompany(dilId, companyName, model);
		}
		
		else if(selectedValue == 2) {
			return this.viewLegal(dilId, companyName, model);
		}
		
		else if(selectedValue == 3) {
			return this.viewFinancial(dilId, companyName, model);
		}
		
		else if(selectedValue == 4) {

			return this.viewRevenue(dilId, companyName, model);
		}
		
		else if(selectedValue == 5) {
			return this.viewTechnology(dilId, companyName, model);
		}
		
		else if(selectedValue == 6) {
			return this.viewIP(dilId, companyName, model);
		}
		
		else {
			return this.viewIT(dilId, companyName, model);
		}
		
    }
    
	@PostMapping("/viewCompany")
    public String viewCompany(int dilId, String companyName, Model model) {
		Company company = companyService.findBydiligenceId(dilId).get(0);
		List<Owner> ownerList = ownerService.findBydiligenceId(dilId);
		List<Bod> bodList = bodService.findBydiligenceId(dilId);
		model.addAttribute("companyName", companyName);
		model.addAttribute("company", company);
		model.addAttribute("ownerList", ownerList);
		model.addAttribute("bodList", bodList);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
        return "admin-view/partner/viewCompany";
    }
	
	@PostMapping("/viewLegal")
    public String viewLegal(int dilId, String companyName, Model model) {
		Legal legal = legalService.findBydiligenceId(dilId).get(0);
		model.addAttribute("companyName", companyName);
		model.addAttribute("legal", legal);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
        return "admin-view/partner/viewLegal";
    }
	
	@PostMapping("/viewFinancial")
    public String viewFinancial(int dilId, String companyName, Model model) {
		List<FinDoc1> finDoc1List = finDoc1Service.findBydiligenceId(dilId);
		List<FinDoc2> finDoc2List = finDoc2Service.findBydiligenceId(dilId);
		List<FinDoc3> finDoc3List = finDoc3Service.findBydiligenceId(dilId);
		List<FinDoc4> finDoc4List = finDoc4Service.findBydiligenceId(dilId);
		List<FinDoc5> finDoc5List = finDoc5Service.findBydiligenceId(dilId);
		List<FinDoc6> finDoc6List = finDoc6Service.findBydiligenceId(dilId);
		List<FinDoc7> finDoc7List = finDoc7Service.findBydiligenceId(dilId);
		List<FinDoc8> finDoc8List = finDoc8Service.findBydiligenceId(dilId);
		List<FinDoc9> finDoc9List = finDoc9Service.findBydiligenceId(dilId);
		List<FinDoc10> finDoc10List = finDoc10Service.findBydiligenceId(dilId);
		List<FinDoc11> finDoc11List = finDoc11Service.findBydiligenceId(dilId);
		List<FinDoc12> finDoc12List = finDoc12Service.findBydiligenceId(dilId);
		List<FinDoc13> finDoc13List = finDoc13Service.findBydiligenceId(dilId);
		
		model.addAttribute("companyName", companyName);
		model.addAttribute("finDoc1List", finDoc1List);
		model.addAttribute("finDoc2List", finDoc2List);
		model.addAttribute("finDoc3List", finDoc3List);
		model.addAttribute("finDoc4List", finDoc4List);
		model.addAttribute("finDoc5List", finDoc5List);
		model.addAttribute("finDoc6List", finDoc6List);
		model.addAttribute("finDoc7List", finDoc7List);
		model.addAttribute("finDoc8List", finDoc8List);
		model.addAttribute("finDoc9List", finDoc9List);
		model.addAttribute("finDoc10List", finDoc10List);
		model.addAttribute("finDoc11List", finDoc11List);
		model.addAttribute("finDoc12List", finDoc12List);
		model.addAttribute("finDoc13List", finDoc13List);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
		return "admin-view/partner/viewFinancial";
    }
	
	@PostMapping("/viewRevenue")
    public String viewRevenue(int dilId, String companyName, Model model) {
		Revenue revenue = revenueService.findBydiligenceId(dilId).get(0);
		List<Contracts> contractsList = contractsService.findBydiligenceId(dilId);
		model.addAttribute("companyName", companyName);
		model.addAttribute("revenue", revenue);
		model.addAttribute("contractsList", contractsList);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
		return "admin-view/partner/viewRevenue";
    }
	
	@PostMapping("/viewTechnology")
    public String viewTechnology(int dilId, String companyName, Model model) {
		Technology technology = technologyService.findBydiligenceId(dilId).get(0);
		List<IncorporationDoc> incorporationDocList = incorporationDocService.findBydiligenceId(dilId);
		model.addAttribute("companyName", companyName);
		model.addAttribute("technology", technology);
		model.addAttribute("incorporationDocList", incorporationDocList);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
		return "admin-view/partner/viewTechnology";
    }
	
	@PostMapping("/viewIP")
    public String viewIP(int dilId, String companyName, Model model) {
		Ip ip = ipService.findBydiligenceId(dilId).get(0);
		List<IpDoc1> ipDoc1List = ipDoc1Service.findBydiligenceId(dilId);
		List<IpDoc2> ipDoc2List = ipDoc2Service.findBydiligenceId(dilId);
		model.addAttribute("companyName", companyName);
		model.addAttribute("ip", ip);
		model.addAttribute("ipDoc1List", ipDoc1List);
		model.addAttribute("ipDoc2List", ipDoc2List);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
		return "admin-view/partner/viewIP";
    }
	
	@PostMapping("/viewIT")
    public String viewIT(int dilId, String companyName, Model model) {
		It it = itService.findBydiligenceId(dilId).get(0);
		model.addAttribute("companyName", companyName);
		model.addAttribute("it", it);
		model.addAttribute("getCountries", getCountries());
		model.addAttribute("dilId", dilId);
		
        return "admin-view/partner/viewIT";
    }
	
	@GetMapping("/userList")
	public String userList(Model model) {
		List<Users> userList = userService.findAll();
		List<Diligence> dilList = diligenceService.findBystatus(1);
		
		model.addAttribute("userList",userList);
		model.addAttribute("dilList",dilList);
		
		return "admin-view/user/user-view";
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<?> saveUser(@RequestBody Users users, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		int flag = 0;
		
		if(Objects.isNull(users.getId())) {
			flag = 1;
		}
		
		try {
			String result = null;
			
			if(users.getDiligenceId().contentEquals("0")) {
				response.setadditionalInfo("");
				
				if(flag == 1) {
					users.setCreatedBy(createdById().toString());
					users.setUpdatedBy(createdById().toString());
					result = userService.saveUser(users);
					emailService.sendEmail(users.getEmail(), users.getName(), users.getUsername(), users.getPassword());
				}
				
				else {
					Users user = userService.findByid(users.getId());
					users.setCreatedBy(user.getCreatedBy());
					users.setUpdatedBy(createdById().toString());
					result = userService.saveUser(users);
				}
			}
			
			else {
				Diligence diligence = diligenceService.findByid(Integer.parseInt(users.getDiligenceId())).get(0);
				response.setadditionalInfo(diligence.getName());
				if(flag == 1) {
					emailService.sendEmail(users.getEmail(), users.getName(), users.getUsername(), users.getPassword());
				}
			}
			
			
			
			response.setMessage(result);
			
			return ResponseEntity.ok(response);
		}
		
		catch(Exception e){
			response.setMessage("Failed");
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping("/deleteUser")
	public ResponseEntity<?> deleteUser(@RequestBody Users users, Errors errors) {
		AjaxResponse response = new AjaxResponse();
		try {
			userService.deleteUser(users.getId());;
			response.setMessage("Success");
			return ResponseEntity.ok(response);
		}
		
		catch(Exception e){
			response.setMessage("Failed");
			return ResponseEntity.ok(response);
		}
	}
	
	@PostMapping("/download")
	  public ResponseEntity<byte[]> downloadFile(@RequestParam("filename") String filename) throws IOException {
	    // Read the file from the file system or database
	    byte[] fileBytes = Files.readAllBytes(Paths.get(filename));

	    // Set the response headers to trigger a download
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    headers.setContentDisposition(ContentDisposition.builder("attachment").filename(filename).build());

	    // Return the file bytes as a response
	    return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
	  }
	  
	  @GetMapping("/viewFile")
	  public ResponseEntity<Resource> viewFile(@RequestParam("filename") String filename) throws IOException {
	      // Read the file from the file system or database
	      Path filePath = Paths.get(filename);
	      Resource resource = new UrlResource(filePath.toUri());

	      // Set the response headers to display the file in a new tab
	      HttpHeaders headers = new HttpHeaders();
	      headers.setContentType(MediaType.APPLICATION_PDF);
	      headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + filename);

	      // Return the file contents as a response
	      return new ResponseEntity<>(resource, headers, HttpStatus.OK);
	  }
	
}
