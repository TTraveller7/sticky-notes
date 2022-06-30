package bht.salvinto.stickynotes.domain;

import org.apache.commons.lang3.StringUtils;

public enum Category {
    WORK, SOCIALIZE, EXERCISE, MISC;

    public String capitalizedName() {
        return StringUtils.capitalize(this.name().toLowerCase());
    }
}
