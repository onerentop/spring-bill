package com.ren.springbill.controller;

import com.ren.springbill.dao.ProviderDao;
import com.ren.springbill.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "provider/list";
    }
}
