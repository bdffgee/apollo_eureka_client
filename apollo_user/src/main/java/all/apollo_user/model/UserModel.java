package all.apollo_user.model;

/**
 * className UserModel
 *
 * @author 电脑
 * @date 2021/7/29 12:42
 */
public class UserModel {
    private Integer uid;
    private Integer uAge;
    private String uName;

    public UserModel() {
    }

    public UserModel(Integer uid, Integer uAge, String uName) {
        this.uid = uid;
        this.uAge = uAge;
        this.uName = uName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid=" + uid +
                ", uAge=" + uAge +
                ", uName='" + uName + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getuAge() {
        return uAge;
    }

    public void setuAge(Integer uAge) {
        this.uAge = uAge;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
}
