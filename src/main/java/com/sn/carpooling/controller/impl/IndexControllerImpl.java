package com.sn.carpooling.controller.impl;

import com.sn.carpooling.controller.IndexController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class IndexControllerImpl implements IndexController {
    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String welcome() {
        return "217";
    }
}
