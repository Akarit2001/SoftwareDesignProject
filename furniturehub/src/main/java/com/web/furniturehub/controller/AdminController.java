package com.web.furniturehub.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.web.furniturehub.model.Furniture;

import com.web.furniturehub.service.FileUploadUtil;
import com.web.furniturehub.service.FurnitureRepository;


@Controller
public class AdminController {
    @Autowired
    private FurnitureRepository repo;

    @PostMapping("/admin/save")
    public RedirectView saveUser(Furniture furniture,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        furniture.setImage(fileName);

        Furniture savedFurniture = repo.save(furniture);

        String uploadDir = "photos/" + savedFurniture.getFur_id();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/admin", true);
    }
}
