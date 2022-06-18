package bht.salvinto.stickynotes.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("plain_note")
public class PlainNote extends Note {
}
