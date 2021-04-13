package com.solutions.servermanager.services;


import com.solutions.servermanager.models.Server;
import com.solutions.servermanager.models.VirtualMachine;
import com.solutions.servermanager.service.ServerManagerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServerManagerServiceTest {

    @InjectMocks
    ServerManagerService serverManagerService;

    @Test
    public void calculateTest() throws Exception {

        Server server = new Server(2, 32, 100);
        List<VirtualMachine> machineList = new ArrayList<VirtualMachine>();
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(2, 32, 100));

        int response = serverManagerService.calculate(server, machineList);
        assertThat(response).isEqualTo(2);
    }


    @Test
    public void removeVirtualMachineIfTooBig() throws Exception {

        Server server = new Server(2, 32, 100);
        List<VirtualMachine> machineList = new ArrayList<VirtualMachine>();
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(1, 16, 10));
        machineList.add( new VirtualMachine(2, 32, 100));
        machineList.add( new VirtualMachine(4, 32, 100));

        int response = serverManagerService.calculate(server, machineList);
        assertThat(response).isEqualTo(2);
    }


}
