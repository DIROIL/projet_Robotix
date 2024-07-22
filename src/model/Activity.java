package model;

import enumeration.Status;

import java.util.ArrayList;
import java.util.List;

public class Activity {
    private Long id;
    private String name;
    private Status status;
    private List<Long> subscriberIds = new ArrayList<>();
    private List<Interest> interests = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }

    public List<Long> getSubscriberIds() {
        return subscriberIds;
    }

    public void setSubscriberIds(List<Long> subscriberIds) {
        this.subscriberIds = subscriberIds;
    }

    public Activity() {
    }

    public Activity(Long id, String name, Status status, List<Interest> interests) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.interests = interests;
    }
}
