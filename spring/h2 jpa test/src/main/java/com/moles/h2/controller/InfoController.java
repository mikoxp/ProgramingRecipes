package com.moles.h2.controller;

import com.moles.h2.entities.Info;
import com.moles.h2.repositories.InfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@AllArgsConstructor
@RestController
public class InfoController {

    private InfoRepository infoRepository;

    @RequestMapping("/info")
    public List<Info> info(){
        return infoRepository.findAll();
    }
}
