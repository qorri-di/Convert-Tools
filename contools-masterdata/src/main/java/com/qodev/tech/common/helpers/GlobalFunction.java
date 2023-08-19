package com.qodev.tech.common.helpers;

import com.qodev.tech.domain.transaction.activityLog;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
@Transactional
public class GlobalFunction extends StringUtils{

    public void setActivity(activityLog req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ %s ]]-------------------- setActivity: START --------------------",req.getCreatedBy()));

        activityLog data = new activityLog();
        data.setActivityIp(genActivityId());
        data.setActivityFeature(req.getActivityFeature());
        data.setActivityIp(req.getActivityIp());
        data.setActivityMenu(req.getActivityMenu());
        data.setActivityPath(req.getActivityPath());
        data.setCreatedAt(req.getCreatedAt());
        data.setCreatedBy(req.getCreatedBy());

        data.persist();

        long stop = System.currentTimeMillis();
        System.out.println(String.format("[[ %s ]]-------------------- setActivity: END %s ms --------------------",req.getCreatedBy(),(stop - start)));
    }
}
