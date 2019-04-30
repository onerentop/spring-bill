package com.ren.springbill.controller;

import com.ren.springbill.dao.ProviderDao;
import com.ren.springbill.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: wangren.
 * @Description: TODO()
 * @Date:Created in 2019/4/28 17:14.
 * @Modified By:
 */

@Controller
public class ProviderController {


    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;

    @GetMapping("/providers")
    public String list(Map<String,Object> map,@RequestParam(value = "providerName",required = false) String providerName) {
        logger.info("查询供应商列表");
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers", providers);
        map.put("providerName", providerName);
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map) {
        logger.info("查询"+pid+"的供应商详细信息");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider", provider);
//        return "provider/view";
        return "provider/" + type;
    }

    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("更新供应商信息");
        providerDao.save(provider);

        return "redirect:providers";
    }

    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }

    @PostMapping("/provider")
    public String add(Provider provider) {
        logger.info("添加供应商数据"+ provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除操作,pid="+pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
