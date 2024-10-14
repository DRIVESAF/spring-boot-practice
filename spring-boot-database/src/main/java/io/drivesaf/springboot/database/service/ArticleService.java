package io.drivesaf.springboot.database.service;

import io.drivesaf.springboot.database.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 14:25
 * @description:
 **/

public interface ArticleService {
    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}
