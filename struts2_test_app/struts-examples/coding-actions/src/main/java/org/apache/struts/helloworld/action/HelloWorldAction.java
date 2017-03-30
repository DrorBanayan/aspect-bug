package org.apache.struts.helloworld.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts.helloworld.model.MessageStore;
import org.apache.struts.helloworld.model.User;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Acts as a Struts 2 controller that responds
 * to a user action by setting the value
 * of the Message model class, and returns a String 
 * result.
 * @author Bruce Phillips
 *
 */
public class HelloWorldAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;
	
	/**
	 * The model class that stores the message
	 * to display in the view.
	 */
	private MessageStore messageStore;

    private User user;

	private static int helloCount = 0;

    private String userName;
    private int userAge;


    private HttpServletRequest httpRequest;
	

	/*
	 * Creates the MessageStore model object, 
	 * increase helloCount by 1 and 
	 * returns success.  The MessageStore model
	 * object will be available to the view.
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		
		messageStore = new MessageStore() ;
		String method = httpRequest.getMethod();

		//Action included a query string parameter of userName
		//or a form field with name of userName
		if (userName != null) {
			
			messageStore.setMessage( messageStore.getMessage() + " " + userName + " " );
			
		}
		user = new User();
        user.setName(userName);
        user.setAge(userAge);
		helloCount++;

		return SUCCESS;
	}


    //simple validation
    public void validate(){
        addActionMessage("actionmessage tag. The user is " + userName);
    }

    public MessageStore getMessageStore() {
		return messageStore;
	}

	public void setMessageStore(MessageStore messageStore) {
		this.messageStore = messageStore;
	}

    public int getHelloCount() {
        return helloCount;
    }

    public void setHelloCount(int helloCount) {
        HelloWorldAction.helloCount = helloCount;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setServletRequest(HttpServletRequest request) {
        this.httpRequest = request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

}
