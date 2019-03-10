package com.test.beans;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PageBean {
    private String draw;
    private long recordsFiltered;
    private long recordsTotal;
   private List<EmployeeBean> data;
}
