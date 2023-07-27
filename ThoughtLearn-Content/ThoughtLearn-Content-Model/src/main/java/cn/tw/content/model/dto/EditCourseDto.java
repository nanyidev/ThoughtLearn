package cn.tw.content.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "EditCourseDto", description = "修改课程信息")
public class EditCourseDto extends AddCourseDto{
    @ApiModelProperty(value = "课程id")
    Long id;
}
