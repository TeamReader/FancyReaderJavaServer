package og_nl.sharpMark;

/**
 * Created by yyz on 2016/7/8.
 */
public class User {
    private String name,pwd;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public int getAge() {
        return age;
    }
}
