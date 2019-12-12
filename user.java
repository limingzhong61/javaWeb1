public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String phone;
    private String address;
    public Integer getUser_id(){
        return this.user_id;
    }
    public void setUser_id(Integer user_id){
        this.user_id = user_id;
    }
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
}
