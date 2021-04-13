package com.solutions.servermanager.dto;

import com.solutions.servermanager.models.Server;
import com.solutions.servermanager.models.VirtualMachine;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CalculateDto {

    @NotNull(message = "Required Server type not provided")
    private Server server;

    @NotEmpty(message = "Virtual machines can not be empty")
    private List<VirtualMachine> virtualMachines;

    public CalculateDto() {
    }


    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public List<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(List<VirtualMachine> virtualMachines) {
        this.virtualMachines = virtualMachines;
    }
}
