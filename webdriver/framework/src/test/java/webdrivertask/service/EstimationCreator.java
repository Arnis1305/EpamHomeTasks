package webdrivertask.service;

import webdrivertask.model.Estimation;

public class EstimationCreator {
    private static final String VM_CLASS = "testdata.estimation.vmClass";
    private static final String INSTANCE_TYPE = "testdata.estimation.instanceType";
    private static final String ESTIMATE_REGION = "testdata.estimation.estimateRegion";
    private static final String ESTIMATE_LOCAL_SSD = "testdata.estimation.estimateLocalSsd";
    private static final String COMMITMENT_TERM = "testdata.estimation.commitmentTerm";

    public static Estimation withCpuAndGpuFrankfurt() {
        return new Estimation(TestDataReader.getTestData(VM_CLASS),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(ESTIMATE_REGION),
                TestDataReader.getTestData(ESTIMATE_LOCAL_SSD),
                TestDataReader.getTestData(COMMITMENT_TERM));
    }

}
