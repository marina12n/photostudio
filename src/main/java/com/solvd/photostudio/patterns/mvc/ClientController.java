package com.solvd.photostudio.patterns.mvc;

public class ClientController {
    private Client model;
    private ClientView view;

    public ClientController(Client model, ClientView view) {
        this.model = model;
        this.view = view;
    }

    public void setClientName(String name) {
        model.setName(name);
    }

    public String getClientName() {
        return model.getName();
    }

    public void setClientAge(int age) {
        model.setAge(age);
    }

    public int getClientAge() {
        return model.getAge();
    }

    public void updateView() {
        view.printClientDetails(model.getName(), model.getAge());
    }
}

