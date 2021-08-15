package com.test.test.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {

    private int id;
    private String title;
    private String content;
    private Date date;
}
