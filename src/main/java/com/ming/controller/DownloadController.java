package com.ming.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("/{id}")
    private void download(@PathVariable("id") Long id){

    }
}
