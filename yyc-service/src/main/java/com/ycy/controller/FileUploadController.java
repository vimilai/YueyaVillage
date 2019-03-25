package com.ycy.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ycy.domain.Moment;
import com.ycy.domain.Plat;
import com.ycy.service.UploadFileServiceImpl;
import com.ycy.util.ResultMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "/", description = "图片上传服务")
public class FileUploadController {
	
	@Resource
	UploadFileServiceImpl uploadFileService;
	 /**
     * 文件上传具体实现方法（单文件上传）
     *
     * @param file
     * @return
     * 
     * @author 
     * @create 
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "单文件上传")
	@ApiResponses({ @ApiResponse(code = 200, message = "返回图片url") })
    public ResultMessage upload(@RequestParam("file") MultipartFile file) {
    	
	    try {
	    		String filePath = uploadFileService.getUploadFilePath(file);
				return ResultMessage.createSuccessMessage(filePath, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
    /**
     * 多文件上传 主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     * 
     * @author 单红宇(CSDN CATOOP)
     * @create 2017年3月11日
     */
    @RequestMapping(value = "/upload/batch", method = RequestMethod.POST)
    @ApiOperation(value = "多文件上传暂时不可用")
   	@ApiResponses({ @ApiResponse(code = 200, message = "返回图片url") })
    public  ResultMessage batchUpload(@RequestParam("file") List<MultipartFile> file) {
    	String filePath="";
	    try {
	    		for (MultipartFile multipartFile : file) {
	    			filePath += uploadFileService.getUploadFilePath(multipartFile);
				}
	    		
				return ResultMessage.createSuccessMessage(filePath, null);
		} catch (Exception e) {
			 return ResultMessage.createErrorsMessage(null, e.toString());
		}
    }
}
