package entity;

public class Userinfo {
    private int id;
    private String username;
    private String email;
    private String password;
    private String headimg;
    private int status;

    public Userinfo(){

    }

    public Userinfo( String username, String email, String password, String headimg) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.headimg = headimg;
    }

    public Userinfo(int id, String username, String email, String password, String headimg, int status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.headimg = headimg;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", headimg='" + headimg + '\'' +
                ", status=" + status +
                '}';
    }

}
