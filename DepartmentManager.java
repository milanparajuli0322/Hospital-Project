import java.util.ArrayList;
public class DepartmentManager {
    private final ArrayList<Department>departments;

    public DepartmentManager()
    {
        departments=new ArrayList<>();
    }

    public ArrayList<Department> getAllDepartments()
    {
        return new ArrayList<>(departments);
    }
}
