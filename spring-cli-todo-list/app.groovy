package com.jahnelgroup

@Grab('spring-boot-starter-thymeleaf')
@Grab('spring-boot-starter-data-jpa')
@Grab('h2')

import javax.persistence.*
import javax.servlet.http.HttpServletRequest

@Controller
public class App {

	@Autowired TodoRepo todoRepo
	@ModelAttribute TodoRepo todoRepo(){ return todoRepo }

	@GetMapping("/") 
	String index(){ return "index" }

	@RequestMapping(value = "/save", method = [RequestMethod.GET, RequestMethod.POST])
	String save(Model model, HttpServletRequest req, @ModelAttribute Todo todo){ 
		if( req.getMethod() == "POST" ){
			todoRepo.save(todo)
			return "index"
		}
		model.addAttribute("todo", new Todo())
		return "create"; 
	}

	@GetMapping("/delete") 
	String delete(Integer id){ 
		todoRepo.deleteById(id)
		return "index" 
	}

	@GetMapping("/detail") 
	String detail(Model model, Integer id){ 
		model.addAttribute("todo", todoRepo.deleteById(id))
		return "detail" 
	}

	@GetMapping("/edit") 
	String edit(Model model, Integer id){ 
		model.addAttribute("todo", todoRepo.findById(id).get())
		return "edit" 
	}	

} 

@Entity class Todo {
		@Id
		@GeneratedValue
		Integer id = null
		String todoTitle = null
		String todoDescription = null
		@org.hibernate.annotations.CreationTimestamp
		Date date = new Date()
}

interface TodoRepo extends org.springframework.data.repository.CrudRepository<Todo, Integer>{}