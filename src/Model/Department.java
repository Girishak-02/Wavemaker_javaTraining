package Model;

public class Department {
    public Integer DeptId;
    public String DeptName;

    public void Deparment(Integer deptId, String deptName) {
        this.DeptId = deptId;
        this.DeptName = deptName;
    }

    public Integer getDeptId() {
        return DeptId;
    }

    public void setDeptId(Integer deptId) {
        DeptId = deptId;
    }

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        this.DeptName = deptName;
    }

}
