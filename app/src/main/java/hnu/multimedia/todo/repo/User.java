package hnu.multimedia.todo.repo;

public class User {
    private String id;
    private String nickName;
    private String email;

    public User() {
    }

    public User(String id, String nickName, String email) {
        this.id = id;
        this.nickName = nickName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }
}
