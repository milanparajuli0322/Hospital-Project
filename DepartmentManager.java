import java.util.ArrayList;
import java.util.Comparator;
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

    public Department findDepartmentById(int departmentId)
    {
        if (departmentId <= 0)
        {
            throw new IllegalArgumentException(
                    "Department ID must be positive"
            );
        }

        for (Department department : departments)
        {
            if (department.getDepartmentId() == departmentId)
            {
                return department;
            }
        }

        return null;
    }

    public boolean removeDepartmentById(int departmentId)
    {
        if (departmentId <= 0)
        {
            throw new IllegalArgumentException( "Department ID must be positive");
        }

        Department department =findDepartmentById(departmentId);

        if (department == null)
        {
            return false;
        }

        departments.remove(department);
        return true;
    }

    public ArrayList<Department> searchDepartmentsByName(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException("Search name cannot be empty");
        }

        ArrayList<Department> results =new ArrayList<>();
        String search =name.trim().toLowerCase();

        for (Department department : departments)
        {
            if (department.getName()
                    .toLowerCase()
                    .contains(search))
            {
                results.add(department);
            }
        }
        return results;
    }

    public ArrayList<Department> sortDepartmentsByName()
    {
        ArrayList<Department> results = new ArrayList<>(departments);
        results.sort(Comparator.comparing(Department::getName,String.CASE_INSENSITIVE_ORDER));
        return results;
    }
}
