package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Video;
import com.Hotel.RoyalStar.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Video getVideo(Integer videoId) {
        return videoRepository.findById(videoId).orElseThrow(
                () -> new IllegalArgumentException("Video not found with ID: " + videoId)
        );
    }

    public void addVideo(Video video) {
        videoRepository.save(video);
    }

    public void deleteVideo(Integer videoId) {
        boolean validation = videoRepository.existsById(videoId);
        if (!validation) throw new IllegalArgumentException("Video not found with ID: " + videoId);
        videoRepository.deleteById(videoId);
    }

    public void updateVideo(Integer videoId, String name, Integer size, String url, Integer length) {
        Video video = videoRepository.findById(videoId).orElseThrow(
                () -> new IllegalArgumentException("Video not found with ID: " + videoId)
        );
        if (name != null) video.setName(name);
        if (size != null) video.setSize(size);
        if (url != null) video.setUrl(url);
        if (length != null) video.setLength(length);

        videoRepository.save(video);
    }
}
