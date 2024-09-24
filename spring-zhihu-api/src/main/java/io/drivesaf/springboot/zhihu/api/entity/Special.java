package io.drivesaf.springboot.zhihu.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/14 15:00
 * @description:
 **/
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Special {
    private String id;
    private String title;
    private String banner;
    private String introduction;
    private String isFollowing;
    private Integer followersCount;
    private Integer viewCount;
    private String updated;
}
