package pokersite.model.dao;

import pokersite.model.entity.Issue;

public class IssueDAO extends GenericDAO<Issue> {
    public IssueDAO() {
        super(Issue.class);
    }
}