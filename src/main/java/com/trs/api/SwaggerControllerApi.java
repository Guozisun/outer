package com.trs.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Title:
 * Description:
 * Copyright: 2019 北京拓尔思信息技术股份有限公司 版权所有.保留所有权
 * Company:北京拓尔思信息技术股份有限公司(TRS)
 * Project: outer
 * Author: 赵元方
 * Create Time:2019/10/21 17:44
 */
@Api(tags = "测试swagger文档controller")
public interface SwaggerControllerApi {
    @ApiOperation("测试文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", dataType = "String", paramType = "query", required = true)
    })
    String testSwagger(String title, String name);

}
