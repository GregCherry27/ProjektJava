package model;

public class Surface {

    private String name;
    private String comments;

    public Surface(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public Surface(){
        this.name = "";
        this.comments = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
