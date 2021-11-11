package com.hoangminh.entity;

import javax.persistence.*;

@Entity
@Table(name = "new")
public class NewEntity extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "shortdesc")
    private String shortDesc;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
