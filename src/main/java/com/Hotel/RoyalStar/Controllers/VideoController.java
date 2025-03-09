package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Models.Video;
import com.Hotel.RoyalStar.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos/")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public List<Video> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("{video_id}")
    public Video getVideo(
            @PathVariable("video_id") Integer videoId
    ) {
        return videoService.getVideo(videoId);
    }

    @PostMapping
    public void addVideo(
            @RequestBody Video video
    ) {
        videoService.addVideo(video);
    }

    @DeleteMapping("{video_id}")
    public void deleteVideo(
            @PathVariable("video_id") Integer videoId
    ) {
        videoService.deleteVideo(videoId);
    }

    @PutMapping("{video_id}")
    public void updateVideo(
            @PathVariable("video_id") Integer videoId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String url,
            @RequestParam(required = false) Integer length
    ) {
        videoService.updateVideo(videoId, name, size, url, length);
    }
}

