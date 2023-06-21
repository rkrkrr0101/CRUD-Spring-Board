package com.board.board.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result<T> {
    private T data;


    public Result(T data) {
        this.data = data;
    }
}
