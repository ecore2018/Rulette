package com.kislay.rulette.gaia;

import com.kislay.rulette.metadata.RuleSystemMetaData;
import com.kislay.rulette.rule.Rule;
import com.kislay.rulette.ruleinput.RuleInputMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RuleMother {
    private static final Random randGen = new Random();

    public static List<Rule> getDefaultRules(int n, RuleSystemMetaData rsMetaData) throws Exception {
        if (n <= 0) {
            throw new Exception("0 or less dummy rule objects requested");
        }

        List<Rule> dummyObjs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = randGen.nextInt();

            Map<String, String> inputMap = new HashMap<>();
            for (RuleInputMetaData col : rsMetaData.getInputColumnList()) {
                inputMap.put(col.getName(), "inputValue" + id);
            }
            inputMap.put(rsMetaData.getUniqueIdColumnName(), String.valueOf(id));
            inputMap.put(rsMetaData.getUniqueOutputColumnName(), String.valueOf(id));

            dummyObjs.add(new Rule(rsMetaData.getRuleSystemName(), inputMap));
        }

        return dummyObjs;
    }
}