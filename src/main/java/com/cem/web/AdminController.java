package com.cem.web;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;

import com.cem.entity.Department;
import com.cem.entity.Product;
import com.cem.entity.Question;
import com.cem.entity.User;
import com.cem.entity.support.CSVProduct;
import com.cem.entity.support.FileUploadForm;
import com.cem.entity.support.FileUploadForm.Type;
import com.cem.entity.support.Repository;
import com.cem.web.support.QuestionService;
import com.evalua.entity.support.DataStoreManager;


@Controller
public class AdminController {

	@Resource
	private DataStoreManager dataStoreManager;

	@Resource
	private Repository repository;

	@Autowired
	ServletContext servletContext;
	
	@Resource
	private QuestionService questionService;


	@RequestMapping("/admin")
	public ModelAndView login(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/index");
		String user=(String) httpSession.getAttribute("user");
		if(user ==null || !user.equals("admin")){
			return new ModelAndView("redirect:/admin/login");
		}

		mv.addObject("users",repository.listUsers());
		mv.addObject("questions",repository.listAllQuestions());
		mv.addObject("products",repository.listAllProducts());
		mv.addObject("departments",repository.listAllDepartments());
		return mv;
	}

	@RequestMapping("/admin/questions")
	public ModelAndView blockedUsers(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/questions");

		mv.addObject("users",repository.listUsers());
		mv.addObject("questions",repository.listAllQuestions());
		mv.addObject("products",repository.listAllProducts());
		mv.addObject("departments",repository.listAllDepartments());	
		return mv;
	}

	@RequestMapping("/admin/departments")
	public ModelAndView latestRegistration(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/departments");
		mv.addObject("users",repository.listUsers());
		mv.addObject("questions",repository.listAllQuestions());
		mv.addObject("products",repository.listAllProducts());
		mv.addObject("departments",repository.listAllDepartments());
		return mv;
	}

	@RequestMapping("/admin/products")
	public ModelAndView verifyPostsList(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/products");
		mv.addObject("users",repository.listUsers());
		mv.addObject("questions",repository.listAllQuestions());
		mv.addObject("products",repository.listAllProducts());
		mv.addObject("departments",repository.listAllDepartments());
		return mv;
	}

	@RequestMapping("/admin/add-new-movie")
	public ModelAndView showAddNew(HttpSession httpSession){
		ModelAndView mv=new ModelAndView("admin/add-new-movie");

		return mv;
	}


	@RequestMapping("/admin/upload")
	public ModelAndView uploadBulk(){

		ModelAndView mv= new ModelAndView("admin/upload");
		mv.addObject("users",repository.listUsers());
		mv.addObject("questions",repository.listAllQuestions());
		mv.addObject("products",repository.listAllProducts());
		mv.addObject("departments",repository.listAllDepartments());
		return mv;
	}

	@RequestMapping("/admin/graphs")
	public ModelAndView showGraph(){
		return new ModelAndView("admin/graph");
	}

	@RequestMapping("/admin/delete-user")
	public ModelAndView deleteUser(@RequestParam Long id){
		User user=repository.findUserById(id);		
		dataStoreManager.delete(user);

		return new ModelAndView("redirect:/admin");
	}	
	
	@RequestMapping("/admin/delete-product")
	public ModelAndView deleteProduct(@RequestParam Long id){
		Product product=repository.findProductById(id);		
		dataStoreManager.delete(product);

		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping("/admin/delete-department")
	public ModelAndView deleteDepartment(@RequestParam Long id){
		Department department=repository.findDepartmentById(id);		
		dataStoreManager.delete(department);

		return new ModelAndView("redirect:/admin");
	}

	@RequestMapping("/admin/login")	
	public ModelAndView login(){		
		return new ModelAndView("admin/login");	
	}

	@RequestMapping("/admin/authenticate")	
	public ModelAndView authenticate(@RequestParam String email, @RequestParam String password, HttpSession session){	
		if(email.equals("admin") && password.equals("1234")){
			session.setAttribute("user", "admin");
			return new ModelAndView("redirect:/admin/");	
		}
		return new ModelAndView("redirect:/admin/login");
	}

	@RequestMapping("/admin/logout")	
	public ModelAndView logout(HttpSession session){		
		session.invalidate();
		return new ModelAndView("redirect:/admin/login");	
	}	


	@RequestMapping("/admin/upload-bulk")
	public ModelAndView bulkUpload(@ModelAttribute(FileUploadForm.key) FileUploadForm fileUploadForm) throws IOException{	


		try {

			File csvFile = new File(servletContext.getRealPath("WEB-INF/classes/csv/temp.csv"));
			if(csvFile.exists()){
				csvFile.delete();
			}

			System.out.println("***** Creating file at "+servletContext.getRealPath("WEB-INF/classes/csv/temp.csv"));
			new File(servletContext.getRealPath("WEB-INF/classes/csv/")).mkdirs();
			csvFile.createNewFile();

			// read this file into InputStream
			fileUploadForm.getCsvFile().transferTo(new File(servletContext.getRealPath("WEB-INF/classes/csv/temp.csv")));


			System.out.println("********** File Creation Done!");

			// Now Parse CSV

			ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();

			String[] columns=null;
			if(fileUploadForm.getType().equals(Type.DEPARTMENT)){
				strat.setType(Department.class);
				columns = new String[] { "name", "discription"};
			}else{
				strat.setType(CSVProduct.class);
				columns = new String[] { "name", "description", "departments"};
			}			

			strat.setColumnMapping(columns);

			CsvToBean csv = new CsvToBean();


			URL url = AdminController.class.getResource("/csv/temp.csv");

			CSVReader reader = new CSVReader(new FileReader(url.getFile()));

			if(fileUploadForm.getType().equals(Type.DEPARTMENT)){
				List<Department> list = csv.parse(strat, reader);

				for (Department department : list) {
					if(repository.findDepartmentByName(department.getName())==null){
						dataStoreManager.save(department);
					}
				}
			}else{
				List<CSVProduct> products = csv.parse(strat, reader);
				
				for (CSVProduct csvProduct : products) {
					if(repository.findProductByName(csvProduct.getName())==null){
						Product product=new Product();
						product.setName(csvProduct.getName());
						product.setDescription(csvProduct.getDescription());
						
						String[] departments=csvProduct.getDepartments().split(" ");
						
						for (String string : departments) {
							Department department=repository.findDepartmentByName(string);
							if(department==null){
								department=repository.findDepartmentByName("ALL");
								if(department==null){
									department=new Department();
									department.setName("ALL");
									department.setDiscription("ALL PRODUCTS");
									dataStoreManager.save(department);
								}
							}
							product.addDepartment(department);
						}						
						dataStoreManager.save(product);
					}
				}
			}

		}catch(Exception exception){
			exception.printStackTrace();
		}
		List<Question> questions = repository.listAllQuestions();
		for (Question question2 : questions) {
			questionService.processQuestion(question2);
			System.out.println("Product found in controller ++++++++++++++++============="+question2.getProductFound());
			dataStoreManager.save(question2);
		}
		
		return new ModelAndView("redirect:/admin");
	}

}
