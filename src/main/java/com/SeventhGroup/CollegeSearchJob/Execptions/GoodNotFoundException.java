package com.SeventhGroup.CollegeSearchJob.Execptions;

public class GoodNotFoundException extends SecondRuntimeException {

    private String noFoundId;

    public GoodNotFoundException(String message, String noFoundId) {
        super(message);
        this.noFoundId = noFoundId;
    }

    @Override
    public String getMessage() {
        return "招聘" + this.noFoundId + "未找到";
    }
}
