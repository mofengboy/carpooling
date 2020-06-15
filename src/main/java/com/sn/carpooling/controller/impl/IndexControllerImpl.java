package com.sn.carpooling.controller.impl;

import com.sn.carpooling.common.GenericResponse;
import com.sn.carpooling.common.ServiceError;
import com.sn.carpooling.controller.IndexController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "",produces = "application/json; charset=utf-8")
public class IndexControllerImpl implements IndexController {
    @Override
    @RequestMapping(value = "", method = RequestMethod.GET)
    public GenericResponse welcome() {
        return GenericResponse.response(ServiceError.NORMAL, "217课程设计");
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public GenericResponse test() {
        return GenericResponse.response(ServiceError.NORMAL, "test");
    }
}
