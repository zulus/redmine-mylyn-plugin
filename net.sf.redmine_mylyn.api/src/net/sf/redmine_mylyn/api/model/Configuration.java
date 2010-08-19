package net.sf.redmine_mylyn.api.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.sf.redmine_mylyn.api.exception.RedmineApiErrorException;
import net.sf.redmine_mylyn.api.model.container.AbstractPropertyContainer;
import net.sf.redmine_mylyn.api.model.container.CustomFields;
import net.sf.redmine_mylyn.api.model.container.IssueCategories;
import net.sf.redmine_mylyn.api.model.container.IssuePriorities;
import net.sf.redmine_mylyn.api.model.container.IssueStatuses;
import net.sf.redmine_mylyn.api.model.container.Projects;
import net.sf.redmine_mylyn.api.model.container.Queries;
import net.sf.redmine_mylyn.api.model.container.TimeEntryActivities;
import net.sf.redmine_mylyn.api.model.container.Trackers;
import net.sf.redmine_mylyn.api.model.container.Users;
import net.sf.redmine_mylyn.api.model.container.Versions;

public class Configuration implements Serializable{

	private static final long serialVersionUID = 1L;

	private IssueStatuses issueStatuses;

	private IssueCategories issueCategories;
	
	private IssuePriorities issuePriorities;
	
	private CustomFields customFields;
	
	private Trackers trackers;

	private Users user;
	
	private TimeEntryActivities timeEntryActivities;
	
	private Queries queries;

	private Projects projects;
	
	private Versions versions;
	
	private Settings settings;

	
	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public void setPropertyContainer(AbstractPropertyContainer<? extends Property> container) throws RedmineApiErrorException {
		try {
			for (Field field : getClass().getDeclaredFields()) {
				if (field.getType().equals(container.getClass())) {
					field.set(this, container);
				}
			}
		} catch (Exception e) {
			throw new RedmineApiErrorException("Updating Attributes failed", e);
		}
	}
	
	public void copy(Configuration conf) throws RedmineApiErrorException {
		try {
			for (Field field : getClass().getDeclaredFields()) {
				if ((field.getModifiers()&Modifier.STATIC)!=Modifier.STATIC) {
					field.set(this, field.get(conf));
				}
			}
		} catch (Exception e) {
			throw new RedmineApiErrorException("Updating Attributes failed", e);
		}
	}

	public IssueStatuses getIssueStatuses() {
		if(issueStatuses==null) {
			issueStatuses = new IssueStatuses();
		}
		return issueStatuses;
	}

	public IssueCategories getIssueCategories() {
		if(issueCategories==null) {
			issueCategories = new IssueCategories();
		}
		return issueCategories;
	}
	
	public IssuePriorities getIssuePriorities() {
		if(issuePriorities==null) {
			issuePriorities = new IssuePriorities();
		}
		return issuePriorities;
	}
	
	public Trackers getTrackers() {
		if(trackers==null) {
			trackers = new Trackers();
		}
		return trackers;
	}
	
	public CustomFields getCustomFields() {
		if(customFields==null) {
			customFields = new CustomFields();
		}
		return customFields;
	}
	
	public Users getUsers() {
		if(user==null) {
			user = new Users();
		}
		return user;
	}
	
	public TimeEntryActivities getTimeEntryActivities() {
		if(timeEntryActivities==null) {
			timeEntryActivities = new TimeEntryActivities();
		}
		return timeEntryActivities;
	}
	
	public Queries getQueries() {
		if(queries==null) {
			queries = new Queries();
		}
		return queries;
	}
	
	public Projects getProjects() {
		if(projects==null) {
			projects = new Projects();
		}
		return projects;
	}
	
	public Versions getVersions() {
		if(versions==null) {
			versions = new Versions();
		}
		return versions;
	}

}