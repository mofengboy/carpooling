package com.sn.carpooling.service.impl;

import com.sn.carpooling.entity.MatchPool;
import com.sn.carpooling.entity.MatchUsers;
import com.sn.carpooling.entity.MatchVehicles;
import com.sn.carpooling.service.matchService;
import org.springframework.beans.factory.annotation.Autowired;

public class matchServiceImpl implements matchService {
    @Autowired
    private IdentityCheck identityCheck;

    @Autowired
    private MatchPool matchPool;

    @Override
    public MatchPool addMatchUser(MatchUsers matchUsers) {
        // 用户审查
        if (!IdentityCheck.check(matchUsers)) {
            IdentityCheck.throwNoAuthrity();
        }
        // 触发性匹配机制
        if(!this.triggerMatch(matchPool,matchUsers)){
            // 加入匹配池
            matchPool.addMatchUser(matchUsers);
        }else{
            return null;
        }
    }

    @Override
    public MatchPool addMatchVehicles(MatchVehicles matchVehicles) {
        // 用户审查
        if (!IdentityCheck.check(matchVehicles)) {
            IdentityCheck.throwNoAuthrity();
        }
        // 触发性匹配机制
        if(!this.triggerMatch(matchPool,matchVehicles)){
            // 加入匹配池
            matchPool.addMatchUser(matchVehicles);
        }else{
            return null;
        }
    }

    @Override
    public boolean triggerMatch(MatchPool matchPool, MatchUsers matchUsers) {
        List<matchPool> ruleItemList = matchPool.getRuleItems();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ruleItemList.size(); i++) {
            MatchPool item = ruleItemList.get(i);
            if (MatchPool.leftParenthesesIndex.contains(i)) {
                sb.append("(");
            }

            String listKey = "list" + i;
            String valueKey = "item" + i;

            String subExpress = compute(item, listKey, valueKey);
            sb.append(subExpress);

            String leftValue = item.getLeft();
            if (leftValue.startsWith("{") && leftValue.endsWith("}")) {
                leftValue = userFeature.get(leftValue.substring(1, leftValue.length() - 1));
            }

            String rightValue = item.getRight();
            if (rightValue.startsWith("{") && rightValue.endsWith("}")) {
                rightValue = userFeature.get(rightValue.substring(1, rightValue.length() - 1));
            }

            if (matchUsers.isDecimalCompareLogicalOpration(item.matchUsers)) {
                ctx.setVariable(listKey, Integer.parseInt(rightValue));
                ctx.setVariable(valueKey, Integer.parseInt(leftValue));
            } else if (matchUsers.isEqualLogicalOpration(item.matchUsers)) {
                ctx.setVariable(listKey, rightValue);
                ctx.setVariable(valueKey, leftValue);
            } else {
                ctx.setVariable(listKey, Arrays.asList(rightValue.split(",")));
                ctx.setVariable(valueKey, leftValue);
            }

            if (model.rightParenthesesIndex.contains(i)) {
                sb.append(")");
            }

            if (item.matchUsers.ordinal() != LogicalOpration.None.ordinal()) {
                sb.append(matchUsers.toStr(item.getLogicalOpra()));
            }
        }

        return new SpelResult(sb.toString(), ctx);
    }

    @Override
    public boolean triggerMatch(MatchPool matchPool, MatchVehicles matchVehicles) {
        List<matchPool> ruleItemList = matchPool.getRuleItems();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ruleItemList.size(); i++) {
            MatchPool item = ruleItemList.get(i);
            if (MatchPool.leftParenthesesIndex.contains(i)) {
                sb.append("(");
            }

            String listKey = "list" + i;
            String valueKey = "item" + i;

            String subExpress = compute(item, listKey, valueKey);
            sb.append(subExpress);

            String leftValue = item.getLeft();
            if (leftValue.startsWith("{") && leftValue.endsWith("}")) {
                leftValue = userFeature.get(leftValue.substring(1, leftValue.length() - 1));
            }

            String rightValue = item.getRight();
            if (rightValue.startsWith("{") && rightValue.endsWith("}")) {
                rightValue = userFeature.get(rightValue.substring(1, rightValue.length() - 1));
            }

            if (matchVehicles.isDecimalCompareLogicalOpration(item.comparelOpration)) {
                ctx.setVariable(listKey, Integer.parseInt(rightValue));
                ctx.setVariable(valueKey, Integer.parseInt(leftValue));
            } else if (matchVehicles.isEqualLogicalOpration(item.comparelOpration)) {
                ctx.setVariable(listKey, rightValue);
                ctx.setVariable(valueKey, leftValue);
            } else {
                ctx.setVariable(listKey, Arrays.asList(rightValue.split(",")));
                ctx.setVariable(valueKey, leftValue);
            }

            if (model.rightParenthesesIndex.contains(i)) {
                sb.append(")");
            }

            if (item.logicalOpra.ordinal() != matchVehicles.None.ordinal()) {
                sb.append(matchVehicles.toStr(item.getLogicalOpra()));
            }
        }

        return new SpelResult(sb.toString(), ctx);
    }

    @Override
    public boolean timingMatch(MatchPool matchPool) {
        MatchUsers users = new MatchUsers();
        return triggerMatch(matchPool,users);
    }
}
