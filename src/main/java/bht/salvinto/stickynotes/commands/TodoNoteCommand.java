package bht.salvinto.stickynotes.commands;

import bht.salvinto.stickynotes.domain.Category;
import bht.salvinto.stickynotes.domain.Status;

import java.time.LocalDateTime;

public class TodoNoteCommand {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationTimestamp;
    private Category category;
    private LocalDateTime deadline;
    private Status status;

    public TodoNoteCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
