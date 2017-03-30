package org.apache.struts.helloworld.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class ErrorAction extends ActionSupport implements ServletRequestAware {

    private HttpServletRequest httpRequest;

    private String errorMessage;

    public void setServletRequest(HttpServletRequest request) {
        this.httpRequest = request;
    }


    public String execute() {
        String method = httpRequest.getMethod();
        return SUCCESS;
    }

    //simple validation
    public void validate(){
        addActionError("error message: " + errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
