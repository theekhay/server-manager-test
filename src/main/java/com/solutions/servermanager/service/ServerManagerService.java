package com.solutions.servermanager.service;

import com.solutions.servermanager.models.AbstractMachine;
import com.solutions.servermanager.models.Server;
import com.solutions.servermanager.models.VirtualMachine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerManagerService {

    public int calculate(Server server, List<VirtualMachine> virtualMachines) throws Exception {

        try{
            for( int i = 0; i < virtualMachines.size(); i++){

                VirtualMachine machine = virtualMachines.get(i);
                if( machine.getCpu() > server.getCpu() || machine.getHdd() > server.getHdd() || machine.getRam() > server.getRam()) {
                    virtualMachines.remove(machine);
                }
            }

            Server requiredServerCapacity = getRequiredServerInstance(virtualMachines);
            return computeRequiredServerInstances(requiredServerCapacity, server);

        } catch ( Exception ex){
            throw new Exception("An error occurred while performing this operation!");
        }

    }

    /**
     * compute the required combined resources of all the virtual instances
     * @param machine
     * @return
     */
    private Server getRequiredServerInstance(List<VirtualMachine> machine ){
        int cpuSum = machine.stream().mapToInt(AbstractMachine::getCpu).sum();
        int ramSum = machine.stream().mapToInt(AbstractMachine::getRam).sum();
        int hddSum = machine.stream().mapToInt(AbstractMachine::getHdd).sum();

        return new Server(cpuSum, ramSum, hddSum);
    }

    /**
     * find the requried number of servers per resource needed to host vms
     * @param instanceServer
     * @param server
     * @return
     */
    private int computeRequiredServerInstances( Server instanceServer, Server server ){

        int diff = 0;

        int cpuDiff= compareResource(instanceServer.getCpu(), server.getCpu());
        int hddDiff= compareResource(instanceServer.getHdd(), server.getHdd());
        int ramDiff= compareResource(instanceServer.getRam(), server.getRam());

        if(  cpuDiff > diff ) {
            diff = cpuDiff;
        }

        if( hddDiff > diff ) {
            diff = hddDiff;
        }

        if( ramDiff > diff ) {
            diff = ramDiff;
        }

        return diff;
    }

    /**
     * compare resources between machine instances
     * @param instanceAttr
     * @param serverAttr
     * @return
     */
    private int compareResource( int instanceAttr, int serverAttr ){
        float diff = (float)instanceAttr/serverAttr;
        return (int) Math.ceil(diff);
    }

}
