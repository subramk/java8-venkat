package java8.in.action;


public class Role {

    private Integer roleId ;
    private String roleName;


    Role(Integer roleId, String roleName){
        this.roleId = roleId ;
        this.roleName = roleName;

    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(final Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }
}
