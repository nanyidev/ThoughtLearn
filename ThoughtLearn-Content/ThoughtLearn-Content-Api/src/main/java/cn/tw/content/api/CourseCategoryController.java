package cn.tw.content.api;


import cn.tw.content.model.dto.CourseCategoryTreeDto;
import cn.tw.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CourseCategoryController {
    @Autowired
    CourseCategoryService courseCategoryService;

    @GetMapping("course-category/tree-nodes")
    public List<CourseCategoryTreeDto> treeNodes()
    {
        return courseCategoryService.selectTreeNodes("1");

    }
}
