package top.ccxh.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.ccxh.mapper.pojo.Accesskey;
import top.ccxh.service.AccessKeyService;
import top.ccxh.web.pojo.Result;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * accesskey 管理访问层
 * @author admin
 */
@RestController
@RequestMapping("accesskey")
public class NoAccessKeyController {

    @Autowired
    AccessKeyService accessKeyService;
    @RequestMapping("page/list")
    public String goList(){
        return "access/list";
    }

    /**
     *  登录接口
     * @param accessKey
     * @return
     */
    @RequestMapping("login")
    public Result logoIn(String accessKey, HttpServletResponse response){
        if(!StringUtils.isEmpty(accessKey)){
            Accesskey now = accessKeyService.selectByName(accessKey);
            if(now!=null){
                Cookie cookie = new Cookie("access",now.getId().toString());
                cookie.setPath("/");
                cookie.setMaxAge(Integer.MAX_VALUE );
                response.addCookie(cookie);
                return  Result.ok();
            }
        }
        return  Result.error();
    }
    @RequestMapping("name")
    public Result getName(Integer id){
        if (id!=null){
            Accesskey accesskey = accessKeyService.selectById(id);
            return Result.ok(accesskey);
        }
        return Result.error();
    }
}
