package bht.salvinto.stickynotes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

/**
 * Represents a basic note which contains a title, a description, and a creation timestamp.
 * @author ttraveller7
 */
public class Note {

    // title of the note. should be non-empty.
    private String title;

    private String description;

    // records the time of creation
    private LocalDateTime creationTimestamp;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("title", getTitle())
                .append("description", getDescription())
                .append("creationTimestamp", getCreationTimestamp())
                .toString();
    }
}
