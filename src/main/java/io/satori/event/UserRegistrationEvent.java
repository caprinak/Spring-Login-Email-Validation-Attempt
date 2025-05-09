package io.satori.event;

import org.springframework.context.ApplicationEvent;

import io.satori.model.ApplicationUser;

public class UserRegistrationEvent extends ApplicationEvent {

	private static final long serialVersionUID = -2685172945219633123L;
	
	private ApplicationUser applicationUser;

    public UserRegistrationEvent(ApplicationUser applicationUser) {
        super(applicationUser);
        this.applicationUser = applicationUser;
    }

    public ApplicationUser getUser() {
        return applicationUser;
    }
}
