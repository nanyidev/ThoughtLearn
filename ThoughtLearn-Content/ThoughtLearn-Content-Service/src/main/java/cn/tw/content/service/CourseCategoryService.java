package cn.tw.content.service;



import cn.tw.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

public interface CourseCategoryService {
    /**
     *
     * @return
     */
    List<CourseCategoryTreeDto> selectTreeNodes(String id);
}
