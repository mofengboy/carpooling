package com.sn.carpooling.service;

import com.sn.carpooling.entity.MatchPool;
import com.sn.carpooling.entity.MatchUsers;
import com.sn.carpooling.entity.MatchVehicles;

public interface matchService {
    //添加待匹配拼车人员信息
    MatchPool addMatchUser(MatchUsers matchUsers);
    //添加待匹配车辆信息
    MatchPool addMatchVehicles(MatchVehicles matchVehicles);
    //触发性匹配机制
    boolean triggerMatch(MatchPool matchPool, MatchUsers matchUsers);
    boolean triggerMatch(MatchPool matchPool, MatchVehicles matchVehicles);
    //定时性匹配机制
    boolean timingMatch(MatchPool matchPool);
}
