package com.intuit.tier1.service;

import com.monkeylearn.MonkeyLearn;
import com.monkeylearn.MonkeyLearnException;
import com.monkeylearn.MonkeyLearnResponse;
import org.springframework.stereotype.Service;

@Service
public class MonkeyLearnService {

    public String sampleRun(String s){
        try {
            MonkeyLearn ml = new MonkeyLearn("Enter the AppKey");
            String modelId = "Enter the Model Name";
            String[] data = new String[1];
            data[0] = s;
            MonkeyLearnResponse res = ml.classifiers.classify(modelId, data, true);
            return res.arrayResult.toJSONString();
        }catch (MonkeyLearnException e){
            return "";
        }
    }
}
