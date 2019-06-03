package com.intuit.tier1.service;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import org.springframework.stereotype.Service;

@Service
public class MonkeyLearnService {

    public String sampleRun(String s){
        try {
            MonkeyLearn ml = new MonkeyLearn("139af24c72f5a347a3103b8c13fa9355a561828c");
            String modelId = "cl_5WyB9yiD";
            String[] data = new String[1];
            data[0] = s;
            MonkeyLearnResponse res = ml.classifiers.classify(modelId, data, true);
            return res.arrayResult.toJSONString();
        }catch (MonkeyLearnException e){
            return "";
        }
    }
}
