package com.marjani.greatidea.controller.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marjani.greatidea.model.Idea;
import com.marjani.greatidea.model.Like;
import com.marjani.greatidea.model.User;
import com.marjani.greatidea.service.IdeaService;
import com.marjani.greatidea.service.LikeService;
import com.marjani.greatidea.service.UserService;
import com.marjani.greatidea.validator.IdeaValidator;
import com.marjani.greatidea.util.Utils;

@Controller
public class IdeaController {

	private final Logger logger = LogManager.getLogger(IdeaController.class);
	
	@Autowired
	private IdeaService ideaService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private IdeaValidator ideaValidator;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Utils utils;
	
    @GetMapping({"/", "/welcome"})
    public String ideas(Model model, HttpServletRequest request) {
        
    	List<Idea> ideas = this.ideaService.findAll();
    	this.logger.info("Ideas size " + ideas.size());
    	List<Map<String, Object>> ideaListMap = new ArrayList<Map<String,Object>>();
    	
        this.logger.info("user name "+ request.getUserPrincipal().getName());
        User user = this.userService.findByUsername(request.getUserPrincipal().getName());
    	
    	for(Idea idea: ideas) {
    		ideaListMap.add(this.utils.mergeIdeaLikes(idea, this.likeService.getByIdeaId(idea.getId()), user));
    	}    	
    	
    	model.addAttribute("ideas", ideaListMap);
    	
        return "welcome";
    }
    
    @GetMapping("/idea")
    public String idea(Model model) {
    	model.addAttribute("ideaForm", new Idea());
    	return "idea";
    }
    
    @PostMapping("/idea/create")
    public String createIdea(@ModelAttribute("ideaForm") Idea ideaForm, BindingResult bindingResult, HttpServletRequest request) {
        
    	this.ideaValidator.validate(ideaForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "idea";
        }

        // add current signed user on Idea
        this.logger.info("user name "+ request.getUserPrincipal().getName());
        ideaForm.setUser(this.userService.findByUsername(request.getUserPrincipal().getName()));
        
        this.ideaService.save(ideaForm);

        return "redirect:/welcome";
    }
    
    @GetMapping("/like")
    public String like(Model model, @RequestParam("ideaId") Long ideaId, HttpServletRequest request) {

    	this.logger.info(" ideaId " + ideaId);
    	
        this.logger.info("user name "+ request.getUserPrincipal().getName());
        User user = this.userService.findByUsername(request.getUserPrincipal().getName());
    	
    	Like like =  this.likeService.getByIdeaIdAndUserId(ideaId, user.getId());
    	
    	if(like != null) {
    		// like already present delete it
    		this.likeService.delete(like);
    	} else {
    		// create new like
    		Like newLike = new Like();
    		newLike.setUser(user);
    		newLike.setIdea(this.ideaService.findById(ideaId));
    		this.likeService.save(newLike);
    	}

        return "redirect:/welcome";
    }
    
    @GetMapping("/likes")
    public String likes(Model model, @RequestParam("ideaId") Long ideaId, HttpServletRequest request) {

    	this.logger.info(" ideaId " + ideaId);
    	
    	Map<String, Object> ideaMap = new HashMap<String,Object>();
    	Idea idea = this.ideaService.findById(ideaId);

        this.logger.info("user name "+ request.getUserPrincipal().getName());
        User user = this.userService.findByUsername(request.getUserPrincipal().getName());
    	
    	ideaMap = this.utils.mergeIdeaLikes(idea, this.likeService.getByIdeaId(ideaId), user);
    	
        if(idea.getUser().getId() == user.getId()) {
        	ideaMap.put("edit", true);
        } else {
        	ideaMap.put("edit", false);
        }
        
    	model.addAttribute("idea", ideaMap);

        return "likes";
    }
    
    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("ideaId") Long ideaId) {

    	this.logger.info(" ideaId " + ideaId);
    	
    	Map<String, Object> ideaMap = new HashMap<String,Object>();
    	Idea idea = this.ideaService.findById(ideaId);
    	
    	ideaMap = this.utils.getIdeaMap(idea);
        
    	model.addAttribute("idea", ideaMap);

        return "edit";
    }
    
    @GetMapping("/delete")
    public String delete(@RequestParam("ideaId") Long ideaId) {

    	Idea idea = this.ideaService.findById(ideaId);
    	// delete all likes first
    	List<Like> likes = this.likeService.getByIdeaId(ideaId);
    	for(Like like: likes) {
    		this.likeService.delete(like);
    	}
        this.ideaService.delete(idea);

        return "redirect:/welcome";
    }
    
    @GetMapping("/update")
    public String update(@RequestParam("ideaId") Long ideaId, @RequestParam("name") String name) {

    	Idea idea = this.ideaService.findById(ideaId);
    	idea.setName(name);
        this.ideaService.update(idea);

        return "redirect:/welcome";
    }
	
}
