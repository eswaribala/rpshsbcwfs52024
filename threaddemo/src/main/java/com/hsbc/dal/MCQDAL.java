package com.hsbc.dal;

import com.hsbc.models.Question;

import java.io.IOException;

public interface MCQDAL {

    Question[] getQuestions() throws IOException;
}
