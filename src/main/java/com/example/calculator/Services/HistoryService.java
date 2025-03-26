package com.example.calculator.Services;

import com.example.calculator.model.CalculatorResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    private final List<CalculatorResponse> history= new ArrayList<>();
    public void addToHistory(CalculatorResponse res){
        history.add(res);
    }

    public List<CalculatorResponse> getCalculationHistory() {
        return history;
    }


    public String cleanHistory() {
        history.clear();
        return "History cleared successfully";
    }

    public String deleteHistoryById(Integer id) {
        for(CalculatorResponse res: history){
            Integer idName= res.getId();
            if(idName.equals(id)){
                history.remove(res);
                return "Id :"+idName+" deleted successfully";
            }
        }
        return "Id not found";
    }
}
