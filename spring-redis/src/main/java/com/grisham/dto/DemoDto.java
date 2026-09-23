package com.grisham.dto;

public class DemoDto {

    public DemoDto() {
    }

    public DemoDto(String message, Integer demoId) {
        this.message = message;
        this.demoId = demoId;
    }

    private String message;
    private Integer demoId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getDemoId() {
        return demoId;
    }

    public void setDemoId(Integer demoId) {
        this.demoId = demoId;
    }
}
