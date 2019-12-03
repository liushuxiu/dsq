package com.uestc.miaoshi.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

@Data
public class Article {

    private String title;
    private String content;
    private String url;

    public Article(String title, String content, String url) {
        this.title = title;
        this.content = content;
        this.url = url;
    }
}