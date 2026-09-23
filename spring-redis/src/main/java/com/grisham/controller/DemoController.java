package com.grisham.controller;

import com.grisham.dto.DemoDto;
import com.grisham.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDemoMessage(@PathVariable("id") String id){
        DemoDto data = demoService.getDataInCache(id);
        return  ResponseEntity.ok(data);
    }

    @PostMapping
    public ResponseEntity<?> saveDemoMessage(@RequestBody DemoDto demoDto){
        demoService.saveDataInCache(demoDto);
        return ResponseEntity.ok("Demo Controller !!!");
    }
}
