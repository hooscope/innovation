package com.hooscope.innovation.service;

import com.hooscope.innovation.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: hao wu
 * @Date： 2023/7/21 22:31
 */
@Service
public class VideoService {
    private RestTemplate restTemplate;

    @Autowired
    public VideoService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // 从视频网站A获取视频信息的方法
    public Video getVideoInfoFromWebsiteA(String videoId) {
        // TODO: 调用视频网站A的API，获取视频信息
        // 使用restTemplate来进行HTTP请求
        // String apiUrl = "https://api.websiteA.com/videos/" + videoId;
        // ResponseEntity<Video> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Video.class);
        // return response.getBody();

        // 这里只是示例，实际需要替换为视频网站A的API调用代码
        return new Video(00001L, "Description A", "https://websiteA.com/videoA","https://websiteA.com/videoA");
    }

    // 将视频发布到视频网站B的方法
    public void publishVideoToWebsiteB(Video video) {
        // TODO: 调用视频网站B的API，将视频发布
        // 使用restTemplate来进行HTTP请求
        // String apiUrl = "https://api.websiteB.com/videos";
        // HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity<Video> requestEntity = new HttpEntity<>(video, headers);
        // restTemplate.postForObject(apiUrl, requestEntity, Void.class);

        // 这里只是示例，实际需要替换为视频网站B的API调用代码
        System.out.println("视频已发布到网站B：" + video.getTitle());
    }

    // 从TikTok获取视频信息的方法
    public Video getVideoInfoFromTikTok(String videoId, String apiKey) {
        String apiUrl = "https://api.tiktok.com/video/" + videoId + "?apiKey=" + apiKey;

        ResponseEntity<Video> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, Video.class);
        return response.getBody();
    }

    // 将视频发布到抖音的方法
    public void publishVideoToDouyin(Video video, String accessToken) {
        String apiUrl = "https://api.douyin.com/video/publish?accessToken=" + accessToken;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Video> requestEntity = new HttpEntity<>(video, headers);

        restTemplate.postForObject(apiUrl, requestEntity, Void.class);
    }
}

