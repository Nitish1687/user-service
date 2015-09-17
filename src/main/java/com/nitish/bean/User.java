package com.nitish.bean;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Data
@JsonRootName("User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private Integer userId;
    private String name;
    private String emailId;

}
