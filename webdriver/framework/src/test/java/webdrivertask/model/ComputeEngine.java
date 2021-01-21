package webdrivertask.model;

public class ComputeEngine {
    private String numberOfInstances;
    private String machineSeries;
    private String machineType;
    private String numberOfGpu;
    private String gpuType;
    private String localSsd;
    private String datacenterLocation;
    private String committedUsage;

    public ComputeEngine(String numberOfInstances, String machineSeries, String machineType, String numberOfGpu, String gpuType, String localSsd, String datacenterLocation, String committedUsage) {
        this.numberOfInstances = numberOfInstances;
        this.machineSeries = machineSeries;
        this.machineType = machineType;
        this.numberOfGpu = numberOfGpu;
        this.gpuType = gpuType;
        this.localSsd = localSsd;
        this.datacenterLocation = datacenterLocation;
        this.committedUsage = committedUsage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getMachineSeries() {
        return machineSeries;
    }

    public void setMachineSeries(String machineSeries) {
        this.machineSeries = machineSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getNumberOfGpu() {
        return numberOfGpu;
    }

    public void setNumberOfGpu(String numberOfGpu) {
        this.numberOfGpu = numberOfGpu;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getLocalSsd() {
        return localSsd;
    }

    public void setLocalSsd(String localSsd) {
        this.localSsd = localSsd;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    @Override
    public String toString() {
        return "ComputeEngine{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", machineSeries='" + machineSeries + '\'' +
                ", machineType='" + machineType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", localSsd='" + localSsd + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", committedUsage='" + committedUsage + '\'' +
                '}';
    }


}
