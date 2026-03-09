package com.DAO;

import com.model.Topic;

import java.util.List;

public interface TopicsDAO {

    Topic addTopic(Topic topic);
    Topic getTopic(int id);
    List<Topic> getAllTopics();
    boolean updateTopic(Topic topic);
}
