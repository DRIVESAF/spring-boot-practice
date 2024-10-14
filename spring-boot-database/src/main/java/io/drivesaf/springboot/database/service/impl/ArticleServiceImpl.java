package io.drivesaf.springboot.database.service.impl;

import io.drivesaf.springboot.database.entity.Article;
import io.drivesaf.springboot.database.repository.ArticleRepository;
import io.drivesaf.springboot.database.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 14:29
 * @description:
 **/
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
