package com.intuit.tier1.service;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import org.springframework.stereotype.Service;

@Service
public class MonkeyLearnService {

    public String sampleRun(){
        try {
            MonkeyLearn ml = new MonkeyLearn("139af24c72f5a347a3103b8c13fa9355a561828c");
            String modelId = "cl_5WyB9yiD";
            String[] data = {"Our office needs help, we tried online but did not get any real answers.\n\nWe are updating our system for commission calculations and the company building the application stated that ...So in order for me to connect your QuickBooks environment to the application we are building you, QuickBooks needs a EULA and Data Policy from your team for legal reasons. Without those policy‚how do we get him the authorization to keep going with this project with quickbooks?"};
            MonkeyLearnResponse res = ml.classifiers.classify(modelId, data, true);
            return res.arrayResult.toJSONString();
        }catch (MonkeyLearnException e){
            return "";
        }
    }
}
