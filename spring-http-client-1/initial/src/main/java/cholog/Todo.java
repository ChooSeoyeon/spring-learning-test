package cholog;

public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;

    protected Todo() {
    }

    public Todo(Long userId, Long id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Todo(Long id) {
        this(null, id, null, null);
    }

    public Long getUserId() {
        return userId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
