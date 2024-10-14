package io.drivesaf.springboot.database.service.impl;

import io.drivesaf.springboot.database.entity.Article;
import io.drivesaf.springboot.database.service.ArticleService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 14:33
 * @description:
 **/
@SpringBootTest
@Slf4j
class ArticleServiceImplTest {

    @Resource
    private ArticleService articleService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("SpringBoot")
                .author("张三")
                .content("SpringBoot入门到精通")
                .build();
        Article savedArticle = articleService.saveArticle(article);
        log.info(String.valueOf(savedArticle));
    }

    @Test
    void deleteArticle() {
        articleService.deleteArticle(7L);
    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(8L);
        article.setTitle("Springboot45343");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(8L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        var allArticles = articleService.getAll();
        assertFalse(allArticles.isEmpty(), "文章列表不应为空");
        log.info(String.valueOf(allArticles));
    }
}