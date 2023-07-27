package cn.tw.media.api;


import cn.tw.base.model.PageParams;
import cn.tw.base.model.PageResult;
import cn.tw.media.model.dto.QueryMediaParamsDto;
import cn.tw.media.model.dto.UploadFileParamsDto;
import cn.tw.media.model.dto.UploadFileResultDto;
import cn.tw.media.model.po.MediaFiles;
import cn.tw.media.service.MediaFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description 媒资文件管理接口
 * @author Mr.M
 * @date 2022/9/6 11:29
 * @version 1.0
 */
 @Api(value = "媒资文件管理接口",tags = "媒资文件管理接口")
 @RestController
public class MediaFilesController {


  @Autowired
  MediaFileService mediaFileService;


 @ApiOperation("媒资列表查询接口")
 @PostMapping("/files")
 public PageResult<MediaFiles> list(PageParams pageParams, @RequestBody QueryMediaParamsDto queryMediaParamsDto){
  Long companyId = 1232141425L;
  return mediaFileService.queryMediaFiels(companyId,pageParams,queryMediaParamsDto);

 }

 @ApiOperation("上传图片")
 @RequestMapping(value = "/upload/coursefile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
public UploadFileResultDto upload(@RequestPart("filedata")MultipartFile filedata,
                                  @RequestParam(value= "objectName",required=false) String objectName) throws IOException {

    //准备上传文件的信息
     UploadFileParamsDto uploadFileParamsDto = new UploadFileParamsDto();
     //原始文件名称
     uploadFileParamsDto.setFilename(filedata.getOriginalFilename());
     //文件大小
     uploadFileParamsDto.setFileSize(filedata.getSize());
     //文件类型
     uploadFileParamsDto.setFileType("001001");
     //创建一个临时文件
     File tempFile = File.createTempFile("minio", ".temp");
     filedata.transferTo(tempFile);
     Long companyId = 1232141425L;
    //文件路径
     String localFilePath = tempFile.getAbsolutePath();

     //调用service上传图片
     UploadFileResultDto uploadFileResultDto = mediaFileService.uploadFile(companyId, uploadFileParamsDto, localFilePath,objectName);

     return uploadFileResultDto;
 }

}
