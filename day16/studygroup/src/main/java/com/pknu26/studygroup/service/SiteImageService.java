package com.pknu26.studygroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pknu26.studygroup.config.FileProperties;
import com.pknu26.studygroup.dto.SiteImage;
import com.pknu26.studygroup.mapper.SiteImageMapper;
import com.pknu26.studygroup.validation.SiteImageForm;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SiteImageService {
    private final SiteImageMapper siteImageMapper;
    private final FileProperties fileProperties;

    public List<SiteImage> getImageList() {
        return this.siteImageMapper.findAll();
    }

    public SiteImage getImage(Long id) {
        return this.siteImageMapper.findById(id);
    }

    public void create(SiteImageForm form) throws Exception {

    }
}
