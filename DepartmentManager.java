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

    public void addDepartment(Department department)
    {
        if (department == null)
        {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        for(Department existing:departments)
        {
            if(existing.getDepartmentId()==department.getDepartmentId())
            {
                throw new IllegalArgumentException("Department Id already exists");
            }
        }
        departments.add(department);
    }
}
