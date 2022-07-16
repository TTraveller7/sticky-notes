package bht.salvinto.stickynotes.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Represents a basic note which contains a title, a description, and a creation timestamp.
 * @author ttraveller7
 */

@MappedSuperclass
public abstract class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // title of the note. should be non-empty.
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // records the time of creation
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("title", title)
                .append("description", description)
                .append("creationTimestamp", creationTimestamp)
                .toString();
    }
}
