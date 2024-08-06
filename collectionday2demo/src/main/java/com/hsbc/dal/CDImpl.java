package com.hsbc.dal;

import com.hsbc.models.CD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CDImpl implements CDDAL{
        //, Comparator<CD> {
    private List<CD> cds;

    public CDImpl(){
        cds=new ArrayList<CD>();
    }

    @Override
    public void addCD(CD cd) {
        cds.add(cd);
    }

    @Override
    public List<CD> getSortedCds() {

     Comparator<CD> comparator=((o1, o2) -> {
         return o1.getSinger().compareTo(o2.getSinger());
     })  ;
      cds.sort(comparator);
      return cds;

    }

    /*
    @Override
    public int compare(CD o1, CD o2) {
        return o1.getSinger().compareTo(o2.getSinger());
    }

     */
}
