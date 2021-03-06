package com.marjani.greatidea.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.marjani.greatidea.model.Idea;
import com.marjani.greatidea.service.IdeaService;

@Component
public class IdeaValidator implements Validator {
	
    @Autowired
    private IdeaService ideaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Idea.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	
        Idea idea = (Idea) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
        if (idea.getName().length() < 6 || idea.getName().length() > 128) {
            errors.rejectValue("name", "Size.ideaForm.name");
        }
        if (ideaService.findByName(idea.getName()) != null) {
            errors.rejectValue("name", "Duplicate.ideaForm.name");
        }
        
    }
    
}
