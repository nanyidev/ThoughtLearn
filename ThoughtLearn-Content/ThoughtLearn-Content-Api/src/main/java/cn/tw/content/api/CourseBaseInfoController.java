package cn.tw.content.api;


import cn.tw.base.model.PageParams;
import cn.tw.base.model.PageResult;
import cn.tw.content.model.dto.AddCourseDto;
import cn.tw.content.model.dto.CourseBaseInfoDto;
import cn.tw.content.model.dto.EditCourseDto;
import cn.tw.content.model.dto.QueryCourseParamsDto;
import cn.tw.content.model.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import cn.tw.content.service.CourseBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 课程信息编辑接口，包含5个接口
 * 1.课程查询 2.课程新增 3.课程修改
 */
@RestController
@Api("课程增删改查接口")
public class CourseBaseInfoController {

    @Autowired
    private CourseBaseInfoService courseBaseService;

//    @value：测试value
//    @Value("${lesson}")
//    private String lesson;
//    @Value("${abc.def}")
//    private Integer port;
//    @Value("${enterprise.subject[0]}")
//    private String subject_00;
//
//    @GetMapping("/{id}")
//    public String getById(@PathVariable Integer id){
//        System.out.println(lesson);
//        System.out.println(port);
//        System.out.println(subject_00);
//        return "hello , spring boot!";
//    }


    @ApiOperation("k12课程查询接口")
    //@PreAuthorize("hasAuthority('teach_manage')")
    @PostMapping("/course/list")   // @RequestMapping("/course/list")
    // json数据传入，使用@RequestBody注解将json转成QueryCourseParamsDto对象
    public PageResult<CourseBase> listCourse(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParamsDto)
    {
        return courseBaseService.queryCourseBaseList(pageParams,queryCourseParamsDto);
    }

    @ApiOperation("新增k12课程信息")
    @PostMapping("/course")
    public CourseBaseInfoDto addCourse(@RequestBody AddCourseDto addCourseDto)
    {
        Long companyId= 12345L;
        return courseBaseService.addCourse(companyId,addCourseDto);
    }

    @ApiOperation("根据课程id查询k12课程信息")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto selectById(@PathVariable Long courseId)
    {
        return courseBaseService.getCourseBaseInfo(courseId);
    }

    @PutMapping("/course")
    public CourseBaseInfoDto updateCourse(@RequestBody @Validated EditCourseDto editCourseDto)
    {
        Long companyId=1232141425L;
        return courseBaseService.updateCourse(companyId, editCourseDto);

    }
}
