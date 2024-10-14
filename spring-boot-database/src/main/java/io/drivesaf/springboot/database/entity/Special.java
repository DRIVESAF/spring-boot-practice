package io.drivesaf.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 16:36
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Special {
    private String id;
    private String title;
    private String introduction;
    private String banner;
    private Integer viewCount;
    private Integer followerCounter;
    private Boolean isFollowing;
    private Long update;
    private List<Section> sections;
}
