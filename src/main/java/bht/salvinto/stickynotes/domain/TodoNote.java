package bht.salvinto.stickynotes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class TodoNote extends Note {

    private Category category;

    private LocalDateTime deadline;

    private Status status;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("category", category)
                .append("deadline", deadline)
                .append("status", status)
                .toString();
    }
}
