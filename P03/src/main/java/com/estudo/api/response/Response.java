package com.estudo.api.response;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Response<T> {

    private T data;
    private List<String> errors;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors(){
        if (this.errors.equals(null)){
            this.errors = new ArrayList<String>();
        }
        return errors;
    }
}
