package model;

public class Robot {
    private Long id;
    private String name;
    private String type;
    private String serialNumber;
    private Long supervisorId;

    private Position position = new Position();
    private double speed = 5.0; // in meters per secondes
    private double battery = 100.0; // in percentage
    private double processorUsage = 10.0; // in percentage
    private double memoryUsage = 10.0; // in percentage

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisor(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public double getProcessorUsage() {
        return processorUsage;
    }

    public void setProcessorUsage(double processorUsage) {
        this.processorUsage = processorUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Robot() {
    }

    public Robot(String name, String type, String serialNumber, Long supervisorId) {
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.supervisorId = supervisorId;
    }
}
