package apiautomationpojo;

public class customerdetailpojo {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
    private Supportdetailpojo supportdetailpojo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    // If the nest json is there we need to create a Getter and setter for that object
    public Supportdetailpojo getSupportdetailpojo() {
        return supportdetailpojo;
    }

    public void setSupportdetailpojo(Supportdetailpojo supportdetailpojo){
        this.supportdetailpojo = supportdetailpojo;
    }
}
