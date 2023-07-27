package cn.tw.content.service;

import cn.tw.base.model.PageParams;
import cn.tw.base.model.PageResult;
import cn.tw.content.model.dto.AddCourseDto;
import cn.tw.content.model.dto.CourseBaseInfoDto;
import cn.tw.content.model.dto.EditCourseDto;
import cn.tw.content.model.dto.QueryCourseParamsDto;
import cn.tw.content.model.po.CourseBase;

public interface CourseBaseInfoService {

    /**
     * 分页查询所有课程
     * @param pageParams 分页参数，包括当前页码和每页条目数
     * @param queryCourseParamsDto 查询条件dto类（封装了3个条件）
     * @return 查询结果，封装成PageResult<>类
     */
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /**
     * 添加课程
     * @param companyId 机构ID
     * @param addCourseDto 新增课程的参数
     * @return 课程详细信息（包含两张表）
     */
    CourseBaseInfoDto addCourse(Long companyId, AddCourseDto addCourseDto);

    /**
     * 根据id查询课程信息——用于修改
     * @param courseId 课程id
     * @return 课程完整信息回显
     */
    CourseBaseInfoDto getCourseBaseInfo(long courseId);

    /**
     * 修改课程信息
     * @param editCourseDto 修改课程提交的参数
     * @return 修改后返回的课程完整信息
     */
    CourseBaseInfoDto updateCourse(Long companyId, EditCourseDto editCourseDto);
}
