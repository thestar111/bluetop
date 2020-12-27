/**
 * 文 件 名:  SwaggerConfiguration
 * 描    述:  <描述>
 * 修 改 人:  zhouping
 * 修改时间:  17:23
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.bluetop.swagger.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * <导入Swagger配置>
 *
 * @author zhouping
 * @version 1.0
 * @date 2020/12/26 17:23
 * @see [相关类/方法]
 * @since JDK 1.8
 */
@Configuration
@ConditionalOnProperty(name = "bluetop.swagger.enabled", matchIfMissing = true)
@Import({
        Swagger2DocumentationConfiguration.class
})
public class SwaggerConfiguration {
}
