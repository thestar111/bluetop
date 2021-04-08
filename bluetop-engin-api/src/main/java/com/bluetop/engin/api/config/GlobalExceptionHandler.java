/**
 * 文 件 名:  GlobalExceptionHandler
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  21:19
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.config;

import com.bluetop.engin.api.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.MethodNotAllowedException;

import javax.el.MethodNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <全局异常处理>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/20 21:19
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result<String> nullOrEmptyExceptionHandler(HttpServletRequest request, HttpServletResponse response, NullPointerException e) throws Exception {
        return handleErrorInfo(request, response, e);
    }

    /**
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseBody
    public Result<String> illegalPropExceptionHandler(HttpServletRequest request, HttpServletResponse response, MethodNotAllowedException e) throws Exception {
        return handleErrorInfo(request, response, e);
    }

    /**
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodNotFoundException.class)
    @ResponseBody
    public Result<String> illegalPropExceptionHandler(HttpServletRequest request, HttpServletResponse response, MethodNotFoundException e) throws Exception {
        return handleErrorInfo(request, response, e);
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public Result<String> mediaTypeNotSupported(HttpServletRequest request, HttpServletResponse response, HttpMediaTypeNotSupportedException e) {
        return handleErrorInfo(request, response, e);
    }

    /**
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result<String> getErrorMessage(HttpServletRequest request, HttpServletResponse response, HttpMessageNotReadableException e) {
        return handleErrorInfo(request, response, e);
    }

    /**
     *
     * @param request
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<String> exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        return handleErrorInfo(request, response, e);
    }

    /**
     * 处理错误信息
     *
     * @param request
     * @param e
     * @return
     */
    private Result<String> handleErrorInfo(HttpServletRequest request, HttpServletResponse response, Exception e) {
        StackTraceElement stack = e.getStackTrace()[0];
        log.error("\n*************** \n文件名称：{} \n类名：{} \n方法名：{} \n错误信息：{} \n出错行数：{} \n***************\n",
                stack.getFileName(),
                stack.getClassName(),
                stack.getMethodName(),
                ExceptionUtils.getRootCauseMessage(e),
                stack.getLineNumber());
        Result<String> result = new Result<>();
        result.setMsg(e.getMessage());
        result.setCode(500);
        return result;
    }
}
