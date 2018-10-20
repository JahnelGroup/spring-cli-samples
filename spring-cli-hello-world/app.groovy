@Controller
@Grab('spring-boot-starter-thymeleaf')
class MessageController {

   @RequestMapping("/thymeleaf")   
   String getMessageThymeleaf(Model model) {
      String message = "Hello, World.";
      model.addAttribute("message", message);
      return "thymeleaf";
   }

   @RequestMapping("/rest")
   @ResponseBody String getMessageRest() {
      return "From rest: Hello, World.";
   }

} 
