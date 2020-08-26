package ru.job4j.forum.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "post")
@NamedEntityGraph(
        name = Post.POST_ALL_FIELDS,
        attributeNodes = {
                @NamedAttributeNode("user"),
                @NamedAttributeNode("comments")
        }
)
public class Post {

    public static final String POST_ALL_FIELDS = "post.all.fields";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String desc;
    @Column(name = "created")
    private Calendar created = new GregorianCalendar();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("created")
    private Set<PostComment> comments = new TreeSet<>();

    public static Post of(String name, String desc, User user) {
        Post post = new Post();
        post.name = name;
        post.desc = desc;
        post.user = user;
        return post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Set<PostComment> getComments() {
        return comments;
    }

    public void setComments(Set<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id)
                && Objects.equals(name, post.name)
                && Objects.equals(desc, post.desc)
                && Objects.equals(created, post.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created);
    }
}
