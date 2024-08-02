package com.hsbc.views;

import com.hsbc.models.NameAnimator;

public class AnimatorApp {

    public static void main(String[] args){

        NameAnimator nameAnimator=new
                NameAnimator("Animation-Thread","Parameswari");
        nameAnimator.start();



    }
}
