package io.drivesaf.springboot.database.repository;

import io.drivesaf.springboot.database.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/08 14:28
 * @description:
 **/
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
