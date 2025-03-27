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
       boolean bool= history.removeIf(res-> res.getId().equals(id));
        return bool ? "Id: "+id+" deleted successfully" : "Id not found";
    }
}
