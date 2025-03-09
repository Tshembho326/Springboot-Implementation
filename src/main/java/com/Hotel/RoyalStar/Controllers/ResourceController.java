package com.Hotel.RoyalStar.Controllers;

import com.Hotel.RoyalStar.Services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Hotel.RoyalStar.Models.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/resources/")
public class ResourceController {
    public final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @PostMapping
    public void addResource(
            @RequestBody Resource resource
    ) {
        resourceService.addResource(resource);
    }

    @GetMapping("{resource_id}")
    public Resource getResource(
            @PathVariable("resource_id") Integer resourceId
    ) {
        return resourceService.getResource(resourceId);
    }

    @DeleteMapping("{resource_id}")
    public void deleteResource(
            @PathVariable("resource_id") Integer resourceId
    ) {
        resourceService.deleteResource(resourceId);
    }

    @PutMapping("{resource_id}")
    public void updateResource(
            @PathVariable("resource_id") Integer resourceId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String url
    ) {
        resourceService.updateResource(resourceId, name, size, url);
    }

}
