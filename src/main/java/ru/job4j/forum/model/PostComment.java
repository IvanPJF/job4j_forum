package ru.job4j.forum.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class PostComment implements Comparable<PostComment> {

    private Integer id;
    private String desc;
    private Post post;
    private Calendar created = new GregorianCalendar();
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getCreated() {
        return created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostComment that = (PostComment) o;
        return Objects.equals(id, that.id)
                && Objects.equals(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc);
    }

    @Override
    public int compareTo(PostComment o) {
        return Long.compare(getCreated().getTimeInMillis(), o.getCreated().getTimeInMillis());
    }
}
