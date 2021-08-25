package codegym.controller;

import codegym.model.Classroom;
import codegym.model.Student;
import codegym.service.IClassroomService;
import codegym.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class StudentController {
    @Autowired
    IClassroomService iClassroomService;
    @Autowired
    IStudentService iStudentService;
@ModelAttribute
public ArrayList<Classroom> listClassroom(){
    return iClassroomService.findAll();
}
    @GetMapping("/show")
    public ModelAndView show(@PageableDefault(size = 2) Pageable pageable) {

        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("listStudent", iStudentService.findAllPage(pageable));
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView getCreate(){
        ModelAndView modelAndView=new ModelAndView("create");
        modelAndView.addObject("student",new Student());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView postCreate(@ModelAttribute Student student){
        iStudentService.save(student);
    ModelAndView modelAndView=new ModelAndView("redirect:/show");
    return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView getEdit(@RequestParam int id){
  ModelAndView modelAndView=new ModelAndView("edit");
  modelAndView.addObject("student",iStudentService.findById(id));
  return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView postEdit(@ModelAttribute Student student){
    ModelAndView modelAndView=new ModelAndView("redirect:/show");
    iStudentService.save(student);
    return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView getDelete(@RequestParam int id){
    ModelAndView modelAndView=new ModelAndView("redirect:/show");
    iStudentService.Delete(iStudentService.findById(id));
    return modelAndView;

    }
    @GetMapping("/findByName")
    public ModelAndView getFind(@RequestParam String findName){
        ModelAndView modelAndView=new ModelAndView("show");
        modelAndView.addObject("listStudent",iStudentService.findByName(findName));
        return modelAndView;
    }
}
