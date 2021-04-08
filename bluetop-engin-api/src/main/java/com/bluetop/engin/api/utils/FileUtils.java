/**
 * 文 件 名:  FileUtils
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  22:26
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.engin.api.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <文件工具类>
 *
 * @author zhouping
 * @version 1.0
 * @date 2021/4/4 22:26
 * @see [相关类/方法]
 * @since JDK 1.8
 */
public class FileUtils {

    /**
     * 将文件转成base64 字符串
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static String encodeBase64File(String path) {
        File file = new File(path);
        FileInputStream inputFile = null;
        byte[] buffer = null;
        try {
            inputFile = new FileInputStream(file);
            buffer = new byte[(int) file.length()];
            inputFile.read(buffer);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            try {
                inputFile.close();
            } catch (IOException e) {
                return StringUtils.EMPTY;
            }
        }
        return new BASE64Encoder().encode(buffer);
    }

    /**
     * 将Base64字符串转成文件
     *
     * @param base64Code
     * @param targetPath
     * @param catalogue
     * @throws Exception
     */
    public static void decoderBase64File(String base64Code, String targetPath, String catalogue) throws Exception {
        File file = new File(catalogue);
        if (file.exists() == false) {
            file.mkdirs();
        }
        byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
        FileOutputStream out = new FileOutputStream(targetPath);
        out.write(buffer);
        out.close();
    }
}
