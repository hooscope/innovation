package com.hooscope.innovation.controller;

import com.hooscope.innovation.entity.Video;
import com.hooscope.innovation.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hao wu
 * @Date： 2023/7/21 22:30
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/copy/{videoId}")
    public ResponseEntity<String> copyVideo(@PathVariable String videoId) {
        // 从视频网站A获取视频信息
        Video video = videoService.getVideoInfoFromWebsiteA(videoId);

        // 将视频发布到视频网站B
        videoService.publishVideoToWebsiteB(video);

        return ResponseEntity.ok("视频搬运成功");
    }
}
