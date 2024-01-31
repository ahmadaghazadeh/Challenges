package com.sevensky.web.controllers;

import com.sevensky.web.models.CurrencyModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class TestController {

    private final List<CurrencyModel> currencies=new ArrayList<CurrencyModel>();

    @GetMapping("/currencies/{currencyId}")
    public ResponseEntity<CurrencyModel> getLastExchangeRate(@PathVariable("currencyId") int currencyId) {
        CurrencyModel result=currencies.stream().
                filter(currency -> currencyId==currency.getCurrencyId())
                .findFirst()
                .orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<CurrencyModel>> getCurrencies() {
        var newList=currencies.stream()
                .sorted(
                        Comparator.comparing(CurrencyModel::getCurrencyId)
                                .thenComparing(CurrencyModel::getRate)
                ).toList();

        return ResponseEntity.status(HttpStatus.OK).body(newList);
    }

    @GetMapping("/currencies/{currencyId}/best")
    public ResponseEntity<CurrencyModel> getBestRate(@PathVariable("currencyId") int currencyId) {
        var result=currencies.stream()
                .filter(currency -> currencyId==currency.getCurrencyId())
                .max(Comparator.comparing(CurrencyModel::getRate))
                .orElse(null);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/currencies")
    public ResponseEntity<Integer> saveCurrency(@ModelAttribute("currency") CurrencyModel model){
        currencies.add(model);
        return ResponseEntity.status(HttpStatus.OK).body(currencies.size());
    }

    @PutMapping("/currencies/{currencyId}")
    public ResponseEntity<String> updateCurrency(@PathVariable("currencyId") int currencyId,@ModelAttribute("currencyModel") CurrencyModel model){

        CurrencyModel result=currencies.stream().
                filter(currency -> currencyId==currency.getCurrencyId())
                .findFirst()
                .orElse(null);

        int index= currencies.indexOf(result);
        currencies.set(index,model);
        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

}

public class CurrencyModel{
    private int currencyId;
    private float rate;
    public CurrencyModel(int currencyId,float rate){
        this.currencyId=currencyId;
        this.rate=rate;
    }



    public void setCurrencyId(int currencyId){
        this.currencyId=currencyId;
    }

    public void setRate(float rate){
        this.rate=rate;
    }

    public int getCurrencyId(){
        return this.currencyId;
    }

    public float getRate(){
        return this.rate;
    }

}
