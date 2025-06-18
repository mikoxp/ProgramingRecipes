package com.moles.rest;

import com.moles.elastic.info.Info;
import com.moles.elastic.info.InfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController {

    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping
    public List<Info> getAll(){
        return infoService.getAll();
    }

    @PostMapping
    public Info add(@RequestBody Info info) {
        return infoService.add(info);
    }

}