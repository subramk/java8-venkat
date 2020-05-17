package java8.com.trials;

/**
 * Created by Admin on 11/12/2019.
 */
public class Permission {

    private int id  ;
    private String permissionName ;


    public Permission(int id , String permissionName){
        this.id = id ;
        this.permissionName = permissionName;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}
