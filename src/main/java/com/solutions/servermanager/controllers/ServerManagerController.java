package com.solutions.servermanager.controllers;

import com.solutions.servermanager.dto.CalculateDto;
import com.solutions.servermanager.models.ResponseModel;
import com.solutions.servermanager.service.ServerManagerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/server")
public class ServerManagerController {

    private final ServerManagerService serverManagerService;

    public ServerManagerController(ServerManagerService serverManagerService) {
        this.serverManagerService = serverManagerService;
    }

    @PostMapping("/compute")
    public ResponseModel compute( @Validated  @RequestBody CalculateDto calculateDto ) {

        try {
            int serverCount =  serverManagerService.calculate( calculateDto.getServer(), calculateDto.getVirtualMachines());
            return new ResponseModel("Operation successful", serverCount);

        } catch (Exception e) {
            return new ResponseModel(e.getMessage());
        }
    }
}
