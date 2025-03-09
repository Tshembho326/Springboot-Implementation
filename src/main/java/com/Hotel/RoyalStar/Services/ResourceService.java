package com.Hotel.RoyalStar.Services;

import com.Hotel.RoyalStar.Models.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotel.RoyalStar.Repositories.ResourceRepository;
import java.util.List;

@Service
public class ResourceService {

    public final ResourceRepository resourceRepository;

    @Autowired
    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }


    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public void addResource(Resource resource) {
        resourceRepository.save(resource);
    }

    public Resource getResource(Integer resourceId) {
        return resourceRepository.findById(resourceId)
                .orElseThrow(() -> new IllegalArgumentException("The resource you're looking for is unavailable"));
    }

    public void deleteResource(Integer resourceId) {
        boolean valid = resourceRepository.existsById(resourceId);
        if (!valid) throw new IllegalArgumentException("The resource you are trying to delete is invalid");
        resourceRepository.deleteById(resourceId);
    }

    public void updateResource(Integer resourceId, String name, Integer size, String url) {
        Resource resource = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new IllegalArgumentException("Resource invalid"));
        if (name != null) resource.setName(name);
        if (size != null) resource.setSize(size);
        if (url != null) resource.setUrl(url);
    }
}
