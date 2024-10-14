package io.drivesaf.springboot.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DRIVESAF
 * @createTime: 2024/10/12 16:41
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {
    private String sectionId;
    private String specialId;
    private String sectionTitle;
}
