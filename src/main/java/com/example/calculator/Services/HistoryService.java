package com.example.calculator.Services;

import com.example.calculator.Repository.HistoryRepository;
import com.example.calculator.model.CalculatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryService {
    private final List<CalculatorResponse> history= new ArrayList<>();

    private HistoryRepository historyrepos; // field injection or else go with constructor injection

    @Autowired
    public HistoryService(HistoryRepository repos){
        historyrepos=repos;
    }
    public void addToHistory(CalculatorResponse res){
        history.add(res);
        historyrepos.save(res);
    }

    public List<CalculatorResponse> getCalculationHistory() {
        return history;
    }

    public String cleanHistory() {
        history.clear();
        return "History cleared successfully from List";
    }

    public String deleteHistoryById(Integer id) {
       boolean bool= history.removeIf(res-> res.getId().equals(id));
        return bool ? "Id: "+id+" deleted successfully from List" : "Id not found";
    }

    public String clearHistoryFromH2DB(){
        historyrepos.deleteAll();
        return "History from DB is cleared successfully";
    }

    public List<CalculatorResponse> getCalculationHistoryfromH2DB(){
        return historyrepos.findAll();
    }

    public String deleteHistoryByIdfromH2DB(Integer id){
        boolean bool=historyrepos.findById(id).isPresent();
        historyrepos.deleteById(id);
        return bool?"Id: "+id+" deleted from H2 DB": "Id not found";
    }
}
