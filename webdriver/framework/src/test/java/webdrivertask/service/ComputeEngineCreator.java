package webdrivertask.service;

import webdrivertask.model.ComputeEngine;

public class ComputeEngineCreator {
    private static final String NUMBER_OF_INSTANCE = "testdataengine.computeengine.numberOfInstances";
    private static final String MACHINE_SERIES = "testdataengine.computeengine.machineSeries";
    private static final String MACHINE_TYPE = "testdataengine.computeengine.machineType";
    private static final String NUMBER_OF_GPU = "testdataengine.computeengine.numberOfGpu";
    private static final String GPU_TYPE = "testdataengine.computeengine.gpuType";
    private static final String LOCAL_SSD = "testdataengine.computeengine.localSsd";
    private static final String DATACENTER_LOCATION = "testdataengine.computeengine.datacenterLocation";
    private static final String COMMITTED_USAGE = "testdataengine.computeengine.committedUsage";

    public static ComputeEngine withCpuGpuAndSsd() {
        return new ComputeEngine(TestDataReader.getTestDataEngine(NUMBER_OF_INSTANCE),
                TestDataReader.getTestDataEngine(MACHINE_SERIES),
                TestDataReader.getTestDataEngine(MACHINE_TYPE),
                TestDataReader.getTestDataEngine(NUMBER_OF_GPU),
                TestDataReader.getTestDataEngine(GPU_TYPE),
                TestDataReader.getTestDataEngine(LOCAL_SSD),
                TestDataReader.getTestDataEngine(DATACENTER_LOCATION),
                TestDataReader.getTestDataEngine(COMMITTED_USAGE));
    }
}
