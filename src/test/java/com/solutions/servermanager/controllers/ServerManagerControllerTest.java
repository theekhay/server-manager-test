package com.solutions.servermanager.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.solutions.servermanager.dto.CalculateDto;
import com.solutions.servermanager.models.Server;
import com.solutions.servermanager.models.VirtualMachine;
import com.solutions.servermanager.service.ServerManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration()
@WebMvcTest(ServerManagerController.class)
public class ServerManagerControllerTest {

    @MockBean
    ServerManagerService serverManagerService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void calculateTest() throws Exception {

        List<VirtualMachine> machineList = new ArrayList<VirtualMachine>();
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(2, 32, 100));

        CalculateDto calculateDto = new CalculateDto();
        calculateDto.setServer( new Server(2, 32, 100));
        calculateDto.setVirtualMachines(machineList);

        Mockito.when( serverManagerService.calculate( calculateDto.getServer(), calculateDto.getVirtualMachines())).thenReturn( 2);

        mockMvc.perform( post("/server/compute")
                .content( asJsonString( calculateDto ) )
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect( status().isOk() );
    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
