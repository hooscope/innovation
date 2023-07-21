package com.hooscope.innovation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: hao wu
 * @Date： 2023/7/21 22:32
 */
@Data
@AllArgsConstructor
public class Video {

    private Long id;

    private String title;
    private String description;
    private String url;
}

