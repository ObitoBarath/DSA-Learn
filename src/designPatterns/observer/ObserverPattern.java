package designPatterns.observer;


import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update (String title);
}

interface Subject{
    void subscribe(Observer observer);
    void unSubscribe(Observer observer);
    void notifyObservers(String title);
}


class YoutubeChannel implements  Subject{

    private List<Observer> subscribers = new ArrayList<>();
    private String channelName;

    public YoutubeChannel(String channelName){
        this.channelName = channelName;
    }

    public Integer getSubscribersCount(){
        return subscribers.size();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
        System.out.println(observer + " subscribed to "+  this.channelName);
    }

    @Override
    public void unSubscribe(Observer observer) {
        subscribers.remove(observer);
        System.out.println(observer + " un-subscribed to "+  this.channelName);
    }

    @Override
    public void notifyObservers(String title) {
        subscribers.forEach(subscriber -> subscriber.update(title));
    }


    public void uploadVideo(String videoTitle){
        System.out.println("New video uploaded as " +videoTitle);
            notifyObservers(videoTitle);
    }
}


class User implements  Observer{

    String name;

    User(String name){
        this.name = name;
    }

    @Override
    public void update(String title) {
        System.out.println(name + " received notification: New video uploaded - " + title);
    }


    @Override
    public String toString(){
        return "User  = " + this.name;
    }
}



public class ObserverPattern {


    public static void main(String[] args) {
        Observer user1 = new User("Barath");
        Observer user2 = new User("Fasith");

        YoutubeChannel youtubeChannel = new YoutubeChannel("BACHELORS COOKING CHANNEL");

        youtubeChannel.subscribe(user1);
        youtubeChannel.subscribe(user2);


        youtubeChannel.uploadVideo("BRIYANI DISH");

//        youtubeChannel.unSubscribe(user2);

        Integer subscribersCount = youtubeChannel.getSubscribersCount();
        System.out.println("subscribersCount = " + subscribersCount);

    }
}
