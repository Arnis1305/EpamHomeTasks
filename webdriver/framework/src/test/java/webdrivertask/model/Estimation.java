package webdrivertask.model;

import java.util.Objects;

public class Estimation {
    private String vmClass;
    private String instanceType;
    private String estimateRegion;
    private String estimateLocalSsd;
    private String commitmentTerm;

    public Estimation(String vmClass, String instanceType, String estimateRegion, String estimateLocalSsd, String commitmentTerm) {
        this.vmClass = vmClass;
        this.instanceType = instanceType;
        this.estimateRegion = estimateRegion;
        this.estimateLocalSsd = estimateLocalSsd;
        this.commitmentTerm = commitmentTerm;
    }

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getEstimateRegion() {
        return estimateRegion;
    }

    public void setEstimateRegion(String estimateRegion) {
        this.estimateRegion = estimateRegion;
    }

    public String getEstimateLocalSsd() {
        return estimateLocalSsd;
    }

    public void setEstimateLocalSsd(String estimateLocalSsd) {
        this.estimateLocalSsd = estimateLocalSsd;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    @Override
    public String toString() {
        return "Estimation{" +
                "vmClass='" + vmClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", estimateRegion='" + estimateRegion + '\'' +
                ", estimateLocalSsd='" + estimateLocalSsd + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estimation that = (Estimation) o;
        return Objects.equals(vmClass, that.vmClass) &&
                Objects.equals(instanceType, that.instanceType) &&
                Objects.equals(estimateRegion, that.estimateRegion) &&
                Objects.equals(estimateLocalSsd, that.estimateLocalSsd) &&
                Objects.equals(commitmentTerm, that.commitmentTerm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vmClass, instanceType, estimateRegion, estimateLocalSsd, commitmentTerm);
    }
}
