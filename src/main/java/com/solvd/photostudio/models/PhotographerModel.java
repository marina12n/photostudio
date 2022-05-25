package com.solvd.photostudio.models;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class PhotographerModel {
    private static final Logger LOGGER = LogManager.getLogger(PhotographerModel.class);
    private int id;
    private String name;
    private CameraModel cameraModel;
    private List<ScheduleModel> scheduleModels;

    public PhotographerModel() {
    }

    public PhotographerModel(String name, CameraModel cameraModel, List<ScheduleModel> scheduleModels) {
        this.setName(name);
        this.setCameraModel(cameraModel);
        this.setScheduleModels(scheduleModels);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ScheduleModel> getScheduleModels() {
        return scheduleModels;
    }

    public void setScheduleModels(List<ScheduleModel> scheduleModels) {
        this.scheduleModels = scheduleModels;
    }

    public CameraModel getCameraModel() {
        return cameraModel;
    }

    public void setCameraModel(CameraModel cameraModel) {
        this.cameraModel = cameraModel;
    }

    @Override
    public String toString() {
        return "Photographer: {" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", camera=" + getCameraModel() + '\'' +
                ", schedules=" + getScheduleModels() +
                '}';
    }
}
