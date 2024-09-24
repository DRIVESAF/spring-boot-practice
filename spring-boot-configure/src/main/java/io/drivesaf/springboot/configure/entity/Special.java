package io.drivesaf.springboot.configure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DRIVESAF
 * @createTime: 2024/09/23 22:06
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

