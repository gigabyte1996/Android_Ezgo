package com.example.laptop88.ezgo.Singleton;

import com.example.laptop88.ezgo.response.Steamer;
import com.example.laptop88.ezgo.response.Train;
import com.example.laptop88.ezgo.response.TrainSchedule;

import java.util.ArrayList;
import java.util.List;

public class CurrentTrainSchedule {
    public static CurrentTrainSchedule currentTrainSchedule;
    public List<TrainSchedule> listReturn= new ArrayList<>();
    public List<TrainSchedule> listSingle = new ArrayList<>();
    public TrainSchedule departureSchedule = new TrainSchedule();
    public Steamer steamer = new Steamer();


    public static CurrentTrainSchedule getInstance()
    {
        if(currentTrainSchedule==null)
            currentTrainSchedule = new CurrentTrainSchedule();
        return  currentTrainSchedule;
    }

    public TrainSchedule getDepartureSchedule() {
        return departureSchedule;
    }

    public void setDepartureSchedule(TrainSchedule departureSchedule) {
        this.departureSchedule = departureSchedule;
    }

    public List<TrainSchedule> getListReturn() {
        return listReturn;
    }

    public void setListReturn(List<TrainSchedule> listReturn) {
        this.listReturn = listReturn;
    }

    public List<TrainSchedule> getListSingle() {
        return listSingle;
    }

    public void setListSingle(List<TrainSchedule> listSingle) {
        this.listSingle = listSingle;
    }

    public Steamer getSteamer() {
        return steamer;
    }

    public void setSteamer(Steamer steamer) {
        this.steamer = steamer;
    }
}

