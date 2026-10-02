public class Department
{
    private final int departmentId;
    private String name;
    private String description;

    public Department(
            int departmentId,
            String name,
            String description)
    {
        if (departmentId <= 0)
        {
            throw new IllegalArgumentException(
                    "Department ID must be positive"
            );
        }

        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Department name cannot be empty"
            );
        }

        if (description == null || description.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Department description cannot be empty"
            );
        }

        this.departmentId = departmentId;
        this.name = name.trim();
        this.description = description.trim();
    }

    public int getDepartmentId()
    {
        return departmentId;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(String name)
    {
        if (name == null || name.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Department name cannot be empty"
            );
        }

        this.name = name.trim();
    }

    public void setDescription(String description)
    {
        if (description == null || description.trim().isEmpty())
        {
            throw new IllegalArgumentException(
                    "Department description cannot be empty"
            );
        }

        this.description = description.trim();
    }
}
