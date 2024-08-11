package com.hui.tupian.controller;

import cn.hutool.core.util.RandomUtil;
import com.hui.tupian.entity.ScanObj;
import com.hui.tupian.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/scan")
public class ScanController {


    @GetMapping("doScan")
    public Result<?> doScan(String url) throws InterruptedException {
        List<String> str1 = Arrays.asList("/admin", "/login", "/testDo", "/getList", "/getUserInfo", "/takeSome", "/Go", "/down", "/up", "/stttt");
        List<String> str2 = Arrays.asList("/index", "/gofrm", "/jxjfi", "/yhfa", "/ojge", "/ooo", ";/qdads", "/tododdd", "/takokg", "/mkola");
        List<String> str3 = Arrays.asList("/guama", "/play", "/game", "/rufa", "/gutea", "/gkamgsdf", "/ijkfai", "/dnfuyhf", "/eufhyua", "/mnuhvbu");
        int maxCount = RandomUtil.randomInt(10, 21);
        List<ScanObj> scanList = new ArrayList<>();
        for (int i = 0; i < maxCount; i++) {
            ScanObj scan = new ScanObj();
            int times = RandomUtil.randomInt(1, 4);
            String scanUrl = url;
            switch (times) {
                case 1:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10));
                    break;
                case 2:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10)) + str2.get(RandomUtil.randomInt(0, 10));
                    break;
                case 3:
                    scanUrl += str1.get(RandomUtil.randomInt(0, 10)) + str2.get(RandomUtil.randomInt(0, 10)) + str3.get(RandomUtil.randomInt(0, 10));
                    break;
            }
            scan.setUrl(scanUrl);
            scan.setType(RandomUtil.randomInt(1, 6));
            scan.setLevel(RandomUtil.randomInt(0, 3));
            scanList.add(scan);
        }
        Thread.sleep(2000L);
        return Result.OK(scanList);
    }


}
