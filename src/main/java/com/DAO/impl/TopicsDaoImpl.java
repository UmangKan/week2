package com.DAO.impl;

import com.DAO.TopicsDAO;
import com.model.Topic;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
public class TopicsDaoImpl implements TopicsDAO {

    Scanner scan = new Scanner(System.in);
    private Map<Integer, Topic> topics = new HashMap<>();
    private List<Topic> topicList;

    private int idCounter=1;



    @Override
    public Topic addTopic(Topic topic) {
        if (topic == null || topic.getName() == null || topic.getName().trim().isEmpty()) {
            System.out.println("Error: Topic name cannot be empty");
            return null;
        }

        topic.setId(idCounter++);
        topic.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        topic.setUpdatedAt(topic.getCreatedAt());

        topics.put(topic.getId(), topic);
        return topic;
    }

    @Override
    public Topic getTopic(int id) {
        return topics.get(id);
    }

    @Override
    public List<Topic> getAllTopics() {
        return new ArrayList<>(topics.values());
    }

    @Override
    public boolean updateTopic(Topic topic) {
        if (topic == null || !topics.containsKey(topic.getId())) {
            return false;
        }

        topic.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        topics.put(topic.getId(), topic);
        return true;
    }

}
