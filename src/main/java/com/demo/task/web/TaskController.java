package com.demo.task.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.task.domain.Task;
import com.demo.task.service.TaskService;

@Controller
@RequestMapping(value="/tasks")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String taskHome(Model model) {
		model.addAttribute("tasks", taskService.listAllTasks());
		return "taskHome";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String createTask(Model model) {
		model.addAttribute("task", new Task());
		return "task";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String addTask(@Valid Task task, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "task";
		}
		taskService.addTask(task);
		return "redirect:/tasks";
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public String editTask(@PathVariable("id") Long taskId, Model model) {
		model.addAttribute("task", taskService.loadTaskById(taskId));
		return "task";
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.POST)
	public String updateTask(@Valid Task task, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "task";
		}
		taskService.updateTask(task);
		return "redirect:/tasks";
	}
	
	@RequestMapping(value="{id}/delete", method=RequestMethod.GET)
	public String deleteTask(@PathVariable("id") Long taskId ) {
		taskService.deleteTask(taskId);
		
		return "redirect:/tasks";
	}

}
