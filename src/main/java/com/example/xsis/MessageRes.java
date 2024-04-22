package com.example.xsis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageRes {
    
    private String message;
    
    public MessageRes(String message){
        this.message = message;
    }
}
