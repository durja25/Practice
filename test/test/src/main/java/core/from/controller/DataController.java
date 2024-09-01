package core.from.controller;
//
//import core.from.beans.Data;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class DataController {
//    @RequestMapping("/form")
//    public ModelAndView showform(){
//        return new ModelAndView("form","command",new Data());
//    }
//    @RequestMapping(value="/save",method = RequestMethod.POST)
//    public ModelAndView save(@ModelAttribute("emp") Data data){
//        //write code to save emp object
//        System.out.println(data.getBookingNo() +" "+data.getOfficeName());
//
//        //return new ModelAndView("empform","command",emp);
//        return new ModelAndView("redirect:/viewemp");
//    }
//
////    @RequestMapping("/viewemp")
////    public ModelAndView viewemp(){
////        //write the code to get all employees from DAO
////        //writing manual code for easy understanding
////        List<Data> list=new ArrayList<Emp>();
////        list.add(new Emp(1,"rahul",35000f,"S.Engineer"));
////        list.add(new Emp(2,"aditya",25000f,"IT Manager"));
////        list.add(new Emp(3,"sachin",55000f,"Care Taker"));
////
////        return new ModelAndView("viewemp","list",list);
////    }
//}
// Controller layer for Login Page
// Using Model


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// A simple controller using
// spring web annotations
@Controller
public class DataController {

    // returning the login jsp
    // for root of the webpage
    @GetMapping("/")
    public String home(){
        return "login.jsp";
    }

    // mapping the "/login" request
    // requestparam is used to get the value
    // from get request parameters
    @GetMapping("/login")
    public String loginActionUsingModel(
            @RequestParam("name") String name,
            @RequestParam("password") String pass, Model model
    ){

        // adding the attribute passed from request
        // to the model object
        model.addAttribute("userName", name);
        model.addAttribute("password", pass);

        // returning the view
        return "result.jsp";
    }
}

