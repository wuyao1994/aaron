package com.awesome.mvcAdvice;

import com.awesome.model.TableResponse;
import com.github.pagehelper.Page;
import com.google.common.collect.Maps;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.List;
import java.util.Map;

public class MyResponseBodyAdvice implements ResponseBodyAdvice{
    @Override
    public boolean supports(MethodParameter pMethodParameter, Class pClass) {
        return true;
    }



    @Override
    public Object beforeBodyWrite(Object pO, MethodParameter pMethodParameter, MediaType pMediaType, Class pClass,
            ServerHttpRequest pServerHttpRequest, ServerHttpResponse pServerHttpResponse) {
        if (pO instanceof Resource) {
            return pO;
        }
        if (pO == null) {
            return null;
        }
        if (pO instanceof Page) {
            Page page = (Page) pO;
            TableResponse<Page> result = new TableResponse<>();
            result.setList(page);
            result.setTotal(page.getTotal());
            return  result;
        }
        if (pO instanceof List || pO.getClass().isArray()) {
            Map<String, Object> result = Maps.newHashMap();
            result.put("array", pO);
        }
        return pO;
    }
}
