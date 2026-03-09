package com.view;

import com.DAO.impl.TopicsDaoImpl;
import com.DAO.impl.EntriesDaoImpl;
import com.Service.LearningLogService;
import com.model.Topic;
import com.model.Entry;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LearningLogService service = new LearningLogService();
        service.start();

    }

}