package com.josuecamelo.estudo1;

import java.util.List;
import java.util.Optional;

//import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.josuecamelo.estudo1.entities.Task;
import com.josuecamelo.estudo1.entities.TaskRepository;


@Controller
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskController(TaskRepository repository) {
		this.taskRepository = repository;
	}
		
	@RequestMapping("/task/")
	@ResponseBody
	List<Task> home() {
		//return taskRepository.findAll();
		return taskRepository.findAllByOrderByName();
	}
	
	@RequestMapping(path = "task/{id}", method = RequestMethod.PUT)
    @ResponseBody
    Task update(@PathVariable Long id, String name) {
       Optional<Task> obj = taskRepository.findById(id);
       Task task = new Task();

       task.setId(obj.get().getId());
       task.setName(name);
       
       taskRepository.save(task);
       
       return task;
    }
	
	@RequestMapping(path = "task/{id}", method = RequestMethod.DELETE)
	void destroy(@PathVariable Long id) {
	    taskRepository.deleteAll();
	}

}
