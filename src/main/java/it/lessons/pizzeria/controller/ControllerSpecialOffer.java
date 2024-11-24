package it.lessons.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import it.lessons.pizzeria.model.SpecialOffer;
import it.lessons.pizzeria.repository.SpecialOfferRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/specialoffer")
public class ControllerSpecialOffer {

    @Autowired
    private SpecialOfferRepository specialOfferRepo;

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("specialoffer") SpecialOffer specialOffer, BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            return "specialoffers/edit";
        }

        specialOfferRepo.save(specialOffer);

        return "redirect:/pizzeria/show/" + specialOffer.getPizza().getId();
    }

}