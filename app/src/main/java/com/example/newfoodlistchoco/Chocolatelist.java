package com.example.newfoodlistchoco;
import java.util.List;
import com.google.gson.annotations.Expose;


public class Chocolatelist {

    @Expose
    private Boolean success;
    @Expose
    private String message;
    @Expose
    private List<Prprice> prprice = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Prprice> getPrprice() {
        return prprice;
    }

    public void setPrprice(List<Prprice> prprice) {
        this.prprice = prprice;
    }

}

