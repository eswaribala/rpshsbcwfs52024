package com.hsbc.dal;

import com.hsbc.models.CD;

import java.util.List;

public interface CDDAL {

    void addCD(CD cd);
    List<CD> getSortedCds();


}
